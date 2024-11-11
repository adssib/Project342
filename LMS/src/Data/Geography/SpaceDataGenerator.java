//package Data.Geography;
//
//import Geography.Location;
//import Geography.Space;
//
//import java.util.ArrayList;
//
//public class SpaceDataGenerator {
//    public static ArrayList<Space> generateSpaces(ArrayList<Location> locations) {
//        ArrayList<Space> spaces = new ArrayList<>();
//        String[] spaceTypes = {"Classroom", "Gym", "Pool"};
//        int typeIndex = 0;
//
//        for (Location location : locations) {
//            String spaceType = spaceTypes[typeIndex];
//            spaces.add(new Space(spaceType, location));
//            typeIndex = (typeIndex + 1) % spaceTypes.length;
//        }
//        return spaces;
//    }
//}