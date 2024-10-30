package UserManagment;

import Geography.Location;
import Services.Booking;
import Services.Offering;
import Services.Lesson.Lesson;
import TimeManagement.Schedule;
import TimeManagement.TimeSlots;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Admin extends User {

    private List<User> users;
    private List<Booking> bookings;
    private List<Offering> offerings;

    public Admin(int userId, String user, String password, String phoneNumber) {
        super(userId, user, password, phoneNumber);
        this.users = new ArrayList<>();
        this.bookings = new ArrayList<>();
        this.offerings = new ArrayList<>();
    }

    public void createOffering(Location location, LocalDate date, LocalTime startTime, LocalTime endTime, Lesson lesson) {
        int newOfferingId = getNextOfferingId();

        // Find or create the schedule for the given date
        Schedule schedule = location.getSchedules().stream()
                .filter(s -> s.getDate().equals(date))
                .findFirst()
                .orElseGet(() -> {
                    Schedule newSchedule = new Schedule(date);
                    location.addSchedule(newSchedule);
                    return newSchedule;
                });

        // Create the new time slot
        TimeSlots newTimeSlot = new TimeSlots(startTime, endTime);
        schedule.addTimeSlot(newTimeSlot);

        // Create the new offering with the schedule
        Offering newOffering = new Offering(newOfferingId, lesson, location, schedule);

        offerings.add(newOffering);
        System.out.println("New offering created with ID: " + newOfferingId + " for " + date + " from " + startTime + " to " + endTime);
    }

    public void deleteOffering(int offeringId) {
        offerings.removeIf(offering -> offering.getOfferingId() == offeringId);
        System.out.println("Offering with ID " + offeringId + " has been deleted if it existed.");
    }

    public List<User> viewUsers() {
        return users;
    }

    public void deleteUser(int userId) {
        users.removeIf(user -> user.getUserId() == userId);
        System.out.println("User with ID " + userId + " has been deleted if they existed.");
    }

    public List<Booking> viewBookings() {
        return bookings;
    }

    public void deleteBooking(int bookingId) {
        bookings.removeIf(booking -> booking.getBookingID() == bookingId);
        System.out.println("Booking with ID " + bookingId + " has been deleted if it existed.");
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Offering> getOfferings() {
        return offerings;
    }

    public void setOfferings(List<Offering> offerings) {
        this.offerings = offerings;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public User findUserById(int userId) {
        return users.stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst()
                .orElse(null);
    }

    public Offering findOfferingById(int offeringId) {
        return offerings.stream()
                .filter(offering -> offering.getOfferingId() == offeringId)
                .findFirst()
                .orElse(null);
    }

    public Booking findBookingById(int bookingId) {
        return bookings.stream()
                .filter(booking -> booking.getBookingID() == bookingId)
                .findFirst()
                .orElse(null);
    }

    private int getNextOfferingId() {
        return offerings.stream()
                .filter(Objects::nonNull)
                .mapToInt(Offering::getOfferingId)
                .max()
                .orElse(0) + 1;
    }
}