package Menu;
import java.sql.*;
import java.util.Scanner;

public class AdminMenu {
    private static final Scanner scanner = new Scanner(System.in);

    // Main AdminMenu
    public static void displayAdminMenu() {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Manage Users");
            System.out.println("2. Manage Offerings");
            System.out.println("3. Manage Bookings");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    manageUsers();
                    break;
                case 2:
                    manageOfferings();
                    break;
                case 3:
                    manageBookings();
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void manageUsers() {
        System.out.println("\n--- Manage Users ---");
        System.out.println("1. View all users");
        System.out.println("2. Delete a user");
        System.out.print("Choose an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        switch (choice) {
            case 1:
                viewAllUsers();
                break;
            case 2:
                deleteUser();
                break;

            default:
                System.out.println("Invalid option.");
        }
    }

    private static void viewAllUsers() {
        try (Connection conn = getConnection()) {
            System.out.println("\n--- All Users ---");

            String query = "SELECT 'Client' as role, username, phone_number FROM clients " +
                    "UNION ALL " +
                    "SELECT 'Instructor' as role, username, phone_number FROM instructors " +
                    "UNION ALL " +
                    "SELECT 'Admin' as role, username, phone_number FROM admins";

            try (PreparedStatement stmt = conn.prepareStatement(query);
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    System.out.printf("Role: %s | Username: %s | Phone: %s%n",
                            rs.getString("role"), rs.getString("username"), rs.getString("phone_number"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteUser() {
        System.out.print("Enter username of the user to delete: ");
        String username = scanner.nextLine();

        String[] tables = {"clients", "instructors", "admin"};
        for (String table : tables) {
            String query = "DELETE FROM " + table + " WHERE username = ?";
            try (Connection conn = getConnection();
                 PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, username);
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("User deleted from " + table + ".");
                    return;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("User not found.");
    }

    private static void manageOfferings() {
        System.out.println("\n--- Manage Offerings ---");
        System.out.println("1. View all offerings");
        System.out.println("2. Add a new offering");
        System.out.println("3. Delete an offering");
        System.out.print("Choose an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                viewAllOfferings();
                break;
            case 2:
                addOffering();
                break;
            case 3:
                deleteOffering();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private static void viewAllOfferings() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM offerings")) {
            while (rs.next()) {
                System.out.printf("ID: %d | Lesson: %s | Location: %s | Instructor ID: %d | Available: %b%n",
                        rs.getInt("offering_id"), rs.getString("lesson"), rs.getString("location"),
                        rs.getInt("instructor_id"), rs.getBoolean("is_available"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addOffering() {
        System.out.print("Enter lesson ID: ");
        int lessonId = scanner.nextInt();
        System.out.print("Enter location ID: ");
        int locationId = scanner.nextInt();
        System.out.print("Enter instructor ID: ");
        int instructorId = scanner.nextInt();

        String query = "INSERT INTO offerings (lesson_id, location_id, instructor_id, is_available) VALUES (?, ?, ?, true)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, lessonId);
            stmt.setInt(2, locationId);
            stmt.setInt(3, instructorId);
            stmt.executeUpdate();
            System.out.println("Offering added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteOffering() {
        System.out.print("Enter offering ID to delete: ");
        int offeringId = scanner.nextInt();

        String query = "DELETE FROM offerings WHERE offering_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, offeringId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Offering deleted successfully.");
            } else {
                System.out.println("Offering not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void manageBookings() {
        System.out.println("\n--- Manage Bookings ---");
        System.out.println("1. View all bookings");
        System.out.println("2. Delete a booking");
        System.out.print("Choose an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                viewAllBookings();
                break;
            case 2:
                deleteBooking();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private static void viewAllBookings() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM bookings")) {
            while (rs.next()) {
                System.out.printf("Booking ID: %d | User ID: %d | Offering ID: %d%n",
                        rs.getInt("booking_id"), rs.getInt("user_id"), rs.getInt("offering_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteBooking() {
        System.out.print("Enter booking ID to delete: ");
        int bookingId = scanner.nextInt();

        String query = "DELETE FROM bookings WHERE booking_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, bookingId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Booking deleted successfully.");
            } else {
                System.out.println("Booking not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Placeholder for actual connection handling
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/LearningCenter", "root", "Moha514#");
    }
}
