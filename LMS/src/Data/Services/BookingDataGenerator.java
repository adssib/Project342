package Data.Services;

import Services.Booking;
import Services.Offering;
import UserManagment.Child;
import UserManagment.Client;

import java.util.ArrayList;

public class BookingDataGenerator {
    public static ArrayList<Booking> generateBookings(ArrayList<Offering> offerings, ArrayList<Client> clients, ArrayList<Child> children) {
        ArrayList<Booking> bookings = new ArrayList<>();

        if (offerings.isEmpty() || clients.isEmpty()) {
            System.out.println("Cannot generate bookings: offerings or clients list is empty");
            return bookings;
        }

        int offeringIndex = 0;
        int clientIndex = 0;
        int childIndex = 0;

        for (int i = 0; i < 10; i++) {
            Offering offering = offerings.get(offeringIndex);

            if (i % 2 == 0) {
                // Adult booking
                Client client = clients.get(clientIndex);
                bookings.add(new Booking(i + 1, client, offering));
                clientIndex = (clientIndex + 1) % clients.size();
            } else {
                // Child booking
                if (!children.isEmpty()) {
                    Child child = children.get(childIndex);
                    bookings.add(new Booking(i + 1, offering, child.getParent(), child));
                    childIndex = (childIndex + 1) % children.size();
                } else {
                    // If no children, make an adult booking instead
                    Client client = clients.get(clientIndex);
                    bookings.add(new Booking(i + 1, client, offering));
                    clientIndex = (clientIndex + 1) % clients.size();
                }
            }

            offeringIndex = (offeringIndex + 1) % offerings.size();
        }

        return bookings;
    }
}