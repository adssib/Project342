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
        ArrayList<Instructor> instructors = InstructorDataGenerator.generateInstructors();
        ArrayList<Offering> offerings = OfferingDataGenerator.generateOfferings(spaces, instructors);
        ArrayList<Client> clients = ClientDataGenerator.generateClients();

        ArrayList<User> userList = new ArrayList<User>();
        userList.addAll(instructors);
        userList.addAll(clients);

        org.setSpaces(spaces);
        org.setInstructors(instructors);
        org.setOfferings(offerings);

        // You might want to set clients and userList to org as well if needed
         org.setClients(clients);
         org.setUsers(userList);
    }

    public static Organisation getOrganisation() {
        if (org == null) {
            generateOrganisationData();
        }
        return org;
    }
}