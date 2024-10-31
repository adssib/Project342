package Data.TimeManagement;

import TimeManagement.Schedule;
import TimeManagement.TimeSlots;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

public class ScheduleDataGenerator {
    public static ArrayList<Schedule> generateSchedules() {
        ArrayList<Schedule> schedules = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            LocalDate date = LocalDate.now().plusDays(random.nextInt(30));
            ArrayList<TimeSlots> timeSlots = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                LocalTime startTime = LocalTime.of(8 + random.nextInt(12), 0);
                LocalTime endTime = startTime.plusHours(1);
                timeSlots.add(new TimeSlots(startTime, endTime));
            }

            schedules.add(new Schedule(date, timeSlots));
        }

        return schedules;
    }
}