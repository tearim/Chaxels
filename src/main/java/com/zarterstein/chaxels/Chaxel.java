package com.zarterstein.chaxels;

import com.zarterstein.ansifansi.Fansi;

/**
 * Represents a single character "pixel" (Chaxel) with foreground/background colors, 
 * Z-index for layering, and ANSI text effects.
 */
public class Chaxel {
    public static final String EFFECTS_CLEAR = Fansi.ESC_B + Fansi.EFF_RESET + Fansi.ESC_E;
    public static final String EFFECT_BOLD = Fansi.ESC_B + Fansi.EFF_BOLD + Fansi.ESC_E;
    public static final String EFFECT_ITALIC = Fansi.ESC_B + Fansi.EFF_ITALIC + Fansi.ESC_E;
    public static final String EFFECT_UNDERLINE = Fansi.ESC_B + Fansi.EFF_UNDERLINE + Fansi.ESC_E;
    public static final String EFFECT_STRIKETHROUGH = Fansi.ESC_B + Fansi.EFF_STRIKETHROUGH + Fansi.ESC_E;
    public final static String FG_COLOR_CODE = "38;2;";
    public final static String BG_COLOR_CODE = "48;2;";
    public final static char ESCAPE_CHAR = 27;

    private Character character;
    private Float zIndex;
    private int red, green, blue;
    private int bgRed, bgGreen, bgBlue;
    private String effects;
    private String afterClear;
    public static final String CLEAR_EFFECTS = "clear_all_effects";
    private boolean noColors;
    private boolean noBgColors;
    private boolean transparent;
    private float rgbOpacity;
    private float bRgbOpacity;
    /**
     * Constructs a Chaxel with a single character and default colors and Z-index.
     * @param cha The character to represent.
     */
    public Chaxel(Character cha) {
        this.character = cha;
        defInit();
    }

    /**
     * Constructs a Chaxel with character, foreground, background, and Z-index.
     * @param cha The character.
     * @param rgb Foreground RGB array.
     * @param bRgb Background RGB array.
     * @param zIndex Z-index for layering.
     */
    public Chaxel(Character cha, int[] rgb, int[] bRgb, float zIndex) {
        this.character = cha;
        red = rgb[0];
        green = rgb[1];
        blue = rgb[2];
        bgRed = bRgb[0];
        bgGreen = bRgb[1];
        bgBlue = bRgb[2];
        this.zIndex = zIndex;
        effects = afterClear = "";
        rgbOpacity = bRgbOpacity = 1;
    }

    /**
     * Constructs a Chaxel with character, foreground, background, Z-index, and ANSI effects.
     * @param cha The character.
     * @param rgb Foreground RGB array.
     * @param bRgb Background RGB array.
     * @param zIndex Z-index for layering.
     * @param effects ANSI effects string.
     */
    public Chaxel(Character cha, int[] rgb, int[] bRgb, float zIndex, String effects) {
        this(cha, rgb, bRgb, zIndex);
        this.effects = effects;
    }
    /**
     * Sets the foreground color components from an RGB array.
     * @param rgb An array containing red, green, and blue values.
     */
    public void setRGB(int[] rgb) {
        red = rgb[0];
        green = rgb[1];
        blue = rgb[2];
        noColors = false;
    }

    /**
     * Sets the background color components from an RGB array.
     * @param bRgb An array containing red, green, and blue background values.
     */
    public void setBRGB(int[] bRgb) {
        bgRed = bRgb[0];
        bgGreen = bRgb[1];
        bgBlue = bRgb[2];
        noBgColors = false;
    }

    private void readForegroundColors(String str ) {
        String[] bits = str.split("m")[0].split(";", 3);
        try {
            red = Integer.parseInt(bits[0]);
            green = Integer.parseInt(bits[1]);
            blue = Integer.parseInt(bits[2]);
            noColors = false;
        }  catch (NumberFormatException e) {
            //
        }

    }

    private void readBackgroundColors(String str ) {
        String[] bits = str.split("m")[0].split(";", 3);
        try {
            bgRed = Integer.parseInt(bits[0]);
            bgGreen = Integer.parseInt(bits[1]);
            bgBlue = Integer.parseInt(bits[2]);
            noBgColors = false;
        }  catch (NumberFormatException e) {
            //
        }
    }

    private void defInit() {
        red = 255;
        green = 255;
        blue = 255;
        bgRed = 0;
        bgGreen = 0;
        bgBlue = 0;
        zIndex = 0.0f;
        effects = afterClear ="";
        rgbOpacity = bRgbOpacity = 1;
    }
    /**
     * Returns the character represented by this Chaxel.
     * @return The character.
     */
    public Character getChar() {
        return character;
    }

    /**
     * Sets the character for this Chaxel.
     * @param character The new character.
     */
    public void setChar(Character character) {
        this.character = character;
    }

    /**
     * Returns the Z-index for layering.
     * @return The Z-index value.
     */
    public Float getZIndex() {
        return zIndex;
    }
    /**
     * Sets the Z-index for layering.
     * @param zIndex The new Z-index.
     */
    public void setZIndex(Float zIndex) {
        this.zIndex = zIndex;
    }

    public int getRed() {
        return red;
    }
    public void setRed(int r) {
        noColors = false;
        this.red = r;
    }
    public int getGreen() {
        return green;
    }
    public void setGreen(int g) {
        noColors = false;
        this.green = g;
    }
    public int getBlue() {
        return blue;
    }
    public void setBlue(int b) {
        noColors = false;
        this.blue = b;
    }
    public int getBgRed() {
        return bgRed;
    }
    public void setBgRed(int bR) {
        noBgColors = false;
        this.bgRed = bR;
    }
    public int getBgGreen() {
        return bgGreen;
    }
    public void setBgGreen(int bG) {
        noBgColors = false;
        this.bgGreen = bG;
    }
    public int getBgBlue() {
        return bgBlue;
    }
    public void setBgBlue(int bB) {
        noBgColors = false;
        this.bgBlue = bB;
    }

    public int[] getRGB() {
        return new int[]{red, green, blue};
    }

    public int[] getBRGB() {
        return new int[]{bgRed, bgGreen, bgBlue};
    }

    /**
     * Sets the ANSI effects string directly.
     * @param effects The new effects string.
     */
    public void setEffects(String effects) {
        this.effects = effects;
    }

    /**
     * Returns the current ANSI effects string.
     * @return The effects string.
     */
    public String getEffects() {
        return effects;
    }

    public boolean isBold() {
        return effects.contains(EFFECT_BOLD );
    }
    public boolean isItalic() {
        return effects.contains(EFFECT_ITALIC);
    }
    public boolean isUnderline() {
        return effects.contains(EFFECT_UNDERLINE );
    }
    public boolean isStrikeThrough() {
        return effects.contains(EFFECT_STRIKETHROUGH );
    }
    public boolean hasReset() {
        return effects.contains(EFFECTS_CLEAR );
    }
    public boolean hasEffect(String effect) {
        return effects.contains(effect);
    }

    /**
     * Returns a string containing the ANSI escape codes for the foreground and background colors.
     * @return The ANSI color sequence.
     */
    public String getPrintableColors() {
        return  new StringBuilder((
                        noColors
                        ? ""
                        : new StringBuilder()
                                .append(Fansi.ESC_B).append(FG_COLOR_CODE)
                                .append(red).append(";").append(green).append(";").append(blue)
                                .append(Fansi.ESC_E)
                        )
                ).append(
                        noBgColors
                        ? ""
                        : new StringBuilder()
                                .append(Fansi.ESC_B).append(BG_COLOR_CODE)
                                .append(bgRed).append(";").append(bgGreen).append(";").append(bgBlue)
                                .append(Fansi.ESC_E)
                ).toString();

    }
    /**
     * Applies a specific ANSI effect (e.g., bold, italic, or reset) to this Chaxel.
     * @param effect The effect code or CLEAR_EFFECTS constant.
     */
    public void setEffect (String effect ) {
        switch (effect) {
            case CLEAR_EFFECTS:
                effects = "";
                break;
            case Fansi.EFF_RESET:
                red = green = blue = 255;
                bgRed = bgGreen = bgBlue = 0;
                effects = Fansi.ESC_B + Fansi.EFF_RESET + Fansi.ESC_E;
                break;
            case Fansi.EFF_BOLD:
            case Fansi.EFF_FAINT:
            case Fansi.EFF_ITALIC:
            case Fansi.EFF_UNDERLINE:
            case Fansi.EFF_SLOWBLINK:
            case Fansi.EFF_RAPIDBLINK:
            case Fansi.EFF_INVERSE:
            case Fansi.EFF_CONCEAL:
            case Fansi.EFF_STRIKETHROUGH:
                effects = effects.replace(Fansi.ESC_B + Fansi.EFF_RESET + Fansi.ESC_E, "") +
                                (effects.contains(Fansi.ESC_B + effect + Fansi.ESC_E)
                                ?""
                                : Fansi.ESC_B + effect + Fansi.ESC_E);
        }
    }

    public boolean isColorless() {
        return noColors;
    }
    public boolean isBgColorless() {
        return noBgColors;
    }
    public void setColorless ( boolean noColors ) {
        this.noColors = noColors;
    }
    public void setBgColorless ( boolean noColors ) {
        this.noBgColors = noColors;
    }
    public void setAfterClear (String afterClear) {
        this.afterClear = afterClear;
    }
    public String getAfterClear () {
        return afterClear;
    }

    /**
     * Sets the transparency state. If true, the character from the layer below may be used.
     * @param transparent True if transparent.
     */
    public void setTransparent(boolean transparent) {
        this.transparent = transparent;
    }

    public boolean isTransparent() {
        return transparent;
    }

    /**
     * Sets the foreground RGB opacity for blending.
     * @param BRGBOpacity Opacity value (0.0 to 1.0).
     */
    public void setRgbOpacity(float BRGBOpacity) {
        this.rgbOpacity = BRGBOpacity;
    }

    public float getRgbOpacity() {
        return rgbOpacity;
    }

    /**
     * Sets the background RGB opacity for blending.
     * @param bRgbOpacity Opacity value (0.0 to 1.0).
     */
    public void setbRgbOpacity(float bRgbOpacity) {
        this.bRgbOpacity = bRgbOpacity;
    }

    public float getbRgbOpacity() {
        return bRgbOpacity;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(getEffects()).append(getPrintableColors()).append(character).append(afterClear).toString();

    }
}
