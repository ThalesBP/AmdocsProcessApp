import Entities.Rover;
import Entities.Terrain;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Variables.Vector;

/**
 * This class reads navigation plan from txt file and set up the environment.
 */
public class Navigation {

    public Terrain plateau;
    public List<Rover> rovers;

    public Navigation() {

        String path = new File("").getAbsolutePath();
        path = path.concat("\\RoversPlan.txt");
        Scanner planReader = null;
        File plan = new File(path);

        try {
            planReader = new Scanner(plan);
        } catch (Exception e) {
            System.out.println("Problem scanning file: " + e.toString());
        }

        if (planReader.hasNextLine()) {
            String terrainInfos = planReader.nextLine();
            String[] terrainCoordinates = terrainInfos.split(" ");
            System.out.println("Terrain infos: " + terrainInfos);
            if (terrainCoordinates.length != 2) {
                System.out.println(Integer.toString(terrainCoordinates.length) + " is not expected length for terrain information");
            }
            else {
                Vector maxBoundary = new Vector(Integer.parseInt(terrainCoordinates[0]), Integer.parseInt(terrainCoordinates[1]));
                System.out.println("Terrain max boundary: " + maxBoundary.toString());
                plateau = new Terrain(maxBoundary);
            }
        }
        else {
            System.out.println("Plan file has no information.");
        }

        rovers = new ArrayList<Rover>();

        while (planReader.hasNextLine()) {
            String roverInfo = planReader.nextLine();
            String roverPlanPath = null;
            System.out.println("Rover infos: " + roverInfo);

            if (planReader.hasNextLine()) {
                roverPlanPath = planReader.nextLine();
                System.out.println("Rover plan path: " + roverPlanPath);
            }
            else {
                System.out.println("There is no plan path for the rover number " + Integer.toString(rovers.size() + 1));
                break;
            }
            String[] roverCoordinates = roverInfo.split(" ");

            Rover newRover = new Rover(Integer.parseInt(roverCoordinates[0]), Integer.parseInt(roverCoordinates[1]), roverCoordinates[2].charAt(0));
            newRover.setPlateau(plateau);
            newRover.setPlanPath(roverPlanPath);
            newRover.name = Integer.toString(rovers.size() + 1);

            System.out.println(newRover.toString() + " is ready.");

            rovers.add(newRover);
        }
    }
}
