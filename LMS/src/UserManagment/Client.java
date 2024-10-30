package UserManagment;

import Services.Booking;

import java.util.ArrayList;
import java.util.List;

public class Client extends User {

    private List<Child> listOfChildrens;
    private List<Booking> listOfBookings;

    public Client(int userId, String userName, String password, String phoneNumber) {
        super(userId, userName, password, phoneNumber);
        this.listOfChildrens = new ArrayList<>();
        this.listOfBookings = new ArrayList<>();
    }

    public void addChild(Child child) {
        listOfChildrens.add(child);
    }

    public void removeChild(Child child) {
        listOfChildrens.remove(child);
    }

    public List<Child> getListOfChildrens() {
        return listOfChildrens;
    }

    public void addBooking(Booking booking) {
        listOfBookings.add(booking);
    }

    public void removeBook(Booking booking) {
        listOfBookings.remove(booking);
    }

    public List<Booking> getListOfBooks() {
        return listOfBookings;
    }

    /**
     * TODO
     * Add these methods
     * + ViewPublicOfferings() : void
     * + getBooking() : ArrayList<Booking>
     * +setBooking( O : ArrayList<Booking>) : void
     * + getChildren() : ArrayList<Child>
     * + setChildren( c : ArrayList<Child>) : void
     * +RegisterBooking( id: OfferingID) : void
     * + RegisterChildBooking(c : Child , id, OfferingID) : void
     * + CancelBooking( id : OfferingID) : void
     * + ViewBookings() : ArrayList<Booking>
     * + ViewPublicOfferings() : void
     * + Client( userName : String, pass: String, phoneNumber : String, c : List<Child> , b : List<Booking> )
     */
}
