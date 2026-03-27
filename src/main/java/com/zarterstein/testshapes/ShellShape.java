package com.zarterstein.testshapes;

import com.zarterstein.chaxels.Shape;

import java.util.ArrayList;
import java.util.Arrays;

public class ShellShape extends Shape {
    public  ShellShape() {
        super();
    }
    public Shape shape() {
        reset(4, 2);
        applyText(new ArrayList<>(Arrays.asList(
              " /=*",
              "--/ "
        )));
        addBgColorToTable('*', new int[] {255,210,200} );
        addBgColorToTable('=', new int[] {235,220,90} );
        addBgColorToTable('/', new int[] {40,30, 40} );
        addColorToTable('-', new int[] { 255, 155, 0}, new int[] {0,0,0} );

        applyColorsFromTable(new ArrayList<>(Arrays.asList(
                " /=*",
                "--/ "
        )));

        applyTransparencyMask(new ArrayList<>(Arrays.asList(
                " 68*",
                " 56 "
        )));
        applyOpacityMask(new ArrayList<>(Arrays.asList(
                " 68*",
                "356 "
        )));


        return this;
    }
}
