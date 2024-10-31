package Data.UserManagement;

import Geography.City;
import UserManagment.Instructor;

import java.util.ArrayList;

public class InstructorDataGenerator {
    public static ArrayList<Instructor> generateInstructors(ArrayList<City> cities) {
        ArrayList<Instructor> instructors = new ArrayList<>();

        Instructor instructor1 = new Instructor(1, "John", "John", "1234567890", "Swimming");
        Instructor instructor2 = new Instructor(2, "Smith", "Smith", "0987654321", "Yoga");
        Instructor instructor3 = new Instructor(3, "Bob", "Bob", "1122334455", "Fitness");

        instructor1.setAvailable(cities);
        instructor2.setAvailable(cities);
        instructor3.setAvailable(cities);

        instructors.add(instructor1);
        instructors.add(instructor2);
        instructors.add(instructor3);


        return instructors;
    }
}
