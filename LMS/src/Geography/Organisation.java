package Geography;

import Services.Booking;
import Services.Lesson.Lesson;
import Services.Offering;
import TimeManagement.Schedule;
import UserManagment.Client;
import UserManagment.Instructor;
import UserManagment.User;

import java.util.ArrayList;

public class Organisation {
    private final String name;

    private ArrayList<Space> Spaces;

    private ArrayList<Instructor> instructors;
    private ArrayList<Offering> offerings;
    private ArrayList<User> users;
    private ArrayList<Client> clients;
    private ArrayList<Booking> Bookings;
    private ArrayList<Lesson> lessons;
    private ArrayList<Schedule> schedule;

    public Organisation(String name) {
        this.name = name;
        this.Spaces=new ArrayList<Space>();
        this.instructors = new ArrayList<Instructor>() ;
        this.offerings = new ArrayList<Offering>() ;
    }

    public String getName() {
        return name;
    }
    public ArrayList<Space> getLocations() {
        return Spaces;
    }
    public void addSpace(Space space) {
        Spaces.add(space);
    }

    public void setOfferings(ArrayList<Offering> offer){
        this.offerings=offer;
    }
    public void addOffering(Offering offer){
        this.offerings.add(offer);
    }
    public ArrayList<Offering> getOfferings() {
        return offerings;
    }

    public void setInstructors(ArrayList<Instructor> instructors) {
        this.instructors = instructors;
    }

    public ArrayList<Instructor> getInstructors() {
        return this.instructors;
    }

    public void setSpaces(ArrayList<Space> spaces) {
        Spaces = spaces;
    }

    public ArrayList<Space> getSpaces() {
        return Spaces;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void addUser(Client newClient) {
        this.users.add(newClient);
    }

    public ArrayList<Booking> getBookings() {
        return Bookings;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        Bookings = bookings;
    }

    public void setLessons(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
    }

    public void setSchedule(ArrayList<Schedule> schedule) {
        this.schedule = schedule;
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    public ArrayList<Schedule> getSchedule() {
        return schedule;
    }
}
