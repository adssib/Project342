//package Data.Services;
//
//import Geography.Location;
//import Geography.Space;
//import Services.Lesson.Lesson;
//import Services.Offering;
//import TimeManagement.Schedule;
//import TimeManagement.TimeSlots;
//import UserManagment.Instructor;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.ArrayList;
//
//public class OfferingDataGenerator {
//    public static ArrayList<Offering> generateOfferings(ArrayList<Space> spaces, ArrayList<Instructor> instructors) {
//        ArrayList<Offering> offerings = new ArrayList<>();
//
//        if (spaces.isEmpty() || instructors.isEmpty()) {
//            System.out.println("Cannot generate offerings: spaces or instructors list is empty");
//            return offerings;
//        }
//
//        int spaceIndex = 0;
//        int instructorIndex = 0;
//
//        for (int i = 0; i < 10; i++) {
//            Space space = spaces.get(spaceIndex);
//            Instructor instructor = instructors.get(instructorIndex);
//            Location location = space.getLocationOfSpace();
//
//            if (location.getLessons().isEmpty()) {
//                System.out.println("Cannot generate offering: no lessons available for location");
//                continue;
//            }
//
//            Lesson lesson = location.getLessons().get(0);
//
//            // Generate a TimeSlot
//            LocalTime startTime = LocalTime.of(9, 0); // Fixed start time at 9:00
//            LocalTime endTime = startTime.plusHours(1); // 1-hour duration
//            TimeSlots timeSlot = new TimeSlots(startTime, endTime);
//
//            ArrayList<TimeSlots> timeSlots = new ArrayList<>();
//            timeSlots.add(timeSlot);
//            Schedule schedule = new Schedule(LocalDate.now(), timeSlots);
//
//            // Create the Offering
//            Offering offering = new Offering(i + 1, lesson, location, schedule);
//
//            // Set the instructor
//            offering.setInstructor(instructor);
//
//            offerings.add(offering);
//
//            // Increment indices
//            spaceIndex = (spaceIndex + 1) % spaces.size();
//            instructorIndex = (instructorIndex + 1) % instructors.size();
//        }
//        return offerings;
//    }
//}