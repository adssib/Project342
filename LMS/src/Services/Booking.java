package Services;

import UserManagment.Child;
import UserManagment.Client;

public class Booking {

    private static int nextBookingId = 1;
    private int bookingID;
    private Client client;
    private Offering offering;
    private Child child;

    public Booking(Client client, Offering offering) {
        this.bookingID = nextBookingId++;
        this.client = client;
        this.offering = offering;
    }

    public Booking(Offering offering, Client client, Child child) {
        this.bookingID = nextBookingId++;
        this.client = client;
        this.offering = offering;
        this.child = child;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Offering getOffering() {
        return offering;
    }

    public void setOffering(Offering offering) {
        this.offering = offering;
    }
}
