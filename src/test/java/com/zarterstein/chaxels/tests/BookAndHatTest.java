package com.zarterstein.chaxels.tests;

import com.zarterstein.chaxels.Screen;
import com.zarterstein.chaxels.clrender.Renderer;
import com.zarterstein.testshapes.BookShape;

public class BookAndHatTest {
    public static void main(String[] args) {
        Renderer renderer = new Renderer();
        renderer.createScreen(80, 24);
        Screen screen = renderer.getScreen();
        BookShape cat = (BookShape) new BookShape().shape();
        renderer.moveToBeginning();

        screen.getCanvas().reset(180, 54);
        screen.removeAll();

        screen.add(cat, "book", 5, 1);
        renderer.printScreen();
    }
}
