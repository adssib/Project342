import Data.Geography.OrganisationData;
import Geography.Organisation;
import UserManagment.User;
import UserManagment.Client;
import UserManagment.Admin;
import Services.Offering;
import java.util.Scanner;
import java.util.List;

public class Main {
    private static Organisation org;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        OrganisationData.generateOrganisationData();
        org = OrganisationData.getOrganisation();

        while (true) {
            User currentUser = publicMenu();
            if (currentUser != null) {
                Menu.generateMenu(currentUser);
            }
        }
    }

    private static User publicMenu() {
        while (true) {
            System.out.println("\nWelcome to the Learning Center");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. View Public Offerings");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    return login();
                case 2:
                    register();
                    break;
                case 3:
                    viewPublicOfferings();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static User login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (username.equals("admin") && password.equals("admin")) {
            return new Admin(0, "Admin", "admin", "0000000000");
        }

        for (User user : org.getUsers()) {
            if (user.logIn(username, password)) {
                System.out.println("Login successful!");
                return user;
            }
        }

        System.out.println("Invalid username or password. Please try again.");
        return null;
    }

    private static void register() {
        System.out.print("Enter new username: ");
        String username = scanner.nextLine();
        System.out.print("Enter new password: ");
        String password = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        int newUserId = org.getUsers().size() + 1; // Simple way to generate a new ID
        Client newClient = new Client(newUserId, username, password, phoneNumber);
        org.addUser(newClient);
        System.out.println("Registration successful! You can now login.");
    }

    private static void viewPublicOfferings() {
        List<Offering> offerings = Offering.getAllOfferings();
        System.out.println("\nPublic Offerings:");
        for (Offering offering : offerings) {
            if (offering.isAvailable()) {
                System.out.println("Offering : " + offering.toString());
                System.out.println("--------------------");
            }
        }
    }
}