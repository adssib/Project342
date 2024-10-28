package TimeManagement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private LocalDate date;
    private List<TimeSlots> timeSlots;

    public Schedule(LocalDate date) {
        this.date = date;
        this.timeSlots = new ArrayList<>();
    }

    public void addTimeSlot(TimeSlots timeSlot) {
        timeSlots.add(timeSlot);
    }

    public List<TimeSlots> getTimeSlots() {
        return timeSlots;
    }

    public LocalDate getDate() {
        return date;
    }
}
