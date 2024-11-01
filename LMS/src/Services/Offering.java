package Services;

import Geography.Location;
import Services.Lesson.*;
import UserManagment.Instructor;
import TimeManagement.Schedule;

import java.util.ArrayList;
import java.util.List;

public class Offering {

    private int offeringId;
    private Lesson lesson;
    private Location location;
    private Schedule schedule;
    private Instructor instructor;
    private boolean isAvailable;
    private static List<Offering> allOfferings = new ArrayList<>();
    private List<Booking> bookings;

    public Offering(int offeringId, Lesson lesson, Location location, Schedule schedule) {
        this.offeringId = offeringId;
        this.lesson = lesson;
        this.location = location;
        this.schedule = schedule;
        this.isAvailable = false; // Not available until an instructor takes it
        this.bookings = new ArrayList<>();
        allOfferings.add(this);
    }

    public int getOfferingId() {
        return offeringId;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public Location getLocation() {
        return location;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
        this.isAvailable = true; // Offering becomes available when an instructor takes it
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public static List<Offering> getAllOfferings() {
        return allOfferings;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void addBooking(Booking booking) {
        if (isAvailable && !isFull()) {
            this.bookings.add(booking);
            if (isFull()) {
                this.isAvailable = false; // Mark as unavailable if full
            }
        }
    }

    public boolean isFull() {
        if (lesson instanceof PrivateLesson) {
            return !bookings.isEmpty();
        } else {
            return bookings.size() >= ((PublicLesson)lesson).getSize();
        }
    }

    @Override
    public String toString() {
        return "Offering{" +
                "ID=" + offeringId +
                ", Lesson='" + (lesson != null ? lesson.getTypeOfLesson() : "Not assigned") + '\'' +
                ", Location='" + (location != null ? location.getCity().toString() : "Not assigned") + '\'' +
                ", Schedule=" + (schedule != null ? schedule.getDate().toString() + schedule.getTimeSlots().toString(): "Not scheduled") +
                ", Instructor=" + (instructor != null ? instructor.getUserName() : "Not assigned") +
                ", Available=" + isAvailable +
                '}';
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}