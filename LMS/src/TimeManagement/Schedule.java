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

    public Schedule(LocalDate now, ArrayList<TimeSlots> timeSlots) {
        this.date = now;
        this.timeSlots = timeSlots;
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

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTimeSlots(List<TimeSlots> timeSlots) {
        this.timeSlots = timeSlots;
    }

    public boolean overlaps(Schedule other) {
        // First, check if the dates are the same
        if (!this.date.equals(other.getDate())) {
            return false;
        }

        // If dates are the same, check for time slot overlaps
        for (TimeSlots thisSlot : this.timeSlots) {
            for (TimeSlots otherSlot : other.getTimeSlots()) {
                if (thisSlot.overlaps(otherSlot)) {
                    return true;
                }
            }
        }

        return false;
    }
}
