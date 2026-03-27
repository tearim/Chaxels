package com.zarterstein.chaxels.helpers;

/**
 * Safe string manipulation utilities that prevent IndexOutOfBoundsExceptions.
 */
public class SafeSubStrings {
    /**
     * Safely returns a character at a position, or null char if out of bounds.
     * @param s The string.
     * @param pos Position.
     * @return Character or '\0'.
     */
    public static char safeCharAt(String s, int pos) {
        if ( pos > -1 && pos < s.length() ) {
            return s.charAt(pos);
        }
        return (char)0;
    }

    /**
     * Safely returns a substring, clipping at the end of the string.
     * @param s The string.
     * @param beg Start index.
     * @param len Length.
     * @return Substring.
     */
    public static String safeSubStr(String s, int beg, int len) {
        return s.substring(beg, Math.min(beg + len,  s.length() ));
    }

    /**
     * Creates a string of specified length filled with spaces.
     * @param l Desired length.
     * @return Space-filled string.
     */
    public static String createStringOfLength(int l) {
        return new String (new char[l]).replace('\0', ' ');
    }
}
