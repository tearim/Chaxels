package com.zarterstein.testshapes;

import com.zarterstein.chaxels.ChaxelString;
import com.zarterstein.chaxels.Shape;
import com.zarterstein.chaxels.helpers.SafeSubStrings;

import java.util.ArrayList;

public class RectangleShape extends Shape {


    public RectangleShape() {

    }

    public Shape shape(int x, int y, int[] bgColor) {
        reset(x, y);
        String filledByF =
                SafeSubStrings.createStringOfLength(x).replace(' ', 'F');
        ArrayList<String> fRows = new ArrayList<>();
        for ( int i = 0; i < y; i++ ) {
            fRows.add(filledByF);
        }
        applyOpacityMask(fRows);
        applyBRGBOpacityMask(fRows);
        applyRGBOpacityMask(fRows);
        addBgColorToTable('F', bgColor);
        applyColorsFromTable(fRows);
        return this;
    }

}
