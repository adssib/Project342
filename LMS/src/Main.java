import Menu.AdminMenu;
import Menu.ClientMenu;
import Menu.InstructorMenu;

import java.sql.*;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

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

    // Login logic
    private static void login() {
        lock.readLock().lock(); // Acquire read lock
        try {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            try (Connection conn = DatabaseConnection.getConnection()) {
                String query = "SELECT * FROM clients WHERE username = ? AND password = ?";
                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setString(1, username);
                    stmt.setString(2, password);
                    ResultSet rs = stmt.executeQuery();
                    if (rs.next()) {
                        System.out.println("Login successful! Welcome, " + username + ".");
                        ClientMenu.displayClientMenu(username);
                        return;
                    }
                }

                query = "SELECT * FROM instructors WHERE username = ? AND password = ?";
                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setString(1, username);
                    stmt.setString(2, password);
                    ResultSet rs = stmt.executeQuery();
                    if (rs.next()) {
                        System.out.println("Login successful! Welcome, " + username + ".");
                        InstructorMenu.displayInstructorMenu(username);
                        return;
                    }
                }

                query = "SELECT * FROM admin WHERE username = ? AND password = ?";
                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setString(1, username);
                    stmt.setString(2, password);
                    ResultSet rs = stmt.executeQuery();
                    if (rs.next()) {
                        System.out.println("Login successful! Welcome, " + username + ".");
                        AdminMenu.displayAdminMenu();
                        return;
                    }
                }

                System.out.println("Invalid username or password.");
            } catch (SQLException e) {
                System.out.println("Error: Unable to perform login.");
                e.printStackTrace();
            }
        } finally {
            lock.readLock().unlock(); // Release read lock
        }
    }

    // Registration logic
    private static void register() {
        lock.writeLock().lock(); // Acquire write lock
        try {
            System.out.print("Enter new username: ");
            String username = scanner.nextLine();
            System.out.print("Enter new password: ");
            String password = scanner.nextLine();
            System.out.print("Enter phone number: ");
            String phoneNumber = scanner.nextLine();

            System.out.print("Are you a client or an instructor? (Enter 'client' or 'instructor'): ");
            String role = scanner.nextLine().toLowerCase();

            String query = "";
            String tableName = "";

            if ("client".equals(role)) {
                tableName = "clients";
            } else if ("instructor".equals(role)) {
                tableName = "instructors";
            } else {
                System.out.println("Invalid role. Please enter 'client' or 'instructor'.");
                return;
            }

            query = "INSERT INTO " + tableName + " (username, password, phone_number) VALUES (?, ?, ?)";

            try (Connection conn = DatabaseConnection.getConnection()) {
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
        } finally {
            lock.writeLock().unlock(); // Release write lock
        }
    }

    // View public offerings
    private static void viewPublicOfferings() {
        lock.readLock().lock(); // Acquire read lock
        try {
            String query = "SELECT * FROM offerings WHERE instructor_id IS NOT NULL";

            System.out.println("\n--- Available Offerings with Instructors ---");

            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(query);
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    System.out.printf("Offering ID: %d | Title: %s | Description: %s%n",
                            rs.getInt("offering_id"), rs.getString("title"),
                            rs.getString("description"));
                }
            } catch (SQLException e) {
                System.out.println("Error: Unable to retrieve public offerings.");
                e.printStackTrace();
            }
        } finally {
            lock.readLock().unlock(); // Release read lock
        }
    }
}
