package Data.Geography;

import Geography.City;
import Geography.Location;
import TimeManagement.Schedule;
import TimeManagement.TimeSlots;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

public class LocationDataGenerator {
    private static int locationIdCounter = 1;

    public static ArrayList<Location> generateLocations(ArrayList<City> cities) {
        ArrayList<Location> locations = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            City randomCity = cities.get(random.nextInt(cities.size()));
            Location location = new Location(locationIdCounter++, randomCity);

            // Add some schedules to the location
            for (int j = 0; j < 3; j++) {
                Schedule schedule = new Schedule(LocalDate.now().plusDays(j));
                schedule.addTimeSlot(new TimeSlots(LocalTime.of(9, 0), LocalTime.of(10, 0)));
                location.addSchedule(schedule);
            }

            locations.add(location);
        }
        return locations;
    }
}