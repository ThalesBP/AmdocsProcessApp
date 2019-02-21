package Entities;

import Variables.Vector;

/**
 * This class manages and defines a terrain where the rover navigates on.
 */
public class Terrain {

    public Vector minBoundary, maxBoundary;

    /**
     * Initializes a terrain assuming min boundary at (0, 0) and a max boundary.
     * @param maxBoundary
     */
    public Terrain (Vector maxBoundary) {
        this.minBoundary = new Vector();
        this.maxBoundary = maxBoundary;
    }

    /**
     * Checks if a position is inside the terrain.
     * @param position
     * @return
     */
    public boolean checkCollision (Vector position) {
        if ((position.x >= minBoundary.x) && (position.x <= maxBoundary.x) && (position.y >= minBoundary.y) && (position.y <= maxBoundary.y)) {
            return false;
        }
        return true;
    }
}
