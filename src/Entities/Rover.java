package Entities;

import Variables.Compass;
import Variables.Vector;

/**
 * This class manages and defines a rover to be navigated.
 */
public class Rover {

    public String name;
    public Vector position;
    public Compass orientation;

    private char[] planPath;
    private Terrain plateau;

    /**
     * Initializes a Entities.Rover based on coordinate position and compass orientation.
     */
    public Rover (int x, int y, char r) {
        this.position = new Vector(x, y);
        this.orientation = Compass.getCompass(String.valueOf(r));
    }

    /**
     * Sets the current plateau.
     */
    public void setPlateau(Terrain plateau) {
        this.plateau = plateau;
    }

    /**
     * Sets the plan path of this rover.
     */
    public void setPlanPath(String planPath) {
        this.planPath = planPath.toCharArray();
    }

    /**
     * Makes rover executing path plan.
     * @return - true if path plan executes with success.
     */
    public boolean executePlan() {
        for (char command : planPath) {
            System.out.println(this.toString() + " executing command " + command);
            if (!this.executeCommand(command)){
                return false;
            }
        }
        System.out.println(this.toString() + " path executed with success");
        return true;
    }

    /**
     * Entities.Rover executes a given command.
     * @return - true if command executes with success.
     */
    public boolean executeCommand(char command) {
        switch (command) {
            case 'M':
                return moveForward();
            case 'R':
            case 'L':
                return rotate(command);
            default:
                System.out.println("Wrong command: " + command);
                return false;
        }
    }

    /**
     * Moves the rover forward based on its position and orientation.
     * @return - true if moves with success.
     */
    private boolean moveForward() {
        Vector newPosition = Vector.sum(position, orientation.direction);
        if (plateau.checkCollision(newPosition)) {
            System.out.println("Collision detected at " + newPosition.toString());
            return false;
        }
        System.out.println("Moving to " + newPosition.toString());
        this.position = newPosition;
        return true;
    }

    /**
     * Rotates the rover based on direction command.
     * @return - true if rotates with success.
     */
    private boolean rotate(char direction) {
        switch (direction) {
            case 'R':
                orientation = orientation.getRightRotation();
                return true;
            case 'L':
                orientation = orientation.getLeftRotation();
                return true;
            default:
                System.out.println("Wrong direction command: " + direction);
                return false;
        }
    }

    public String toString() {
        return "Rover " + name + " (" + Integer.toString(this.position.x) + ", " + Integer.toString(this.position.y) + ", " + orientation.name() + ")";
    }
}
