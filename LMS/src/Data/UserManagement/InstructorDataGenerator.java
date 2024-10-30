package Data.UserManagement;

import UserManagment.Instructor;

import java.util.ArrayList;

public class InstructorDataGenerator {
    public static ArrayList<Instructor> generateInstructors() {
        ArrayList<Instructor> instructors = new ArrayList<>();
        instructors.add(new Instructor(1, "John Doe", "password123", "1234567890", "Swimming"));
        instructors.add(new Instructor(2, "Jane Smith", "password456", "0987654321", "Yoga"));
        instructors.add(new Instructor(3, "Bob Johnson", "password789", "1122334455", "Fitness"));
        return instructors;
    }
}

