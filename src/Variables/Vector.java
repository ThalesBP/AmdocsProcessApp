package Variables;

/**
 * This class represents a vector in the space.
 */
public class Vector {

    public int x, y;

    /**
     * Initializes a new (0, 0) vector.
     */
    public Vector() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Initializes a new vector.
     * @param x - horizontal position.
     * @param y - vertical position.
     */
    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Sums two vectors.
     * @return the sum of coordinates.
     */
    public static Vector sum(Vector a, Vector b) {
        return new Vector(a.x + b.x, a.y + b.y);
    }

    public String toString () {
        return "(" + Integer.toString(this.x) + ", " + Integer.toString(this.y) + ")";
    }
}
