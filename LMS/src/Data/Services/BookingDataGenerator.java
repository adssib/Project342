package Data.Services;

import Services.Booking;
import Services.Offering;
import UserManagment.Child;
import UserManagment.Client;

import java.util.ArrayList;
import java.util.Random;

public class BookingDataGenerator {
    public static ArrayList<Booking> generateBookings(ArrayList<Offering> offerings, ArrayList<Client> clients, ArrayList<Child> children) {
        ArrayList<Booking> bookings = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            Offering randomOffering = offerings.get(random.nextInt(offerings.size()));

            if (random.nextBoolean()) {
                // Adult booking
                Client randomClient = clients.get(random.nextInt(clients.size()));
                bookings.add(new Booking(i + 1, randomClient, randomOffering));
            } else {
                // Child booking
                Child randomChild = children.get(random.nextInt(children.size()));
                bookings.add(new Booking(i + 1, randomOffering, randomChild.getParent(), randomChild));
            }
        }

        return bookings;
    }
}