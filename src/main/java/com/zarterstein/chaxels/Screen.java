package com.zarterstein.chaxels;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Manages multiple {@link PositionedShape} objects and renders them onto a final canvas.
 */
public class Screen {
    private ArrayList<PositionedShape> positionedChaxelShapes = new ArrayList<>();
    private Shape canvas;
    private Shape outputCanvas;
    private boolean needsSorting = true;

    public Screen() {

    }
    /**
     * Constructs a Screen with a canvas of given dimensions.
     * @param x Width.
     * @param y Height.
     */
    public Screen(int x, int y) {
        canvas = new Shape(x, y);
    }

    public ArrayList<PositionedShape> getPositionedChaxelShapes() {
        return positionedChaxelShapes;
    }

    /**
     * Adds a shape to the screen at specified coordinates.
     * @param shape The Shape to add.
     * @param id Unique ID for the shape.
     * @param x X coordinate.
     * @param y Y coordinate.
     * @return This Screen for chaining.
     */
    public Screen add(Shape shape, String id, int x, int y) {
        PositionedShape newShape = new PositionedShape(shape, id, x, y);
        positionedChaxelShapes.add(newShape);
        needsSorting = true;
        return this;
    }

    public Screen add(Shape shape, String id, int x, int y, float z) {
        PositionedShape newShape = new PositionedShape(shape, id, x, y, z);
        positionedChaxelShapes.add(newShape);
        needsSorting = true;
        return this;
    }

    /**
     * Removes a shape from the screen by its ID.
     * @param id ID of the shape to remove.
     * @return This Screen for chaining.
     */
    public Screen remove(String id) {
        positionedChaxelShapes.removeIf( pcs -> pcs.getID().equals(id));
        return this;
    }

    public Screen removeAll() {
        positionedChaxelShapes.clear();
        needsSorting = true;
        return this;
    }

    /**
     * Moves a shape to new coordinates and Z-index.
     * @param id ID of the shape.
     * @param x New X.
     * @param y New Y.
     * @param z New Z.
     * @return This Screen for chaining.
     */
    public Screen move(String id, int x, int y, float z) {
        positionedChaxelShapes.forEach( pcs -> {
            if ( pcs.getID().equals(id)) {
                pcs.setZIndex(z);
                pcs.setPosZ(z);
                pcs.setPosX(x);
                pcs.setPosY(y);
            }
        });
        needsSorting = true;
        return this;
    }
    public Screen move(String id, int x, int y ) {
        positionedChaxelShapes.forEach( pcs -> {
            if ( pcs.getID().equals(id)) {
                pcs.setPosX(x);
                pcs.setPosY(y);
            }
        });
        return this;
    }

    public Screen move(String id, float z) {
        positionedChaxelShapes.forEach( pcs -> {
            if ( pcs.getID().equals(id)) {
                pcs.setZIndex(z);

                pcs.setPosZ(z);
            }
        });
        needsSorting = true;
        return this;

    }

    public Screen setShape(String id, Shape shape) {
        positionedChaxelShapes.forEach( pcs -> {
            if ( pcs.getID().equals(id)) {
                pcs.reset(shape.row(0).size(), shape.getRows().size());
                pcs.write(shape, 0, 0);
            }
        });
        return this;
    }

    public Shape getShape(String id ) {
        return positionedChaxelShapes.stream().filter( pcs -> pcs.getID().equals(id)).findFirst().orElse(null);
    }

    public Screen write(String id, ChaxelString string, int x, int y) {
        positionedChaxelShapes.forEach( pcs -> {
            if ( pcs.getID().equals(id)) {
                pcs.write(string, x, y);
            }
        });
        return this;
    }


    public Screen setCanvas(int x, int y) {
        canvas = new Shape(x, y);
        return this;
    }

    public Screen setCanvas(Shape shape) {
        canvas = shape;
        canvas.setZIndex(0);
        return this;
    }

    public Shape getCanvas() {
        return canvas;
    }
    /**
     * Renders all positioned shapes onto the current canvas to produce the {@code outputCanvas}.
     * <p>
     * NOTE: This currently requires full copies of the canvas. While memory-intensive, 
     * this is not critical for typical terminal screens (e.g., 80x25 with several layers). 
     * Future versions will introduce optimized, buffer-based implementations.
     * </p>
     * @return This Screen for chaining.
     */
    public Screen write() {
        outputCanvas = canvas.copy();
        if ( needsSorting ) {
            Collections.sort(positionedChaxelShapes);
            needsSorting = false;
        }
        for ( PositionedShape positionedChaxelShape : positionedChaxelShapes ) {
            outputCanvas.write(positionedChaxelShape, positionedChaxelShape.getPosX(), positionedChaxelShape.getPosY());
        }
        return this;
    }
    /**
     * Returns the final rendered output as a string.
     * @return The display string.
     */
    public String display() {
        return outputCanvas.display();
    }
}
