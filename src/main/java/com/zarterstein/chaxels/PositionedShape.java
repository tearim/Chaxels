package com.zarterstein.chaxels;

/**
 * Extends {@link Shape} to include screen coordinates (X, Y, Z) and a unique ID.
 */
public class PositionedShape extends Shape implements Comparable<PositionedShape>{
    private int posX;
    private int posY;
    private float posZ;
    private String id;
    /**
     * Constructs a PositionedShape from an existing Shape.
     * @param shape The source Shape.
     */
    public PositionedShape(Shape shape) {
        super(shape);
    }
    /**
     * Constructs a PositionedShape with ID and coordinates.
     * @param shape The source Shape.
     * @param id Unique ID.
     * @param posX X position.
     * @param posY Y position.
     */
    public PositionedShape(Shape shape, String id, int posX, int posY) {
        super(shape);
        this.posX = posX;
        this.posY = posY;
        this.id = id;
    }
    public PositionedShape(Shape shape, String id, int posX, int posY, float posZ) {
        super(shape);
        this.posX = posX;
        this.posY = posY;
        this.setZIndex(posZ);
        this.posZ = posZ;
        this.id = id;
    }

    /**
     * Compares this PositionedShape with another based on Z-index for sorting.
     * @param o Other PositionedShape.
     * @return Comparison result.
     */
    @Override
    public int compareTo(PositionedShape o) {
        if ( o.posZ > this.posZ ) {
            return -1;
        }
        if ( o.posZ < this.posZ ) {
            return 1;
        }
        return 0;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getID() {
        return id;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public float getPosZ() {
        return posZ;
    }

    public void setPosZ(float posZ) {
        this.posZ = posZ;
    }
}
