import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/LearningCenter"; // Update with your MySQL host and database name
    private static final String USER = "root"; // Replace with your MySQL username
    private static final String PASSWORD = "Moha514#"; // Replace with your MySQL password

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error: Unable to connect to the database.");
            e.printStackTrace();
            return null;
        }
    }
}
