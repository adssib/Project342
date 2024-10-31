package Data.Geography;

import Geography.Location;
import Geography.Space;

import java.util.ArrayList;
import java.util.Random;

public class SpaceDataGenerator {
    public static ArrayList<Space> generateSpaces(ArrayList<Location> locations) {
        ArrayList<Space> spaces = new ArrayList<>();
        Random random = new Random();
        String[] spaceTypes = {"Classroom", "Gym", "Pool", "Studio"};
        for (Location location : locations) {
            String randomSpaceType = spaceTypes[random.nextInt(spaceTypes.length)];
            spaces.add(new Space(randomSpaceType, location));
        }
        return spaces;
    }

}