package Data.Geography;

import Data.Services.*;
import Data.TimeManagement.ScheduleDataGenerator;
import Data.UserManagement.ClientDataGenerator;
import Data.UserManagement.InstructorDataGenerator;
import Geography.*;
import Services.Booking;
import Services.Offering;
import Services.Lesson.*;
import UserManagment.Child;
import UserManagment.User;
import UserManagment.Client;
import UserManagment.Instructor;
import TimeManagement.Schedule;

import java.util.ArrayList;

public class OrganisationData {
    private static Organisation org;

    private OrganisationData() {
        // Private constructor to prevent instantiation
    }

    public static void generateOrganisationData() {
        org = new Organisation("Learning Center");

        ArrayList<City> cities = CityDataGenerator.generateCities();
        ArrayList<Location> locations = LocationDataGenerator.generateLocations(cities);
        ArrayList<Space> spaces = SpaceDataGenerator.generateSpaces(locations);
        ArrayList<Instructor> instructors = InstructorDataGenerator.generateInstructors(cities);
        ArrayList<Client> clients = ClientDataGenerator.generateClients();
        ArrayList<Child> children = ClientDataGenerator.generateChildren(clients);
        ArrayList<Lesson> lessons = LessonDataGenerator.generateLessons();
        ArrayList<Schedule> schedules = ScheduleDataGenerator.generateSchedules();

        // Assign lessons to locations
        for (Location location : locations) {
            for (Lesson lesson : lessons) {
                location.addLesson(lesson);
            }
        }

        ArrayList<Offering> offerings = OfferingDataGenerator.generateOfferings(spaces, instructors);
        ArrayList<Booking> bookings = BookingDataGenerator.generateBookings(offerings, clients, children);

        ArrayList<User> userList = new ArrayList<User>();
        userList.addAll(instructors);
        userList.addAll(clients);

        org.setSpaces(spaces);
        org.setInstructors(instructors);
        org.setOfferings(offerings);
        org.setClients(clients);
        org.setUsers(userList);
        org.setBookings(bookings);
        org.setLessons(lessons);
        org.setSchedule(schedules);
    }

    public static Organisation getOrganisation() {
        if (org == null) {
            generateOrganisationData();
        }
        return org;
    }
}