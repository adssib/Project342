//package Data.Geography;
//
//import Geography.City;
//import Geography.Location;
//import TimeManagement.Schedule;
//import TimeManagement.TimeSlots;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.ArrayList;
//
//
//public class LocationDataGenerator {
//    private static int locationIdCounter = 1;
//
//    public static ArrayList<Location> generateLocations(ArrayList<City> cities) {
//        ArrayList<Location> locations = new ArrayList<>();
//
//        if (cities.isEmpty()) {
//            System.out.println("Cannot generate locations: cities list is empty");
//            return locations;
//        }
//
//        int cityIndex = 0;
//        for (int i = 0; i < 4; i++) {
//            City city = cities.get(cityIndex);
//
//            Location location = new Location(locationIdCounter++, city);
//
//            // Add some schedules to the location
//            for (int j = 0; j < 3; j++) {
//                Schedule schedule = new Schedule(LocalDate.now().plusDays(j));
//                schedule.addTimeSlot(new TimeSlots(LocalTime.of(9, 0), LocalTime.of(10, 0)));
//                location.addSchedule(schedule);
//            }
//
//            locations.add(location);
//            cityIndex = (cityIndex + 1) % cities.size();
//        }
//        return locations;
//    }
//}