package com.zarterstein.chaxels;

import com.zarterstein.chaxels.helpers.Converter;
import com.zarterstein.chaxels.helpers.Copier;
import com.zarterstein.chaxels.helpers.SafeSubStrings;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Represents a 2D grid of Chaxels.
 */
public class Shape {
    private ArrayList<ChaxelString> rows;
    private final HashMap<Character, ColorInfo> colorTable;
    private int width;

    /**
     * Constructs an empty Shape.
     */
    public Shape() {
        super();
        rows = new ArrayList<>();
        colorTable = new HashMap<>();
    }
    /**
     * Constructs a Shape with given dimensions.
     * @param x Width.
     * @param y Height.
     */
    public Shape(int x, int y) {
        rows = new ArrayList<>();
        colorTable = new HashMap<>();
        reset(x, y);
    }

    public Shape(Shape shape) {
        rows = new ArrayList<>();
        colorTable = new HashMap<>();
        initFromRows(shape.rows);
    }

    public Shape(ArrayList<ChaxelString> newRows) {
        rows = new ArrayList<>();
        colorTable = new HashMap<>();
        initFromRows(newRows);
    }

    private void initFromRows(ArrayList<ChaxelString> newRows) {
        if ( newRows == null) {
            return;
        }
        if (newRows.isEmpty()) {
            return;
        }
        width = newRows.getFirst().size();
        rows.add(Copier.copy(newRows.getFirst()));
        for ( int i = 1; i < newRows.size(); i++ ) {
            rows.add(Copier.copy(newRows.get(i)));
            if ( row(i).size() > width )
                width = row(i).size();
        }
    }
    /**
     * Applies text characters to the shape using a mask.
     * @param mask List of strings representing the text mask.
     */
    public void applyText(ArrayList<String> mask) {
        for ( int i = 0; i < mask.size(); i++ ) {
            row(i).applyText(mask.get(i));
        }
    }
    public void applyTransparencyMask(ArrayList<String> mask) {
        for ( int i = 0; i < mask.size(); i++ ) {
            row(i).applyCharacterTransparencyMask(mask.get(i));
        }
    }

    public void applyRGBOpacityMask(ArrayList<String> mask) {
        for ( int i = 0; i < mask.size(); i++ ) {
            row(i).applyRgbOpacityMask(mask.get(i));
        }
    }

    public void applyBRGBOpacityMask(ArrayList<String> mask) {
        for ( int i = 0; i < mask.size(); i++ ) {
            row(i).applyBgRgbOpacityMask(mask.get(i));
        }
    }

    public void applyOpacityMask(ArrayList<String> mask) {
        for ( int i = 0; i < mask.size(); i++ ) {
            row(i).applyOpacityMask(mask.get(i));
        }
    }

    /**
     * Returns the ChaxelString at the specified row index.
     * @param i Row index.
     * @return The ChaxelString at that row.
     */
    public ChaxelString row (int i) {
        if ( rows == null || i < 0 || i > rows.size()) {
            return new ChaxelString();
        }
        return rows.get(i);
    }

    /**
     * Resets the shape to a grid of spaces with the given dimensions.
     * @param x New width.
     * @param y New height.
     */
    public void reset(int x, int y) {
        width = x;
        rows.clear();
        for ( int i = 0; i < y; i++ ) {
            rows.add(Converter.toChaxels(
                    SafeSubStrings.createStringOfLength(x)
            ));
        }
    }

    public ArrayList<ChaxelString> getRows() {
        return rows;
    }

    /**
     * Writes another chaxel Shape onto given shape (clipping and zIndex)
     * @param shape
     * @param x
     * @param y
     */
    public void write(Shape shape, int x, int y) {
        int currentRow = 0;
        for ( ChaxelString chaxelString : shape.getRows() ) {
            write(chaxelString, x, y + currentRow);
            currentRow++;
        }
    }
    /**
     * Writes another ChaxelString onto this shape at the specified coordinates.
     * @param chaxels ChaxelString to write.
     * @param x X coordinate.
     * @param y Y coordinate.
     */
    public void write(ChaxelString chaxels, int x, int y) {
        if ( y >= rows.size()) return;
        rows.get(y).writeOn(chaxels, x, true);
    }
    public void write(String chaxelize, int x, int y) {
        write(Converter.toChaxels(chaxelize), x, y);
    }

    public void write(Chaxel chaxel, int x, int y) {
        write( ChaxelString.fromChaxel(chaxel), x, y);
    }

    /**
     * Prepares a ChaxelShape to be written in a PrintStream
     * @return
     */
    public String display() {
        StringBuilder sb = new StringBuilder();
        for ( ChaxelString chaxelString : rows ) {
            sb.append(Converter.escapedString(chaxelString)).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public void setZIndex(float zIndex) {
        for (ChaxelString chaxelString : rows) {
            chaxelString.setZIndex(zIndex);
        }
    }

    /**
     * Returns a deep copy of this shape.
     * @return A new Shape object.
     */
    public Shape copy() {
        Shape result = new Shape();
        result.rows = new ArrayList<>();
        for (ChaxelString chaxelString : rows) {
            result.rows.add(Copier.copy(chaxelString));
        }
        return result;
    }

    public Shape addColorToTable(Character ch, int[] rgb ) {
        ColorInfo colorInfo = new ColorInfo(rgb, 1, true);
        return addColorToTable(ch, colorInfo);
    }

    public Shape addBgColorToTable(Character ch, int[] rgb ) {
        ColorInfo colorInfo = new ColorInfo(rgb, 1, false);
        return addColorToTable(ch, colorInfo);
    }


    public Shape addColorToTable(Character ch, int[] rgb, float opacity ) {
        ColorInfo colorInfo = new ColorInfo(rgb, opacity, true);
        return addColorToTable(ch, colorInfo);
    }

    public Shape addBgColorToTable(Character ch, int[] rgb, float opacity ) {
        ColorInfo colorInfo = new ColorInfo(rgb, opacity, false);
        return addColorToTable(ch, colorInfo);
    }

    public Shape addColorToTable(Character ch, int[] rgb, int[] bRGB ) {
        ColorInfo colorInfo = new ColorInfo(rgb, bRGB, 1, 1);
        return addColorToTable(ch, colorInfo);
    }

    public Shape addColorToTable(Character ch, int[] rgb, int[] bRGB, float opacity, float bOpacity ) {
        ColorInfo colorInfo = new ColorInfo(rgb, bRGB, opacity, bOpacity);
        return addColorToTable(ch, colorInfo);
    }

    public Shape removeColorFromTable(Shape ch ) {
        colorTable.remove(ch);
        return this;
    }

    public Shape clearColorTable() {
        colorTable.clear();
        return this;
    }

    public Shape addColorToTable(Character ch, ColorInfo colorInfo) {
        colorTable.put(ch, colorInfo);
        return this;
    }
    /**
     * Applies colors from the internal color table to the shape based on a character mask.
     * @param colorMask List of strings where each character corresponds to a color in the table.
     * @return This Shape for chaining.
     */
    public Shape applyColorsFromTable(ArrayList<String> colorMask) {
        int y = 0;
        for ( String mask :  colorMask ) {
            for ( int i = 0; i < mask.length(); i++ ) {
                if ( colorTable.containsKey(mask.charAt(i)) ) {
                    ColorInfo colorInfo = colorTable.get(mask.charAt(i));
                    switch (colorInfo.getUsage()) {
                        case ColorInfo.USE_BG:
                            row(y).safeAt(i).setBRGB(colorInfo.getBRGB());
                            row(y).safeAt(i).setbRgbOpacity(colorInfo.getBRGBOpacity());
                            break;
                        case ColorInfo.USE_FG:
                            row(y).safeAt(i).setRGB(colorInfo.getRGB());
                            row(y).safeAt(i).setRgbOpacity(colorInfo.getRGBOpacity());
                            break;
                        case ColorInfo.USE_BOTH:
                            row(y).safeAt(i).setBRGB(colorInfo.getBRGB());
                            row(y).safeAt(i).setbRgbOpacity(colorInfo.getBRGBOpacity());
                            row(y).safeAt(i).setRGB(colorInfo.getRGB());
                            row(y).safeAt(i).setRgbOpacity(colorInfo.getRGBOpacity());

                    }
                }
            }
            y++;
        }
        return this;
    }
}
