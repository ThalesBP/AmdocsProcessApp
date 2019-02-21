import Entities.Rover;

public class Main {

    public static void main(String[] args) {
        System.out.println("This is Rovers Mars problem");
        Navigation roversPlan = new Navigation();   // Initializing rovers' plan

        // Executes path plan for each rover
        for (Rover rover : roversPlan.rovers) {
            System.out.println("\n" + rover.toString() + " initializing plan path");

            // Verifies if path plan was executed with success
            if (rover.executePlan()) {
                System.out.println(rover.toString() + " final path position");
            }
            else {
                System.out.println(rover.toString() + " last position");
            }
        }

        // Prints final result
        System.out.println("\nRovers path plan output:");
        for (Rover rover : roversPlan.rovers) {
            System.out.println(rover.toString());
        }
    }
}
