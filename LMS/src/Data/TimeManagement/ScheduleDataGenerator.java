package Data.TimeManagement;

import TimeManagement.Schedule;
import TimeManagement.TimeSlots;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ScheduleDataGenerator {
    public static ArrayList<Schedule> generateSchedules() {
        ArrayList<Schedule> schedules = new ArrayList<>();

        LocalDate startDate = LocalDate.now();
        LocalTime[] startTimes = {
                LocalTime.of(8, 0),
                LocalTime.of(10, 0),
                LocalTime.of(13, 0),
                LocalTime.of(15, 0),
                LocalTime.of(17, 0)
        };

        for (int i = 0; i < 5; i++) {
            LocalDate date = startDate.plusDays(i);
            ArrayList<TimeSlots> timeSlots = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                LocalTime startTime = startTimes[(i + j) % startTimes.length];
                LocalTime endTime = startTime.plusHours(1);
                timeSlots.add(new TimeSlots(startTime, endTime));
            }

            schedules.add(new Schedule(date, timeSlots));
        }

        return schedules;
    }
}