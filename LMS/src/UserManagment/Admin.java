package UserManagment;

import Geography.Location;
import Services.Booking;
import Services.Offering;

import java.util.Date;
import java.util.List;

public class Admin extends User {

    private List<User> users;
    private List<Booking> bookings;
    private List<Offering> offerings;

    public Admin(int userId, String user, String password, String phoneNumber) {
        super(userId, user, password, phoneNumber);
    }

    public void createOffering(Location location, Date date, String timeSlot) {
        // Implementation to create and add an offering
    }

    public void deleteOffering(int offeringId) {
        // Implementation to delete an offering by its ID
    }

    public List<User> viewUsers() {
        return users;
    }

    public void deleteUser(int userId) {
        // Implementation to delete a user by its ID
    }

    public List<Booking> viewBookings() {
        return bookings;
    }

    public void deleteBooking(int bookingId) {
        // Implementation to delete a booking by its ID
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
    /**
     * TODO
     * + CreateOffering(l : Location, d: Date, timeSlot : String) : void
     * + DeleteOffering(OfferingId : int) : void
     * + viewUsers() : List<Users>
     * + DeleteUser(UserId : int) : void
     * + ViewBookings() : List<Bookings>
     * + DeleteBookings(BookingId : int) : void
     * + getBookings() : List<Booking>
     * + setBookings(bookings: List<Booking>) : void
     * + getOfferings() : List<Offering>
     * + setOfferings(offerings: List<Offering>) : void
     * + getUsers() : List<Users>
     * +setUsers(users: List<Users>) : void
     *
     * + admin(Username: String , password: String, phoneNumeber: String)
     */
}
