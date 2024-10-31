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
    public static Organisation generateOrganisationData() {
        Organisation org = new Organisation("Learning Center");

        ArrayList<City> cities = CityDataGenerator.generateCities();

        ArrayList<Schedule> schedules = ScheduleDataGenerator.generateSchedules();
        ArrayList<Location> locations = LocationDataGenerator.generateLocations(cities);
        ArrayList<Space> spaces = SpaceDataGenerator.generateSpaces(locations);
        ArrayList<Lesson> lessons = LessonDataGenerator.generateLessons();
        ArrayList<Instructor> instructors = InstructorDataGenerator.generateInstructors();
        ArrayList<Offering> offerings = OfferingDataGenerator.generateOfferings(spaces, instructors);
        ArrayList<Client> clients = ClientDataGenerator.generateClients();
        ArrayList<Child> children = ClientDataGenerator.generateChildren(clients);
        ArrayList<Booking> bookings = BookingDataGenerator.generateBookings(offerings, clients, children);

        ArrayList<User> UserList = new ArrayList<User>() ;

        // Add all instructors to the userList
        UserList.addAll(instructors);

        // Add all clients to the userList
        UserList.addAll(clients);

        org.setSpaces(spaces);
        org.setInstructors(instructors);
        org.setOfferings(offerings);

        return org;
    }
}