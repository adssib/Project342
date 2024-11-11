package Menu;
import java.sql.*;
import java.util.Scanner;

public class ClientMenu {
    private static final Scanner scanner = new Scanner(System.in);
    private static int clientId;  // To store the client ID

    // Entry point for displaying the client menu based on username
    public static void displayClientMenu(String username) {
        clientId = getClientId(username);  // Retrieve clientId based on username
        if (clientId == -1) {
            System.out.println("Error: Client ID not found for the given username.");
            return;  // Exit if client ID cannot be retrieved
        }

        while (true) {
            System.out.println("\n--- Client Menu ---");
            System.out.println("1. View Bookings");
            System.out.println("2. Make a Booking");
            System.out.println("3. View Public Offerings");
            System.out.println("4. Cancel Booking");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    viewBookings();
                    break;
                case 2:
                    makeBooking();
                    break;
                case 3:
                    viewPublicOfferings();
                    break;
                case 4:
                    cancelBooking();
                    break;
                case 5:
                    System.out.println("Logging out...");
                    return;  // Exit menu loop to log out
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static int getClientId(String username) {
        String query = "SELECT id FROM clients WHERE username = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println("Error: Unable to retrieve client ID.");
            e.printStackTrace();
        }
        return -1;  // Return -1 if client ID could not be found
    }

    private static void viewBookings() {
        System.out.println("\n--- Your Bookings ---");
        String query = "SELECT * FROM bookings WHERE booking_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, clientId);  // Use clientId to filter bookings
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.printf("Booking ID: %d | Offering ID: %d | Date: %s%n",
                        rs.getInt("booking_id"), rs.getInt("offering_id"), rs.getDate("date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Implement the makeBooking method with instructor filter
    private static void makeBooking() {
        System.out.println("\n--- Available Offerings with Instructors ---");
        String query = "SELECT o.offering_id, o.title, o.description, i.instructor_id " +
                "FROM offerings o JOIN instructors i ON o.instructor_id = i.instructor_id";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            // Display available offerings with instructors
            while (rs.next()) {
                System.out.printf("Offering ID: %d | Title: %s | Description: %s | Instructor ID: %d%n",
                        rs.getInt("offering_id"), rs.getString("title"), rs.getString("description"),
                        rs.getInt("instructor_id"));
            }

            System.out.print("\nEnter the Offering ID you would like to book: ");
            int offeringId = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            // Make sure the clientId is correctly assigned (retrieve from login or session)
            int cID = clientId;  // Replace with actual client ID logic

            // Ensure all required fields are included in the INSERT query
            String bookingQuery = "INSERT INTO bookings (user_id, offering_id) VALUES (?, ?)";

            try (PreparedStatement bookingStmt = conn.prepareStatement(bookingQuery)) {
                bookingStmt.setInt(1, clientId);
                bookingStmt.setInt(2, offeringId);

                int rowsAffected = bookingStmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Booking successfully created!");
                } else {
                    System.out.println("Error: Booking could not be created.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: Unable to make a booking.");
            e.printStackTrace();
        }
    }


    // Implement the cancelBooking method with listing of current bookings
    private static void cancelBooking() {
        System.out.println("\n--- Your Current Bookings ---");
        String query = "SELECT booking_id, offering_id FROM bookings WHERE user_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, clientId);  // Use clientId to filter bookings
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.printf("Booking ID: %d | Offering ID: %d%n",
                        rs.getInt("booking_id"), rs.getInt("offering_id"));
            }

            System.out.print("\nEnter the Booking ID you would like to cancel: ");
            int bookingId = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            String deleteQuery = "DELETE FROM bookings WHERE booking_id = ? AND user_id = ?";
            try (PreparedStatement deleteStmt = conn.prepareStatement(deleteQuery)) {
                deleteStmt.setInt(1, bookingId);
                deleteStmt.setInt(2, clientId);
                int rowsAffected = deleteStmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Booking successfully canceled.");
                } else {
                    System.out.println("Error: Booking could not be canceled.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: Unable to cancel the booking.");
            e.printStackTrace();
        }
    }

    private static void viewPublicOfferings() {
        System.out.println("\n--- Public Offerings ---");
        String query = "SELECT * FROM offerings";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.printf("Offering ID: %d | Title: %s | Description: %s ",
                        rs.getInt("offering_id"), rs.getString("title"),
                        rs.getString("description"));
            }

            System.out.println();

        } catch (SQLException e) {
            System.out.println("Error: Unable to retrieve public offerings.");
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/LearningCenter", "root", "Moha514#");
    }
}
