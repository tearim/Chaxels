package com.zarterstein.testshapes;

import com.zarterstein.chaxels.Shape;

import java.util.ArrayList;
import java.util.Arrays;

public class SunShape extends Shape {


    public SunShape() {

    }

    public Shape shape() {


        reset(21, 8);
        applyText(new ArrayList<>(Arrays.asList(
                "       ,...,         ",
                "     ,~~~~~~~,       ",
                "  ,~~~~@@@@@~~~~,    ",
                " ~~~~@@@###@@@~~~~   ",
                " ~~@@@#######@@@~~   ",
                "  '~~@@@###@@@~~'    ",
                "     `~~@@@~~'       ",
                "       `...`         ")));
        addBgColorToTable('E', new int[] {255,255, 60} );
        addBgColorToTable('D', new int[] {230,220, 50} );
        addBgColorToTable('C', new int[] {220,200, 40} );
        addBgColorToTable('B', new int[] {210,190, 20} );
        addBgColorToTable('A', new int[] {200,180, 0 } );

        applyColorsFromTable(new ArrayList<>(Arrays.asList(
                "       AABAA         ",
                "     AABCCCBAA       ",
                "  AABCCDEEEDDCBAA    ",
                " ABCCDEEEEEEEDDCBA   ",
                " ABCDDEEEEEEEDDCBA  ",
                "  ABCDDDEEEDDDCBA    ",
                "     ABCDDDCBA       ",
                "       AABAA         ")));

        applyTransparencyMask(
                new ArrayList<>(Arrays.asList(
                        "        ***          ",
                        "      ~*****~        ",
                        "   ~$$$*****$$$~     ",
                        "  $$$*H*E§L§L*O$$    ",
                        "  $$$***§§§***$$$    ",
                        "   ~$$$*****$$$~       ",
                        "      ~*****~        ",
                        "        ***          ")));
        applyOpacityMask(
                new ArrayList<>(Arrays.asList(
                        "       25552         ",
                        "     258***852       ",
                        "  258$$*****$$$52    ",
                        " 258$***§§§***$852   ",
                        " 258$***§§§***$852   ",
                        "  258$$*****$$852    ",
                        "     258***852       ",
                        "       25552         ")));

        return this;
    }
}
