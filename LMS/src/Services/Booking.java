package Services;

import UserManagment.Client;

public class Booking {

    private int bookingID;
    private Client client;
    private Offering offering;

    public Booking(int bookingID, Client client, Offering offering) {
        this.bookingID = bookingID;
        this.client = client;
        this.offering = offering;
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
