package Services;

import Geography.Location;
import Services.Lesson.*;

import java.util.ArrayList;
import java.util.List;

public class Offering {

    private int OfferingId;
    private Lesson lesson;
    private Location location;
    private static List<Offering> AllOfferings ;
    private List<Offering> PublicOfferings ;
    private List<Booking> bookings;

    public Offering(int OfferingId, Lesson lesson, Location location) {
        this.OfferingId = OfferingId;
        this.lesson = lesson;
        this.location = location;
        AllOfferings = new ArrayList<Offering>();
        this.PublicOfferings = new ArrayList<Offering>();
        this.bookings = new ArrayList<Booking>();
    }

    public int getOfferingId() {
        return OfferingId;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public Location getLocation() {
        return location;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setAllOfferings(List<Offering> allOfferings) {
        AllOfferings = allOfferings;
    }

    public static List<Offering> getAllOfferings() {
        return AllOfferings;
    }

    public void setOfferingId(int offeringId) {
        OfferingId = offeringId;
    }

    public void setPublicOfferings(List<Offering> publicOfferings) {
        PublicOfferings = publicOfferings;
    }

    public List<Offering> getPublicOfferings() {
        return PublicOfferings;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public boolean isFull() {
        if (lesson instanceof PrivateLesson) {
            return !bookings.isEmpty(); // Private lesson is full if there's any booking
        } else {
            return bookings.size() >= lesson.getSize(); // Public lesson is full if bookings reach or exceed the size
        }
    }
}
