//package Menus;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//import Services.Lesson.Lesson;
//
//public class MainMenu {
//
//    private static Scanner scanner = new Scanner(System.in);
//
//    public static void mainMenu() {
//        boolean running = true;
//
//        while (running) {
//            displayMenu();
//            int choice = getChoice();
//
//            switch (choice) {
//                case 1:
//                    login();
//                    break;
//                case 2:
//                    register();
//                    break;
//                case 3:
//                    viewOfferings();
//                    break;
//                case 4:
//                    System.out.println("Exiting the program. Goodbye!");
//                    running = false;
//                    break;
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        }
//
//        scanner.close();
//    }
//
//    private static void displayMenu() {
//        System.out.println("\nMain Menu:");
//        System.out.println("1. Login");
//        System.out.println("2. Register");
//        System.out.println("3. View Offerings");
//        System.out.println("4. Exit");
//        System.out.print("Enter your choice: ");
//    }
//
//    private static int getChoice() {
//        while (!scanner.hasNextInt()) {
//            System.out.print("Please enter a valid number: ");
//            scanner.next();
//        }
//        return scanner.nextInt();
//    }
//
//    private static void login() {
//        System.out.print("Enter username: ");
//        String username = scanner.next();
//        System.out.print("Enter password: ");
//        String password = scanner.next();
//
//        for (User user : users) {
//            if (user.username.equals(username) && user.password.equals(password)) {
//                System.out.println("Login successful! Welcome, " + username + ".");
//
//                // Redirect to the appropriate menu based on role
//                switch (user.role) {
//                    case ADMIN:
//                        adminMenu();
//                        break;
//                    case INSTRUCTOR:
//                        instructorMenu();
//                        break;
//                    case CLIENT:
//                        clientMenu();
//                        break;
//                }
//                return;
//            }
//        }
//        System.out.println("Invalid username or password. Please try again.");
//    }
//
//    private static void register() {
//        System.out.print("Enter a new username: ");
//        String username = scanner.next();
//        System.out.print("Enter a new password: ");
//        String password = scanner.next();
//        System.out.print("Enter your phone number: ");
//        String phoneNumber = scanner.next();
//
//        // Choose role
//        System.out.println("Select role (1 for Admin, 2 for Instructor, 3 for Client): ");
//        int roleChoice = getChoice();
//        Role role;
//
//        switch (roleChoice) {
//            case 1:
//                role = Role.ADMIN;
//                break;
//            case 2:
//                role = Role.INSTRUCTOR;
//                break;
//            case 3:
//                role = Role.CLIENT;
//                break;
//            default:
//                System.out.println("Invalid role choice. Registration failed.");
//                return;
//        }
//
//        // Check if username already exists
//        for (User user : users) {
//            if (user.username.equals(username)) {
//                System.out.println("Username already exists. Please choose another one.");
//                return;
//            }
//        }
//
//        // Register new user
//        users.add(new User(username, password, phoneNumber, role));
//        System.out.println("Registration successful! You can now log in with your credentials.");
//    }
//
//    private static void viewOfferings() {
//        System.out.println("Our offerings include:");
//        System.out.println("1. Premium Membership");
//        System.out.println("2. Basic Membership");
//        System.out.println("3. Free Trial");
//        System.out.println("4. Online Courses");
//        System.out.println("5. Product Discounts");
//    }
//
//    private static void adminMenu() {
//        boolean running = true;
//        while (running) {
//            System.out.println("\nAdmin Menu:");
//            System.out.println("1. Create Offering");
//            System.out.println("2. View Offerings");
//            System.out.println("3. Delete User");
//            System.out.println("4. View Booking");
//            System.out.println("5. Delete Booking");
//            System.out.println("6. Exit");
//            System.out.print("Enter your choice: ");
//            int choice = getChoice();
//
//            switch (choice) {
//                case 1:
//                        // Prompt for location
//                    // System.out.print("Enter location name: ");
//                    // String locationName = scanner.next();
//                    // Location location = new Location(locationName);
//
//                    // // Prompt for date
//                    // System.out.print("Enter date (YYYY-MM-DD): ");
//                    // LocalDate date = LocalDate.parse(scanner.next());
//
//                    // // Prompt for start time
//                    // System.out.print("Enter start time (HH:MM): ");
//                    // LocalTime startTime = LocalTime.parse(scanner.next());
//
//                    // // Prompt for end time
//                    // System.out.print("Enter end time (HH:MM): ");
//                    // LocalTime endTime = LocalTime.parse(scanner.next());
//
//                    // // Prompt for lesson name
//                    // System.out.print("Enter lesson name: ");
//                    // String lessonName = scanner.next();
//                    // Lesson lesson = new Lesson(lessonName);
//
//                    // // Call the method to create the offering
//                    // createOffering(location, date, startTime, endTime, lesson);
//                    break;
//                case 2:
//                    viewOfferings();
//                    break;
//                case 3:
//                    System.out.println("Deleting User...");
//                    // Implement delete user logic
//                    break;
//                case 4:
//                    System.out.println("Viewing Bookings...");
//                    // Implement view booking logic
//                    break;
//                case 5:
//                    System.out.println("Deleting Booking...");
//                    // Implement delete booking logic
//                    break;
//                case 6:
//                    running = false;
//                    break;
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        }
//    }
//
//    private static void instructorMenu() {
//        boolean running = true;
//        while (running) {
//            System.out.println("\nInstructor Menu:");
//            System.out.println("1. Take Offering");
//            System.out.println("2. Add Availability");
//            System.out.println("3. View Offerings");
//            System.out.println("4. Exit");
//            System.out.print("Enter your choice: ");
//            int choice = getChoice();
//
//            switch (choice) {
//                case 1:
//                    System.out.println("Taking Offering...");
//                    // Implement take offering logic
//                    break;
//                case 2:
//                    System.out.println("Adding Availability...");
//                    // Implement add availability logic
//                    break;
//                case 3:
//                    viewOfferings();
//                    break;
//                case 4:
//                    running = false;
//                    break;
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        }
//    }
//
//    private static void clientMenu() {
//        boolean running = true;
//        while (running) {
//            System.out.println("\nClient Menu:");
//            System.out.println("1. View Offerings");
//            System.out.println("2. Take Offering");
//            System.out.println("3. Exit");
//            System.out.print("Enter your choice: ");
//            int choice = getChoice();
//
//            switch (choice) {
//                case 1:
//                    viewOfferings();
//                    break;
//                case 2:
//                    System.out.println("Taking Offering...");
//                    // Implement take offering logic
//                    break;
//                case 3:
//                    running = false;
//                    break;
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        }
//    }
//}
