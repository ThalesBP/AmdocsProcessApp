package Variables;

/**
 * This class represents a compass point orientation.
 */
public enum Compass {
                  // Ordered by angle -> index x 90 degrees
        E(1, 0),  //   0 degrees -> 0 x 90 degrees
        N(0, 1),  //  90 degrees -> 1 x 90 degrees
        W(-1, 0), // 180 degrees -> 2 x 90 degrees
        S(0, -1); // 270 degrees -> 3 x 90 degrees

        /**
         * Direction vector that compass points.
         */
        public Vector direction;

        /**
         * Initialize compass direction.
         * @param x - horizontal coordinate.
         * @param y - vertical coordinate.
         */
        Compass(int x, int y) {
                direction = new Vector(x, y);
        }

        /**
         * Gets a compass based on a string.
         */
        public static Compass getCompass(String compass) {
                return Compass.valueOf(compass);
        }

        /**
         * Get rotation compass to right.
         */
        public Compass getRightRotation () {
                int compassIndex = (this.ordinal() + Compass.values().length - 1) % (Compass.values().length);
                System.out.println("Rotating right: from " + this.name() + " to " + Compass.values()[compassIndex].toString());
                return Compass.values()[compassIndex];
        }

        /**
         * Get rotation compass to left.
         */
        public Compass getLeftRotation () {
                int compassIndex = (this.ordinal() + 1) % (Compass.values().length );
                System.out.println("Rotating left: from " + this.name() + " to " + Compass.values()[compassIndex].toString());
                return Compass.values()[compassIndex];
        }
}
