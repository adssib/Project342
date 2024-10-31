package Menu;

import Data.Geography.OrganisationData;
import Geography.Organisation;
import UserManagment.Admin;
import UserManagment.User;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminMenu {

    public static void adminMenu(Admin admin, Scanner scanner) {
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
                    ManageUsers(scanner) ;
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


    private static void ManageUsers(Scanner scanner) {
        boolean isDone = false;
        while (!isDone) {
            System.out.println("\nManage Users");
            System.out.println("1. View Users");
            System.out.println("2. Delete User by ID");
            System.out.println("3. Back to Admin Menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewUsers();
                    break;
                case 2:
                    deleteUserById(scanner);
                    break;
                case 3:
                    isDone = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void viewUsers() {
        Organisation org = OrganisationData.getOrganisation();
        ArrayList<User> users = org.getUsers();
        System.out.println("\nAll Users:");
        for (User user : users) {
            System.out.println("ID: " + user.getUserId() + ", Name: " + user.getUserName() + ", Type: " + user.getClass().getSimpleName());
        }
    }

    private static void deleteUserById(Scanner scanner) {
        Organisation org = OrganisationData.getOrganisation();
        ArrayList<User> users = org.getUsers();

        System.out.print("Enter the ID of the user to delete: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        User userToDelete = null;
        for (User user : users) {
            if (user.getUserId() == userId) {
                userToDelete = user;
                break;
            }
        }

        if (userToDelete != null) {
            users.remove(userToDelete);
            System.out.println("User with ID " + userId + " has been deleted.");
        } else {
            System.out.println("User with ID " + userId + " not found.");
        }
    }

}
