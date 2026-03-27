package com.zarterstein.chaxels.helpers;

import com.zarterstein.ansifansi.Fansi;
import com.zarterstein.chaxels.Chaxel;
import com.zarterstein.chaxels.ChaxelString;

import java.util.List;

/**
 * Handles conversion between text (with ANSI escape codes) and {@link ChaxelString}.
 */
public class Converter {

    /**
     * Converts a simple string to a ChaxelString.
     * @param source The text.
     * @return A ChaxelString.
     */
    public static ChaxelString toChaxels(String source) {
        return toChaxels(source, 0);
    }

    /**
     * Converts a string containing ANSI escape codes into a {@link ChaxelString}.
     * <p>
     * NOTE: This currently does not support TrueColor (24-bit) ANSI sequences. 
     * The parser is only compatible with standard 3/4-bit colors and basic text effects.
     * </p>
     * @param source The text source to convert.
     * @param zIndex Initial Z-index for the resulting Chaxels.
     * @return A ChaxelString representation of the input.
     */
    public static ChaxelString toChaxels(String source, float zIndex) {
        ChaxelString chaxels = new ChaxelString();
        if (source == null || source.isEmpty()) {
            return chaxels;
        }

        boolean inEscape = false;
        int i = 0;
        int[] currentRGB = {255, 255, 255};
        int[] currentBRGB = {0, 0, 0};
        char currentChar;
        boolean clearAfterOneUse = false;
        String currentEffects = "";
        boolean colorless = true;
        boolean colorlessBg = true;
        do {
            if (SafeSubStrings.safeCharAt(source, i) == Chaxel.ESCAPE_CHAR) {
                inEscape = true;
                switch (SafeSubStrings.safeSubStr(source, i + 1, 6)) {
                    case Chaxel.FG_COLOR_CODE:
                        currentRGB = RgbActions.strToRGB(SafeSubStrings.safeSubStr(source, i + 7, 12));
                        colorless = false;
                        break;
                    case Chaxel.BG_COLOR_CODE:
                        currentBRGB = RgbActions.strToRGB(SafeSubStrings.safeSubStr(source, i + 7, 12));
                        colorlessBg = false;
                        break;
                    default:
                        String next2Symbols = SafeSubStrings.safeSubStr(source, i + 2, 2);
                        switch (next2Symbols) {
                            case "0m":
                                currentRGB = new int[]{255, 255, 255};
                                currentBRGB = new int[]{0, 0, 0};
                                currentEffects = Fansi.ESC_B + Fansi.EFF_RESET + Fansi.ESC_E;
                                clearAfterOneUse = true;
                                colorless = true;
                                colorlessBg = true;
                                break;
                            case "1m":
                            case "2m":
                            case "3m":
                            case "4m":
                            case "5m":
                            case "6m":
                            case "7m":
                            case "8m":
                            case "9m":
                                if (!currentEffects.contains(next2Symbols)) {
                                    currentEffects = currentEffects.replace(Fansi.ESC_B + Fansi.EFF_RESET + Fansi.ESC_E, "") + Fansi.ESC_B + next2Symbols;
                                    clearAfterOneUse = false;
                                }

                                break;
                            case Fansi.BG_BLACK:
                                currentBRGB = new int[]{0, 0, 0};
                                colorlessBg = false;
                                break;
                            case Fansi.BG_RED:
                                currentBRGB = new int[]{255, 0, 0};
                                colorlessBg = false;
                                break;
                            case Fansi.BG_GREEN:
                                currentBRGB = new int[]{0, 255, 0};
                                colorlessBg = false;
                                break;
                            case Fansi.BG_YELLOW:
                                currentBRGB = new int[]{255, 255, 0};
                                colorlessBg = false;
                                break;
                            case Fansi.BG_BLUE:
                                currentBRGB = new int[]{0, 0, 255};
                                colorlessBg = false;
                                break;
                            case Fansi.BG_MAGENTA:
                                currentBRGB = new int[]{255, 0, 255};
                                colorlessBg = false;
                                break;
                            case Fansi.BG_CYAN:
                                currentBRGB = new int[]{0, 255, 255};
                                colorlessBg = false;
                                break;
                            case Fansi.BG_WHITE:
                                currentBRGB = new int[]{255, 255, 255};
                                colorlessBg = false;
                                break;
                            case Fansi.BG_DEF:
                                currentBRGB = new int[]{0, 0, 0};
                                colorlessBg = true;
                                break;

                            case Fansi.FG_BLACK:
                                currentRGB = new int[]{0, 0, 0};
                                colorless = false;
                                break;
                            case Fansi.FG_RED:
                                currentRGB = new int[]{255, 0, 0};
                                colorless = false;
                                break;
                            case Fansi.FG_GREEN:
                                currentRGB = new int[]{0, 255, 0};
                                colorless = false;
                                break;
                            case Fansi.FG_YELLOW:
                                currentRGB = new int[]{255, 255, 0};
                                colorless = false;
                                break;
                            case Fansi.FG_BLUE:
                                currentRGB = new int[]{0, 0, 255};
                                colorless = false;
                                break;
                            case Fansi.FG_MAGENTA:
                                currentRGB = new int[]{255, 0, 255};
                                colorless = false;
                                break;
                            case Fansi.FG_CYAN:
                                currentRGB = new int[]{0, 255, 255};
                                colorless = false;
                                break;
                            case Fansi.FG_WHITE:
                                currentRGB = new int[]{255, 255, 255};
                                colorless = false;
                                break;
                            case Fansi.FG_DEF:
                                currentRGB = new int[]{0, 0, 0};
                                colorless = true;
                                break;

                        }
                }
            } else {
                if (!inEscape) {
                    currentChar = SafeSubStrings.safeCharAt(source, i);
                    Chaxel chaxel = new Chaxel(currentChar, currentRGB, currentBRGB, zIndex, currentEffects);
                    chaxel.setColorless(colorless);
                    chaxel.setBgColorless(colorlessBg);
                    chaxels.add(chaxel);
                    if (clearAfterOneUse) {
                        currentEffects = "";
                        clearAfterOneUse = false;
                    }
                }
            }
            if (inEscape) {
                if (SafeSubStrings.safeCharAt(source, i) == 'm') {
                    inEscape = false;
                }
            }
            i++;
        } while (i < source.length());
        return chaxels;
    }

    /**
     * Converts a list of Chaxels back to a simple string.
     * @param chaxels List of Chaxels.
     * @return Plain text string.
     */
    public static String chaxelsToText(List<Chaxel> chaxels) {
        StringBuilder sb = new StringBuilder();
        for (Chaxel chaxel : chaxels) {
            sb.append(chaxel.getChar());
        }
        return sb.toString();
    }

    /**
     * Converts a ChaxelString to an ANSI-escaped string for terminal display.
     * @param chaxels ChaxelString to convert.
     * @return ANSI string.
     */
    public static String escapedString(ChaxelString chaxels) {
        StringBuilder sb = new StringBuilder();
        for (Chaxel chaxel : chaxels) {
                sb.append(chaxel);
        }
        return sb.toString();
    }
}
