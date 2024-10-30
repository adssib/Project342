package Data.Services;

import Geography.Location;
import Geography.Space;
import Services.Lesson.Lesson;
import Services.Offering;
import TimeManagement.Schedule;
import TimeManagement.TimeSlots;
import UserManagment.Instructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

public class OfferingDataGenerator {
    public static ArrayList<Offering> generateOfferings(ArrayList<Space> spaces, ArrayList<Instructor> instructors) {
        ArrayList<Offering> offerings = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Space randomSpace = spaces.get(random.nextInt(spaces.size()));
            Instructor randomInstructor = instructors.get(random.nextInt(instructors.size()));
            Location location = randomSpace.getLocationOfSpace();
            Lesson lesson = location.getLessons().get(random.nextInt(location.getLessons().size()));

            // Generate a random TimeSlot
            LocalTime startTime = LocalTime.of(random.nextInt(24), 0); // Random hour, 0 minutes
            LocalTime endTime = startTime.plusHours(1); // 1-hour duration
            TimeSlots timeSlot = new TimeSlots(startTime, endTime);

            ArrayList<TimeSlots> TimeSlots = new ArrayList<TimeSlots>() ;
            TimeSlots.add(timeSlot);
            Schedule schedule = new Schedule(LocalDate.now(), TimeSlots) ;
            // Create the Offering with the new constructor
            Offering offering = new Offering(i + 1, lesson, location, schedule);

            // Set the instructor
            offering.setInstructor(randomInstructor);

            offerings.add(offering);
        }
        return offerings;
    }
}
