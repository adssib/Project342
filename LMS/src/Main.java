import Menu.AdminMenu;
import Menu.ClientMenu;

import java.sql.*;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMainMenu();
        }
    }

    // Display the main menu
    private static void showMainMenu() {
        System.out.println("\nWelcome to the Learning Center");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. View Public Offerings");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");

        int choice = 0;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number!");
            return;
        }

        switch (choice) {
            case 1:
                login();
                break;
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

    // Establish MySQL Database Connection
    private static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/LearningCenter";
        String user = "root"; // Replace with your MySQL username
        String password = "Moha514#"; // Replace with your MySQL password
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Error: Unable to connect to the database.");
            e.printStackTrace();
            return null;
        }
    }

    private static void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        try (Connection conn = getConnection()) {
            // Check if the user exists in the 'clients' table
            String query = "SELECT * FROM clients WHERE username = ? AND password = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    System.out.println("Login successful! Welcome, " + username + ".");
                    ClientMenu.displayClientMenu(username);  // Redirect to ClientMenu
                    return;
                }
            }

            // Check if the user exists in the 'instructors' table
            query = "SELECT * FROM instructors WHERE username = ? AND password = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    System.out.println("Login successful! Welcome, " + username + ".");
                    InstructorMenu();  // Redirect to InstructorMenu
                    return;
                }
            }

            // Check if the user exists in the 'admins' table
            query = "SELECT * FROM admin WHERE username = ? AND password = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    System.out.println("Login successful! Welcome, " + username + ".");
                    AdminMenu.displayAdminMenu();  // Redirect to AdminMenu
                    return;
                }
            }

            // If no user found
            System.out.println("Invalid username or password.");

        } catch (SQLException e) {
            System.out.println("Error: Unable to perform login.");
            e.printStackTrace();
        }
    }


    private static void register() {
        System.out.print("Enter new username: ");
        String username = scanner.nextLine();
        System.out.print("Enter new password: ");
        String password = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        // Ask whether the user is a client or an instructor
        System.out.print("Are you a client or an instructor? (Enter 'client' or 'instructor'): ");
        String role = scanner.nextLine().toLowerCase();

        String query = "";
        String tableName = "";

        // Determine which table to insert based on role
        if ("client".equals(role)) {
            tableName = "clients";
        } else if ("instructor".equals(role)) {
            tableName = "instructors";
        } else {
            System.out.println("Invalid role. Please enter 'client' or 'instructor'.");
            return;
        }

        // Prepare the SQL insert query
        query = "INSERT INTO " + tableName + " (username, password, phone_number) VALUES (?, ?, ?)";

        try (Connection conn = getConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                stmt.setString(3, phoneNumber);
                stmt.executeUpdate();
                System.out.println("Registration successful! You can now log in.");
            }
        } catch (SQLException e) {
            System.out.println("Error: Unable to register the user.");
            e.printStackTrace();
        }
    }


    // Method to view public offerings from MySQL database
    private static void viewPublicOfferings() {
        try (Connection conn = getConnection()) {
            String query = "SELECT * FROM offerings WHERE is_available = 1";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                ResultSet rs = stmt.executeQuery();
                System.out.println("\nPublic Offerings:");
                while (rs.next()) {
                    System.out.println("Offering: " + rs.getString("name"));
                    System.out.println("Description: " + rs.getString("description"));
                    System.out.println("--------------------");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: Unable to fetch offerings.");
            e.printStackTrace();
        }
    }
}
