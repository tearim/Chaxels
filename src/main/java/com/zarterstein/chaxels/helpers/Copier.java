package com.zarterstein.chaxels.helpers;

import com.zarterstein.chaxels.Chaxel;
import com.zarterstein.chaxels.ChaxelString;


/**
 * Utility for performing deep copies of Chaxels and ChaxelStrings.
 */
public class Copier {

    /**
     * Creates a deep copy of a ChaxelString.
     * @param chaxels Source ChaxelString.
     * @return New ChaxelString copy.
     */
    public static ChaxelString copy(ChaxelString chaxels) {
        ChaxelString copyString = new ChaxelString();
        for ( Chaxel chaxel : chaxels) {
            copyString.add(copy(chaxel));
        }
        return copyString;
    }

    /**
     * Creates a deep copy of a single Chaxel.
     * @param chaxel Source Chaxel.
     * @return New Chaxel copy.
     */
    public static Chaxel copy(Chaxel chaxel) {
        if ( chaxel == null ) {
            return null;
        }
        Chaxel copy = new Chaxel(chaxel.getChar(), chaxel.getRGB(), chaxel.getBRGB(), chaxel.getZIndex(), chaxel.getEffects());
        copy.setTransparent(chaxel.isTransparent());
        copy.setColorless(chaxel.isColorless());
        copy.setBgColorless(chaxel.isBgColorless());
        copy.setAfterClear(chaxel.getAfterClear());
        copy.setRgbOpacity(chaxel.getRgbOpacity());
        copy.setbRgbOpacity(chaxel.getbRgbOpacity());
        return copy;
    }

}
