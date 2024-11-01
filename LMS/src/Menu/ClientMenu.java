package Menu;

import Data.Geography.OrganisationData;
import Services.Booking;
import Services.Offering;
import UserManagment.Client;

import java.util.List;
import java.util.Scanner;

public class ClientMenu {

    public static void clientMenu(Client client, Scanner scanner) {
        boolean isDone = false;
        while (!isDone) {
            System.out.println("\nClient Menu");
            System.out.println("1. View Bookings");
            System.out.println("2. Make a Booking");
            System.out.println("3. View Public Offerings");
            System.out.println("4. View Profile");
            System.out.println("5. Manage Children");
            System.out.println("6. Logout");
            System.out.println("7. Logout");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    System.out.println("Viewing Bookings...");
                    ViewBookings(client);
                    break;
                case 2:
                    System.out.println("Making a Booking...");
                    MakeBooking(client); 
                    break;
                case 3:
                    System.out.println("Viewing Public Offerings...");
                    ViewPublicOfferings();
                    break;
                case 4:
                    System.out.println("Viewing Profile...");
                    System.out.println("Name: " + client.getUserName());
                    System.out.println("Phone: " + client.getPhoneNumber());
                    System.out.println("Number of Children: " + client.getListOfChildrens().size());
                    break;
                case 5:
                    System.out.println("Managing Children...");
                    ManageChildren(client);
                    break;
                case 6:
                    System.out.println("Canceling Booking...");

                    break;
                case 7:
                    System.out.println("Logging out...");
                    isDone = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        }
    }

    private static void ManageChildren(Client client) {
    }

    private static void MakeBooking(Client client) {
    }

    private static void ViewBookings(Client client) {
        List<Booking> ClientBookings = client.getListOfBooks();
        if(ClientBookings.isEmpty()) {
            System.out.println("No bookings found");
        }else{
            for (Booking booking : ClientBookings) {
                System.out.println(booking.toString());
            }
        }
    }

    private static void ViewPublicOfferings() {
        List<Offering> Offerings = OrganisationData.getOrganisation().getOfferings();
        if(Offerings.isEmpty()) {
            System.out.println("No Offerings found");
        }else{
            for (Offering offering : Offerings) {
                if(offering.isAvailable() ){
                    if(offering.isFull()){
                        System.out.println("UNAVAILABLE OFFERING " + offering.toString());
                    }else{
                        System.out.println(offering.toString());
                    }
                }
            }
        }
    }
}
