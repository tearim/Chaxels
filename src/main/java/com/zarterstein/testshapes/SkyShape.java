package com.zarterstein.testshapes;

import com.zarterstein.ansifansi.Fansi;
import com.zarterstein.chaxels.Shape;
import com.zarterstein.chaxels.ChaxelString;

import java.util.ArrayList;
import java.util.Arrays;

public class SkyShape extends Shape {

    ChaxelString skyRow = new ChaxelString(Fansi.create().append("").bRGB(80, 120, 165).RGB(255,255,255) .append("~~~~~       ~~~           @@$$$%@%%~~~               ").reset().render());
    ChaxelString skyRow1 = new ChaxelString(Fansi.create().append("").bRGB(80, 123, 160).RGB(255,255,255).append("  ~~~                 ````@@@###%%@@@@~~~            ").reset().render());
    ChaxelString skyRow2 = new ChaxelString(Fansi.create().append("").bRGB(80, 125, 155).RGB(255,255,255).append("    ~~~~~               ~~~ @@@$$$@~~~~~~            ").reset().render());
    ChaxelString skyRow3 = new ChaxelString(Fansi.create().append("").bRGB(85, 127, 145).RGB(255,255,255).append("       ~~~~~                                         ").reset().render());
    ChaxelString skyRow4 = new ChaxelString(Fansi.create().append("").bRGB(85, 128, 140).RGB(255,255,255).append("                   ~~~@~~~          ~~@~~            ").reset().render());
    ChaxelString skyRow5 = new ChaxelString(Fansi.create().append("").bRGB(90, 120, 135).RGB(255,255,255).append("                                                     ").reset().render());

    Shape skyShape = new Shape(new ArrayList<>(Arrays.asList(
            skyRow, skyRow, skyRow1, skyRow1,skyRow2,skyRow2, skyRow3,skyRow3, skyRow4,skyRow4, skyRow5,  skyRow5
    )));

    public SkyShape() {
    }

    public Shape shape() {
        return skyShape;
    }

}
