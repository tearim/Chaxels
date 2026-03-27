package com.zarterstein.chaxels.clrender;

import com.zarterstein.chaxels.*;
//import JavaBattleShips.logic.Board; // Missing class

import java.util.ArrayList;

/**
 * High-level manager for game rendering sessions.
 */
public class GameRenderer {

    public static Renderer commonRenderer;
    /**
     * Initializes the common renderer.
     */
    public GameRenderer() {
        commonRenderer = new Renderer();
    }
    /**
     * Returns the common renderer instance.
     * @return Renderer instance.
     */
    public Renderer instance() {
        return commonRenderer;
    }
    private int curX, curY;
    /**
     * Sets the virtual cursor position.
     * @param x X pos.
     * @param y Y pos.
     */
    public void setCursorPosition(int x, int y) {
        curX = x;
        curY = y;
    }
    /**
     * Returns current tick from renderer.
     * @return Current tick.
     */
    public long now() {
        return commonRenderer.getTick();
    }
    /**
     * Returns a Chaxel at given coordinates from the canvas.
     * @param x X pos.
     * @param y Y pos.
     * @return The Chaxel.
     */
    public Chaxel getCanvasChaxel(int x, int y) {
        return commonRenderer.getScreen().getCanvas().row(y).safeAt(x);
    }
}
