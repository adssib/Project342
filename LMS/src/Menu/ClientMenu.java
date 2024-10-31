package Menu;

import UserManagment.Client;

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
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    System.out.println("Viewing Bookings...");
//                    for (Booking booking : client.getListOfBooks()) {
//                        System.out.println("Booking ID: " + booking.getBookingId() +
//                                ", Offering: " + booking.getOffering().getLesson().getName());
//                    }
                    break;
                case 2:
                    System.out.println("Making a Booking...");
                    // Implement logic to make a booking
                    break;
                case 3:
                    System.out.println("Viewing Public Offerings...");
                    // Call method to view public offerings
                    break;
                case 4:
                    System.out.println("Viewing Profile...");
                    System.out.println("Name: " + client.getUserName());
                    System.out.println("Phone: " + client.getPhoneNumber());
                    System.out.println("Number of Children: " + client.getListOfChildrens().size());
                    break;
                case 5:
                    System.out.println("Managing Children...");
//                    for (Child, child : client.getListOfChildrens()) {
//                        System.out.println("Child Name: " + child. + ", Age: " + child.getAge());
//                    }
                    // Implement logic to add/remove children
                    break;
                case 6:
                    System.out.println("Logging out...");
                    isDone = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        }
    }
}
