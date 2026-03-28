package com.zarterstein.chaxels.tests;

import com.zarterstein.chaxels.Screen;
import com.zarterstein.chaxels.clrender.Renderer;
import com.zarterstein.testshapes.BookShape;
import com.zarterstein.testshapes.HatulMadanShape;
import com.zarterstein.testshapes.RectangleShape;

public class HatulMadanTest {
    public static void main(String[] args) {
        Renderer renderer = new Renderer();
        renderer.createScreen(80, 24);
        Screen screen = renderer.getScreen();
        HatulMadanShape cat = (HatulMadanShape) new HatulMadanShape().shape();
        BookShape book = (BookShape) new BookShape().shape();
        RectangleShape bg = (RectangleShape) new RectangleShape().shape(100,100, new int[] {255,255,255 });
        renderer.moveToBeginning();
        screen.getCanvas().reset(180, 54);
        screen.add(cat, "cat", 2, 1, 4);
        screen.add(book, "book", 5, 18, 2);
        screen.add(bg, "bg", 0, 0, 0);
        renderer.printScreen();
    }
}
