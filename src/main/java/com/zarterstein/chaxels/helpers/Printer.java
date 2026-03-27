package com.zarterstein.chaxels.helpers;

import com.zarterstein.ansifansi.Fansi;
import com.zarterstein.chaxels.Chaxel;
import com.zarterstein.chaxels.ChaxelString;

/**
 * Logic for "printing" one {@link ChaxelString} over another, handling layering, 
 * transparency, and effects.
 */
public class Printer {
    /**
     * Blends one ChaxelString over another with detailed control.
     * @param oldChaxels Background string.
     * @param newChaxels Foreground string.
     * @param startPosition Offset.
     * @param ignoreZ If true, ignores Z-index checks.
     * @param clipPrintedText If true, clips output to background size.
     * @param useOldString If true, modifies oldChaxels in place.
     * @param mergeZIndex If true, merges Z-indexes.
     * @return The resulting ChaxelString.
     */
    public static ChaxelString printOver (ChaxelString oldChaxels, ChaxelString newChaxels, int startPosition, boolean ignoreZ, boolean clipPrintedText, boolean useOldString, boolean mergeZIndex) {
        ChaxelString result;
        if ( useOldString) {
            result = oldChaxels;
        } else {
            result = new ChaxelString(oldChaxels);
        }
        if ( startPosition +  newChaxels.size() <= 0 ) {
            return oldChaxels;
        }
        if ( clipPrintedText ) {
            if ( startPosition  > oldChaxels.size() ) {
                return oldChaxels;
            }
        }

        int newChaxelPosition = 0;
        int lastInsertedPosition = 0;
        String currentEffects = "";
        String[] effectArray = new String[10];
        String inheritedEffects = "";
        String[] currentEffectArray;
        for ( int i = startPosition; i < Math.max( newChaxels.size() + startPosition, oldChaxels.size() ); i++ ) {
            newChaxelPosition = i - startPosition;

            if ( i < 0) {
                if (newChaxels.get(newChaxelPosition).getEffects().isEmpty()) {
                    continue;
                }
                currentEffectArray = newChaxels.get(newChaxelPosition).getEffects().split(Fansi.ESC_E);
                for (String effect : currentEffectArray) {
                    int effectPos;
                    try {
                        effectPos = Integer.parseInt(effect.replace(Fansi.ESC_B, ""));
                    } catch (NumberFormatException e) {
                        effectPos = 0;
                    }
                    if (effectPos == 0) {
                        for (int j = 1; j < 10; j++) {
                            effectArray[j] = "";
                        }
                    }
                    effectArray[effectPos] = effect + Fansi.ESC_E;
                    inheritedEffects = String.join("", effectArray[effectPos]);
                }
                continue;
            }


            if ( i <  oldChaxels.size() ) {
                if ( newChaxelPosition < newChaxels.size() ) {
                    if (  newChaxels.get(newChaxelPosition).getZIndex() > oldChaxels.get(i).getZIndex() ) {
                        Chaxel curatedCopy = Copier.copy(newChaxels.get(newChaxelPosition));
                        if (curatedCopy.isTransparent()) {
                            curatedCopy.setChar(oldChaxels.get(i).getChar());
                        }
                        if ( mergeZIndex ) {
                            curatedCopy.setZIndex(oldChaxels.get(i).getZIndex());
                        }
                        curatedCopy.setTransparent(oldChaxels.get(i).isTransparent());
                        curatedCopy.setRGB(RgbActions.applyRGBToRGBWithOpacity(result.get(i).getRGB(), curatedCopy.getRGB(), curatedCopy.getRgbOpacity()));
                        curatedCopy.setRgbOpacity(oldChaxels.get(i).getRgbOpacity());
                        curatedCopy.setBRGB(RgbActions.applyRGBToRGBWithOpacity(result.get(i).getBRGB(), curatedCopy.getBRGB(), curatedCopy.getbRgbOpacity()));
                        curatedCopy.setbRgbOpacity(oldChaxels.get(i).getbRgbOpacity());
                        result.set(i, curatedCopy);

                        if ( !inheritedEffects.isEmpty() ) {
                            result.get(i).setEffects(inheritedEffects);
                            inheritedEffects = "";
                        }
                        lastInsertedPosition = i;
                    }
                } else {
                    if ( !clipPrintedText && i >= oldChaxels.size() ) {
                        if ( !inheritedEffects.isEmpty() ) {
                            result.get(i).setEffects(inheritedEffects);
                            inheritedEffects = "";
                        }
                        result.add(Copier.copy(newChaxels.get(newChaxelPosition)));
                    }
                }
            }
        }
        if ( lastInsertedPosition > 0 ) {
            result.get(lastInsertedPosition).setAfterClear(Fansi.RESET);
        }
        return result;
    }

    public static ChaxelString printOver (ChaxelString oldChaxels, ChaxelString newChaxels, int startPosition ) {
        return printOver(oldChaxels, newChaxels, startPosition, false, true, false, true);
    }
}
