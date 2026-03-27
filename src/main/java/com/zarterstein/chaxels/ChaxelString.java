package com.zarterstein.chaxels;

import com.zarterstein.ansifansi.Fansi;
import com.zarterstein.chaxels.helpers.Converter;
import com.zarterstein.chaxels.helpers.Printer;
import com.zarterstein.chaxels.helpers.Copier;

import java.util.ArrayList;

/**
 * Represents a row or string of Chaxel objects.
 * <p>
 * NOTE: This class extends {@link ArrayList}, which provides a wide range of collection operations.
 * Users should use these with care to maintain the intended structure of the string.
 * </p>
 */
public class ChaxelString extends ArrayList<Chaxel> {
    /**
     * Constructs an empty ChaxelString.
     */
    public ChaxelString() {
        super();
    }

    public ChaxelString(Fansi fansiString ) {
        super(Converter.toChaxels(fansiString.render()));
    }

    /**
     * Constructs a ChaxelString from a String.
     * @param string The input string.
     */
    public ChaxelString(String string ) {
        super(Converter.toChaxels(string));
    }

    public ChaxelString(ChaxelString oldChaxelString) {
        super(oldChaxelString);
    }

    public static ChaxelString fromChaxel(Chaxel chaxel) {
        ChaxelString chaxelString = new ChaxelString();
        chaxelString.add(Copier.copy(chaxel));
        return chaxelString;
    }

    /**
     * Sets the Z-index for all Chaxels in this string.
     * @param zIndex The new Z-index.
     * @return This ChaxelString for chaining.
     */
    public ChaxelString setZIndex(float zIndex) {
        for ( Chaxel chaxel : this ) {
            chaxel.setZIndex(zIndex);
        }
        return this;
    }
    public ChaxelString setRgb(String rgb) {
        return setRGBfor(false, rgb);
    }
    public ChaxelString setBgRgb(String rgb) {
        return setRGBfor(true, rgb);
    }
    private ChaxelString setRGBfor(boolean forBackground, String rgb) {
        int[] nrgb = new int[3];
        String[] rgbs = rgb.split(";");
        for (int i = 0; i < rgbs.length; i++) {
            nrgb[i] = Integer.parseInt(rgbs[i]);
        }
        if (forBackground ) {
            setBgRgb(nrgb);
        } else {
            setRgb(nrgb);
        }

        return this;
    }
    public ChaxelString setRgb(int[] rgb) {
        for ( Chaxel chaxel : this ) {
            chaxel.setRed(rgb[0]);
            chaxel.setGreen(rgb[1]);
            chaxel.setBlue(rgb[2]);
        }
        return this;
    }

    public ChaxelString setBgRgb(int[] rgb) {
        for ( Chaxel chaxel : this ) {
            chaxel.setBgRed(rgb[0]);
            chaxel.setBgGreen(rgb[1]);
            chaxel.setBgBlue(rgb[2]);
        }
        return this;
    }

    public ChaxelString setRed(int red) {
        for ( Chaxel chaxel : this ) {
            chaxel.setRed(red);
        }
        return this;
    }
    public ChaxelString setGreen(int green) {
        for ( Chaxel chaxel : this ) {
            chaxel.setGreen(green);
        }
        return this;
    }
    public ChaxelString setBlue(int blue) {
        for ( Chaxel chaxel : this ) {
            chaxel.setBlue(blue);
        }
        return this;
    }

    public ChaxelString setBgRed(int bgRed) {
        for ( Chaxel chaxel : this ) {
            chaxel.setBgRed(bgRed);
        }
        return this;
    }
    public ChaxelString setBgGreen(int bgGreen) {
        for ( Chaxel chaxel : this ) {
            chaxel.setBgGreen(bgGreen);
        }
        return this;
    }
    public ChaxelString setBgBlue(int bgBlue) {
        for ( Chaxel chaxel : this ) {
            chaxel.setBgBlue(bgBlue);
        }
        return this;
    }
    public ChaxelString setEffects(String effects) {
        for ( Chaxel chaxel : this ) {
            chaxel.setEffects(effects);
        }
        return this;
    }
    public ChaxelString setEffects(String[] effects) {
        String effectsString = String.join("", effects);
        for ( Chaxel chaxel : this ) {
            chaxel.setEffects(effectsString);
        }
        return this;
    }
    /**
     * Writes another ChaxelString onto this one at a specified position.
     * @param newString The ChaxelString to write.
     * @param startPos The starting position.
     * @param ignoreZIndexesAndTheMergeToZeroZIndex If true, overrides Z-indexes to force writing.
     * @return This ChaxelString for chaining.
     */
    public ChaxelString writeOn(ChaxelString newString, int startPos, boolean ignoreZIndexesAndTheMergeToZeroZIndex ) {
        if ( ignoreZIndexesAndTheMergeToZeroZIndex ) {
            newString.setZIndex(1);
            this.setZIndex(0);
        }
        return Printer.printOver(this, newString,  startPos, false, true, true, true);
    }
    public ChaxelString writeOn(ChaxelString newString, int startPos ) {
        return Printer.printOver(this, newString,  startPos, false, true, true, true);
    }

    public ChaxelString writeOn(String newString, int startPos) {
        return writeOn(Converter.toChaxels(newString), startPos);
    }
    /**
     * Applies text characters to existing Chaxels in this string.
     * @param text The text to apply.
     * @return This ChaxelString for chaining.
     */
    public ChaxelString applyText(String text ) {
        for ( int i = 0; i < text.length(); i++ ) {
            safeAt(i).setChar(text.charAt(i));
        }
        return this;
    }
    /**
     * Applies a transparency mask where spaces in the mask make Chaxels transparent.
     * @param stringMask The mask string.
     * @return This ChaxelString for chaining.
     */
    public  ChaxelString applyCharacterTransparencyMask(String stringMask) {
        boolean[] mask = new boolean[stringMask.length()];
        for ( int i = 0; i < stringMask.length(); i++ ) {
            switch (stringMask.charAt(i)) {
                case ' ':
                    mask[i] = true;
                    break;
                default:
                    mask[i] = false;
                    break;
            }
        }
        return applyCharacterTransparencyMask(mask);
    }
    public ChaxelString applyCharacterTransparencyMask(boolean[] mask) {
        int i = 0;
        for ( boolean b : mask ) {
            safeAt(i).setTransparent(b);
            i++;
        }
        return this;
    }

    private float getOpacityFromMaskingChar(char c) {
        return switch (c) {
            case '0', ' ' -> 0;
            case 'f', 'F' -> 1.0f;
            case '9', '8', '7', '6', '5', '4', '3', '2', '1' -> Float.parseFloat(String.valueOf(c)) / 10;
            default -> 1;
        };
    }
    /**
     * Applies foreground RGB opacity mask based on characters ('0'-'9', 'f').
     * @param mask The mask string.
     * @return This ChaxelString for chaining.
     */
    public ChaxelString applyRgbOpacityMask(String mask) {
        for ( int i = 0; i < mask.length(); i++ ) {
            float opacity = getOpacityFromMaskingChar(mask.charAt(i));
            safeAt(i).setRgbOpacity(opacity);
        }
        return this;
    }

    /**
     * Applies background RGB opacity mask based on characters ('0'-'9', 'f').
     * @param mask The mask string.
     * @return This ChaxelString for chaining.
     */
    public ChaxelString applyBgRgbOpacityMask(String mask) {
        for ( int i = 0; i < mask.length(); i++ ) {
            float opacity = getOpacityFromMaskingChar(mask.charAt(i));
            safeAt(i).setbRgbOpacity(opacity);
        }
        return this;
    }

    public ChaxelString applyOpacityMask(String mask ) {
        for ( int i = 0; i < mask.length(); i++ ) {
            float opacity = getOpacityFromMaskingChar(mask.charAt(i));
            safeAt(i).setRgbOpacity(opacity);
            safeAt(i).setbRgbOpacity(opacity);
        }
        return this;
    }


    /** 
     * Provides safe access to Chaxels within the string. 
     * <p>
     * NOTE: This is designed to act as a "black hole" for indices out of bounds, 
     * returning a dummy Chaxel to simplify copy/read processes without constant 
     * bounds checking or risk of {@link IndexOutOfBoundsException}.
     * </p>
     * @param i Index of the Chaxel.
     * @return The Chaxel at the index, or a dummy "blank" Chaxel if out of bounds.
     **/
    public Chaxel safeAt(int i) {
        if ( i < 0 || i > this.size() -1  )
            return new Chaxel(' ');
        return this.get(i);
    }

    /**
     *  Accesses a Chaxel at the specified index. Returns null if out of bounds.
     *  @param i Index.
     *  @return Chaxel or null.
     *  */
    public Chaxel at(int i) {
        if ( i < 0 || i > this.size() )
            return null;
        return this.get(i);
    }

}
