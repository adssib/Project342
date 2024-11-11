//package Menu;
//
//import Data.Geography.OrganisationData;
//import Geography.Location;
//import Geography.Organisation;
//import Geography.Space;
//import Services.Booking;
//import Services.Lesson.Lesson;
//import Services.Offering;
//import UserManagment.Admin;
//import UserManagment.User;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//import static Data.Geography.LocationDataGenerator.generateLocations;
//
//public class AdminMenu {
//
//    public static void adminMenu(Admin admin, Scanner scanner) {
//        boolean isDone = false;
//        while (!isDone) {
//            System.out.println("\nAdmin Menu");
//            System.out.println("1. Manage Users");
//            System.out.println("2. Manage Offerings");
//            System.out.println("3. Manage Bookings");
//            System.out.println("4. Logout"); //Done
//            System.out.print("Choose an option: ");
//
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // Consume newline
//
//            switch (choice) {
//                case 1:
//                    System.out.println("Managing Users...");
//                    ManageUsers(scanner) ;
//                    break;
//                case 2:
//                    System.out.println("Managing Offerings...");
//                    ManageOfferings(scanner);
//                    break;
//                case 3:
//                    System.out.println("Manage Bookings...");
//                    ManageBookings();
//                    break;
//                case 4:
//                    System.out.println("Logging out...");
//                    isDone = true;
//                    break;
//                default:
//                    System.out.println("Invalid option. Please try again.");
//            }
//        }
//    }
//
//    private static void ManageBookings() {
//        Organisation org = OrganisationData.getOrganisation();
//        List<Booking> bookings = org.getBookings();
//
//        System.out.println("\nAll Bookings:");
//        if (bookings.isEmpty()) {
//            System.out.println("No bookings found.");
//        } else {
//            for (Booking booking : bookings) {
//                System.out.println(booking.toString());
//            }
//        }
//    }
//
//    private static void ManageOfferings(Scanner scanner) {
//        boolean isDone = false;
//        while (!isDone) {
//            System.out.println("\nManage Offerings");
//            System.out.println("1. View Offerings");
//            System.out.println("2. Create New Offering");
//            System.out.println("3. Delete Offering");
//            System.out.println("4. Back to Admin Menu");
//            System.out.print("Choose an option: ");
//
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // Consume newline
//
//            switch (choice) {
//                case 1:
//                    viewOfferings();
//                    break;
//                case 2:
//                    createOffering(scanner);
//                    break;
//                case 3:
//                    deleteOffering(scanner);
//                    break;
//                case 4:
//                    isDone = true;
//                    break;
//                default:
//                    System.out.println("Invalid option. Please try again.");
//            }
//        }
//    }
//
//    private static void createOffering(Scanner scanner) {
//        Organisation org = OrganisationData.getOrganisation();
//        Admin admin = (Admin) org.getUsers().stream().filter(u -> u instanceof Admin).findFirst().orElse(null);
//
//        if (admin == null) {
//            System.out.println("Error: Admin not found.");
//            return;
//        }
//
//        // Get location (space)
//        ArrayList<Space> spaces = org.getSpaces(); // Changed to getSpaces
//        System.out.println("Available Spaces:");
//        for (int i = 0; i < spaces.size(); i++) {
//            Space space = spaces.get(i);
//            System.out.println((i + 1) + ". " + space.getDescription() + " in " + space.getLocationOfSpace().getCity().getCityName());
//        }
//        System.out.print("Choose space (enter number): ");
//        int spaceChoice = scanner.nextInt();
//        scanner.nextLine(); // Consume newline
//        Space selectedSpace = spaces.get(spaceChoice - 1);
//        Location location = selectedSpace.getLocationOfSpace();
//
//        // Get date
//        System.out.print("Enter date (YYYY-MM-DD): ");
//        String dateString = scanner.nextLine();
//        LocalDate date = LocalDate.parse(dateString);
//
//        // Get start time
//        System.out.print("Enter start time (HH:MM): ");
//        String startTimeString = scanner.nextLine();
//        LocalTime startTime = LocalTime.parse(startTimeString);
//
//        // Get end time
//        System.out.print("Enter end time (HH:MM): ");
//        String endTimeString = scanner.nextLine();
//        LocalTime endTime = LocalTime.parse(endTimeString);
//
//        // Get lesson
//        List<Lesson> lessons = org.getLessons();
//        System.out.println("Available Lessons:");
//        for (int i = 0; i < lessons.size(); i++) {
//            System.out.println((i + 1) + ". " + lessons.get(i).getTypeOfLesson());
//        }
//        System.out.print("Choose lesson (enter number): ");
//        int lessonChoice = scanner.nextInt();
//        scanner.nextLine(); // Consume newline
//        Lesson lesson = lessons.get(lessonChoice - 1);
//
//        admin.createOffering(location, date, startTime, endTime, lesson);
//    }
//
//    private static void viewOfferings() {
//        Organisation org = OrganisationData.getOrganisation();
//        ArrayList<Offering> offerings = org.getOfferings();
//
//        System.out.println("\nAll Offerings:");
//        if (offerings.isEmpty()) {
//            System.out.println("No offerings found.");
//        } else {
//            for (Offering offering : offerings) {
//                System.out.println(offering.toString());
//            }
//        }
//    }
//    private static void deleteOffering(Scanner scanner) {
//        Organisation org = OrganisationData.getOrganisation();
//        Admin admin = (Admin) org.getUsers().stream().filter(u -> u instanceof Admin).findFirst().orElse(null);
//
//        if (admin == null) {
//            System.out.println("Error: Admin not found.");
//            return;
//        }
//
//        System.out.print("Enter the ID of the offering to delete: ");
//        int offeringId = scanner.nextInt();
//        scanner.nextLine(); // Consume newline
//
//        admin.deleteOffering(offeringId);
//    }
//
//
//    private static void ManageUsers(Scanner scanner) {
//        boolean isDone = false;
//        while (!isDone) {
//            System.out.println("\nManage Users");
//            System.out.println("1. View Users");
//            System.out.println("2. Delete User by ID");
//            System.out.println("3. Back to Admin Menu");
//            System.out.print("Choose an option: ");
//
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // Consume newline
//
//            switch (choice) {
//                case 1:
//                    viewUsers();
//                    break;
//                case 2:
//                    deleteUserById(scanner);
//                    break;
//                case 3:
//                    isDone = true;
//                    break;
//                default:
//                    System.out.println("Invalid option. Please try again.");
//            }
//        }
//    }
//
//    private static void viewUsers() {
//        Organisation org = OrganisationData.getOrganisation();
//        ArrayList<User> users = org.getUsers();
//        System.out.println("\nAll Users:");
//        for (User user : users) {
//            System.out.println("ID: " + user.getUserId() + ", Name: " + user.getUserName() + ", Type: " + user.getClass().getSimpleName());
//        }
//    }
//
//    private static void deleteUserById(Scanner scanner) {
//        Organisation org = OrganisationData.getOrganisation();
//        ArrayList<User> users = org.getUsers();
//
//        System.out.print("Enter the ID of the user to delete: ");
//        int userId = scanner.nextInt();
//        scanner.nextLine(); // Consume newline
//
//        User userToDelete = null;
//        for (User user : users) {
//            if (user.getUserId() == userId) {
//                userToDelete = user;
//                break;
//            }
//        }
//
//        if (userToDelete != null) {
//            users.remove(userToDelete);
//            System.out.println("User with ID " + userId + " has been deleted.");
//        } else {
//            System.out.println("User with ID " + userId + " not found.");
//        }
//    }
//
//}
