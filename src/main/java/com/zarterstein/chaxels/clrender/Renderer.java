package com.zarterstein.chaxels.clrender;

import com.zarterstein.chaxels.Screen;
import com.zarterstein.chaxels.helpers.Converter;
import com.zarterstein.ansifansi.Fansi;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Handles terminal rendering, including screen management and timed redraws.
 */
public class Renderer {
    private long tick = 0;
    /**
     * Increments the internal tick counter.
     */
    public void tick() {
        tick++;
    }
    /**
     * Returns the current tick value.
     * @return current tick.
     */
    public long getTick(){
        return tick;
    }
    private  int x;
    private  int y;
    public static final String RESET_SCREEN = Fansi.ESC_B + "2J";
    public static final String MOVE_TOBEGINNING = Fansi.ESC_B + "H";
    public static final int MAX_RENDER_WAIT = 5000;
    /**
     * Resets the terminal screen.
     * @return This Renderer for chaining.
     */
    public Renderer reset() {
        System.out.println(RESET_SCREEN);
        return this;
    }
    public Screen screen = null;
    /**
     * Creates a new Screen with given dimensions.
     * @param x width.
     * @param y height.
     * @return This Renderer for chaining.
     */
    public Renderer createScreen(int x, int y) {
        screen = new Screen(x,y);
        return this;
    }
    /**
     * Moves the cursor to the beginning of the terminal.
     * @return This Renderer for chaining.
     */
    public Renderer moveToBeginning() {
        System.out.println(RESET_SCREEN);
        System.out.println(MOVE_TOBEGINNING);
        System.out.println(Fansi.ESC_B + "3J");
        return this;
    }
    /**
     * Sets internal cursor coordinates.
     * @param x X coordinate.
     * @param y Y coordinate.
     * @return This Renderer for chaining.
     */
    public Renderer moveToXY(int x, int y) {
        this.x = x;
        this.y = y;
        return this;
    }
    /**
     * Clears the screen and resets the canvas.
     * @return This Renderer for chaining.
     */
    public Renderer clearAll() {
        screen.getCanvas().reset(x, y);
        screen.removeAll();
        printScreen();
        return this;
    }
    /**
     * Pauses execution for a specified duration.
     * @param millis time in milliseconds.
     * @return This Renderer for chaining.
     */
    public Renderer pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
        return this;
    }
    /**
     * Renders and prints the screen to standard output.
     * @return This Renderer for chaining.
     */
    public Renderer printScreen() {
        System.out.print(MOVE_TOBEGINNING);
        System.out.println(screen.write().display());
        return this;
    }
    /**
     * Prints a string to the screen at current coordinates.
     * @param s The string to print.
     * @return This Renderer for chaining.
     */
    public Renderer print(String s) {
        screen.getCanvas().write(Converter.toChaxels(s), x, y);
        y++;
        return this;
    }
    /**
     * Registers a recurring task to redraw the screen at fixed intervals.
     * @param millis interval.
     * @param r The task to run.
     * @return This Renderer for chaining.
     */
    public Renderer registerRecurringRedraw(int millis, Runnable r) {
        tick();
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        if ( millis < 0 ) millis = 0;
        if ( millis > MAX_RENDER_WAIT) millis = MAX_RENDER_WAIT;
        cancelRecurringRedraw();
        redrawschedule = scheduler.scheduleAtFixedRate(r, 0, millis, TimeUnit.MILLISECONDS);
        return this;
    }
    public Screen getScreen() {
        return screen;
    }
    /**
     * Cancels any active recurring redraw tasks.
     * @return This Renderer for chaining.
     */
    public Renderer cancelRecurringRedraw() {
        if (redrawschedule != null) {
            redrawschedule.cancel(false);
        }
        return this;
    }
    private ScheduledFuture<?> redrawschedule;
}
