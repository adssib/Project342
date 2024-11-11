package Menu;

import java.sql.*;
import java.util.Scanner;

public class InstructorMenu {
    private static final Scanner scanner = new Scanner(System.in);
    private static int instructorId;  // To store the instructor ID

    // Entry point to display the instructor menu options
    public static void displayInstructorMenu(String username) {
        instructorId = getInstructor(username);  // Retrieve instructorId based on username
        if (instructorId == -1) {
            System.out.println("Error: Instructor ID not found for the given username.");
            return;  // Exit if instructor ID cannot be retrieved
        }

        while (true) {
            System.out.println("\n--- Instructor Menu ---");
            System.out.println("1. View Offerings");
            System.out.println("2. Take New Offering");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    viewOfferings();
                    break;
                case 2:
                    takeOffering();
                    break;
                case 3:
                    System.out.println("Logging out...");
                    return;  // Exit menu loop to log out
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Retrieve the instructor's ID based on the username
    private static int getInstructor(String username) {
        String query = "SELECT instructor_id FROM instructors WHERE username = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("instructor_id");
            }
        } catch (SQLException e) {
            System.out.println("Error: Unable to retrieve instructor ID.");
            e.printStackTrace();
        }
        return -1;  // Return -1 if instructor ID could not be found
    }

    // View the offerings that do not have an instructor assigned
    private static void viewOfferings() {
        System.out.println("\n--- Offerings without Instructor ---");
        String query = "SELECT offering_id, title, description FROM offerings WHERE instructor_id IS NULL";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            if (!rs.isBeforeFirst()) {
                System.out.println("No offerings available without an instructor.");
                return;
            }

            System.out.println("Offerings without instructor:");
            while (rs.next()) {
                System.out.printf("Offering ID: %d | Title: %s | Description: %s%n",
                        rs.getInt("offering_id"), rs.getString("title"),
                        rs.getString("description"));
            }
        } catch (SQLException e) {
            System.out.println("Error: Unable to retrieve offerings.");
            e.printStackTrace();
        }
    }

    // Allow the instructor to take a new offering (assigning an instructor to an offering)
    private static void takeOffering() {
        System.out.print("Enter the Offering ID you want to take: ");
        int offeringId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        // Check if the offering is available (not already assigned to an instructor)
        String checkQuery = "SELECT offering_id FROM offerings WHERE offering_id = ? AND instructor_id IS NULL";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(checkQuery)) {
            stmt.setInt(1, offeringId);
            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                System.out.println("This offering is either already assigned or does not exist.");
                return;
            }

            // Assign the offering to the instructor
            String assignQuery = "UPDATE offerings SET instructor_id = ? WHERE offering_id = ?";
            try (PreparedStatement assignStmt = conn.prepareStatement(assignQuery)) {
                assignStmt.setInt(1, instructorId);  // Assign the current instructor
                assignStmt.setInt(2, offeringId);
                int rowsAffected = assignStmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("You have successfully taken the offering!");
                } else {
                    System.out.println("Error: Unable to assign the offering.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: Unable to take the offering.");
            e.printStackTrace();
        }
    }

    // Placeholder for the getConnection method; replace with actual database connection code
    private static Connection getConnection() throws SQLException {
        // Example database connection URL, replace with actual credentials
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/LearningCenter", "root", "Moha514#");
    }
}
