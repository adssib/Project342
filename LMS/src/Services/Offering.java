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
    private int totalSeats;
    private int bookedSeats;
    private List<Booking> bookings;

    public Offering(int offeringId, Lesson lesson, Location location, Schedule schedule) {
        this.offeringId = offeringId;
        this.lesson = lesson;
        this.location = location;
        this.schedule = schedule;
        this.isAvailable = true;
        this.totalSeats = 10; // Default value, you can change this or make it a parameter
        this.bookedSeats = 0;
        this.bookings = new ArrayList<>();
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
        bookedSeats++;
        if (isFull()) {
            this.setAvailable(false);
        }
    }

    public void removeBooking(Booking booking) {
        if (bookings.remove(booking)) {
            bookedSeats--;
            if (!isFull()) {
                this.setAvailable(true);
            }
        }
    }

    public boolean isFull() {
        return bookedSeats >= totalSeats;
    }

    public boolean isAvailable() {
        return isAvailable && !isFull();
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getAvailableSeats() {
        return totalSeats - bookedSeats;
    }

    public Location getLocation() {
        return location;
    }

    public int getOfferingId() {
        return offeringId;
    }

    public void setOfferingId(int offeringId) {
        this.offeringId = offeringId;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(int bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }


    @Override
    public String toString() {
        return "Offering{" +
                "id=" + offeringId +
                ", lesson=" + lesson.getTypeOfLesson() +
                ", location=" + location.getCity().getCityName() +
                ", schedule=" + schedule.getDate() +
                ", instructor=" + (instructor != null ? instructor.getUserName() : "Not assigned") +
                ", availableSeats=" + getAvailableSeats() +
                '}';
    }
}