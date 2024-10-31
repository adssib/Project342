import UserManagment.*;
import Services.* ;
import Geography.* ;

import java.util.List;
import java.util.Scanner;

/**
 * TO DO List of Features:
 *  1. Log out for all users
 *  for admin:
 *      1. View Users
 *      2. View bookings
 *      3. View Offerings
 *      4. Delete User
 *  for instructors:
 *      1. View Account
 *      2. View Taken Offerings
 *      3. take New Offerings
 *      4. View Profile
 *  for Clients:
 *      1. View Made Bookings
 *      2. View Public Offerings
 *      3. Make a booking
 *      4. Make a booking for a child
 *      5. Manage Children list (add, delete)
 * Things to take care off:
 *  for admin when creating offering make sure it is unique
 *  for instructor, taking an offering means it should be in one of his available Cities
 *  for client no booking on the same date nor same time for 2 things is allowed
 */

public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public static void generateMenu(User user) {
        switch (user) {
            case Admin admin -> adminMenu(admin);
            case Instructor instructor -> instructorMenu(instructor);
            case Client client -> clientMenu(client);
            case null, default -> System.out.println("Unknown user type");
        }
    }

    private static void adminMenu(Admin admin) {
        boolean isDone = false;
        while (!isDone) {
            System.out.println("\nAdmin Menu");
            System.out.println("1. Manage Users");
            System.out.println("2. Manage Offerings");
            System.out.println("3. Manage Bookings");
            System.out.println("4. Logout"); //Done
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Managing Users...");
                    break;
                case 2:
                    System.out.println("Managing Offerings...");
                    break;
                case 3:
                    System.out.println("Manage Bookings...");
                    break;
                case 4:
                    System.out.println("Logging out...");
                    isDone = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void instructorMenu(Instructor instructor) {
        boolean isDone = false;
        while (!isDone) {
            System.out.println("\nInstructor Menu");
            System.out.println("1. View Available Cities");
            System.out.println("2. View Taken Offerings");
            System.out.println("3. Take New Offering");
            System.out.println("4. View Profile");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Viewing Available Cities...");
                    List<City> cities= instructor.getAvailable();
                    if(cities.isEmpty()){
                        System.out.println("No cities available");
                    }else {
                        for (City city : cities) {
                            System.out.println(city.getCityName());
                        }
                    }
                    break;
                case 2:
                    System.out.println("Viewing Taken Offerings...");
                    for (Offering offering : instructor.getTakenOfferings()) {
                        System.out.println("Offering ID: " + offering.getOfferingId() +
                                ", Lesson: " + offering.getLesson().getTypeOfLesson());
                    }
                    break;
                case 3:
                    System.out.println("Taking New Offering...");
                    // Implement logic to take new offering
                    break;
                case 4:
                    System.out.println("Viewing Profile...");
                    System.out.println("Name: " + instructor.getUserName());
                    System.out.println("Specialisation: " + instructor.getSpecialisation());
                    System.out.println("Phone: " + instructor.getPhoneNumber());
                    break;
                case 5:
                    System.out.println("Logging out...");
                    isDone = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void clientMenu(Client client) {
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