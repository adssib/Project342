package Menu;

import Data.Geography.OrganisationData;
import Services.Booking;
import Services.Offering;
import UserManagment.Child;
import UserManagment.Client;

import java.util.ArrayList;
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
            System.out.println("6. Cancel Booking");
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
                    MakeBooking(client, scanner);
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
                    ManageChildren(client, scanner);
                    break;
                case 6:
                    System.out.println("Canceling Booking...");
                    CancelBooking(client, scanner) ;
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

    private static void CancelBooking(Client client, Scanner scanner) {
        List<Booking> clientBookings = client.getListOfBooks();
        if (clientBookings.isEmpty()) {
            System.out.println("You have no bookings to cancel.");
            return;
        }

        System.out.println("Your current bookings:");
        for (int i = 0; i < clientBookings.size(); i++) {
            System.out.println((i + 1) + ". " + clientBookings.get(i).toString());
        }

        System.out.print("Enter the number of the booking you want to cancel (0 to go back): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice > 0 && choice <= clientBookings.size()) {
            Booking bookingToCancel = clientBookings.get(choice - 1);
            client.removeBook(bookingToCancel);
            bookingToCancel.getOffering().removeBooking(bookingToCancel);
            System.out.println("Booking cancelled successfully.");
        } else if (choice != 0) {
            System.out.println("Invalid selection. Please try again.");
        }
    }

    private static void ManageChildren(Client client, Scanner scanner) {
        boolean isDone = false;
        while (!isDone) {
            System.out.println("\nManage Children");
            System.out.println("1. View Children");
            System.out.println("2. Add Child");
            System.out.println("3. Back to Client Menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewChildren(client);
                    break;
                case 2:
                    addChild(client, scanner);
                    break;
                case 3:
                    isDone = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void viewChildren(Client client) {
        List<Child> children = client.getListOfChildrens();
        if (children.isEmpty()) {
            System.out.println("You have no registered children.");
        } else {
            System.out.println("Your children:");
            for (Child child : children) {
                System.out.println("Name: " + child.getName() + ", Age: " + child.getAge());
            }
        }
    }

    private static void addChild(Client client, Scanner scanner) {
        System.out.print("Enter child's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter child's age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Child newChild = new Child(client, name, age);
        client.addChild(newChild);
        System.out.println("Child added successfully.");
    }

    private static void MakeBooking(Client client, Scanner scanner) {
        System.out.println("1. Book for yourself");
        System.out.println("2. Book for a child");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        List<Offering> availableOfferings = getAvailableOfferings();
        if (availableOfferings.isEmpty()) {
            System.out.println("No available offerings at the moment.");
            return;
        }

        System.out.println("Available offerings:");
        for (int i = 0; i < availableOfferings.size(); i++) {
            System.out.println((i + 1) + ". " + availableOfferings.get(i).toString());
        }

        System.out.print("Enter the number of the offering you want to book (0 to cancel): ");
        int offeringChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (offeringChoice > 0 && offeringChoice <= availableOfferings.size()) {
            Offering selectedOffering = availableOfferings.get(offeringChoice - 1);

            if (hasConflictingBooking(client, selectedOffering)) {
                System.out.println("You already have a booking at this time. Cannot make another booking.");
                return;
            }

            Booking newBooking;
            if (choice == 1) {
                newBooking = new Booking(client, selectedOffering);
            } else {
                Child selectedChild = selectChild(client, scanner);
                if (selectedChild == null) return;
                newBooking = new Booking(selectedOffering, client, selectedChild);
            }

            client.addBooking(newBooking);
            selectedOffering.addBooking(newBooking);
            System.out.println("Booking made successfully.");
        } else if (offeringChoice != 0) {
            System.out.println("Invalid selection. Please try again.");
        }
    }

    private static List<Offering> getAvailableOfferings() {
        List<Offering> allOfferings = OrganisationData.getOrganisation().getOfferings();
        List<Offering> availableOfferings = new ArrayList<Offering>();
        for (Offering offering : allOfferings) {
            if (offering.isAvailable() && !offering.isFull()) {
                availableOfferings.add(offering);
            }
        }
        return availableOfferings;
    }

    private static boolean hasConflictingBooking(Client client, Offering newOffering) {
        for (Booking existingBooking : client.getListOfBooks()) {
            if (existingBooking.getOffering().getSchedule().overlaps(newOffering.getSchedule())) {
                return true;
            }
        }
        return false;
    }

    private static Child selectChild(Client client, Scanner scanner) {
        List<Child> children = client.getListOfChildrens();
        if (children.isEmpty()) {
            System.out.println("You have no registered children. Please add a child first.");
            return null;
        }

        System.out.println("Select a child:");
        for (int i = 0; i < children.size(); i++) {
            System.out.println((i + 1) + ". " + children.get(i).getName());
        }

        System.out.print("Enter the number of the child: ");
        int childChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (childChoice > 0 && childChoice <= children.size()) {
            return children.get(childChoice - 1);
        } else {
            System.out.println("Invalid selection.");
            return null;
        }
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
