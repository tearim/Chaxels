package com.zarterstein.chaxels.helpers;

/**
 * Helper class for RGB color manipulation and blending.
 */
public class RgbActions {
    /**
     * Parses an RGB string (R;G;B) into an integer array.
     * @param source RGB string.
     * @return RGB array [R, G, B].
     */
    public static int[] strToRGB(String source) {
        String[] split = source.split("m")[0].split(";", 3);
        int[] rgb = new int[3];
        try {
            rgb[0] = Integer.parseInt(split[0]);
            rgb[1] = Integer.parseInt(split[1]);
            rgb[2] = Integer.parseInt(split[2]);
        }  catch (NumberFormatException e) {
            rgb[0] = rgb[1] = rgb[2] = 0;
        }
        return rgb;
    }

    /**
     * Blends two colors based on opacity.
     * @param background Background color array.
     * @param dye Foreground color array.
     * @param opacity Opacity of foreground (0.0 to 1.0).
     * @return Blended color array.
     */
    public static int[] applyRGBToRGBWithOpacity(int[] background, int[] dye, float opacity) {
        if ( opacity >= 1 ) {
            return dye;
        }
        if ( opacity <= 0 ) {
            return background;
        }
        int[] result = new int[background.length];
        for ( int i = 0; i < background.length; i++ ) {
            float delta = dye[i] - background[i];
            result[i] = background[i] + Math.round(delta * opacity);
        }
        return result;
    }
}
