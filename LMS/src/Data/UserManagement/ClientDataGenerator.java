package Data.UserManagement;

import UserManagment.Child;
import UserManagment.Client;

import java.util.ArrayList;

public class ClientDataGenerator {
    public static ArrayList<Client> generateClients() {
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client(1, "John Doe", "password123", "123-456-7890"));
        clients.add(new Client(2, "Jane Smith", "password456", "987-654-3210"));
        // Add more clients as needed
        return clients;
    }

    public static ArrayList<Child> generateChildren(ArrayList<Client> adults) {
        ArrayList<Child> children = new ArrayList<>();
        children.add(new Child(adults.get(0))); // Assuming the first adult is the parent
        children.add(new Child(adults.get(1))); // Assuming the second adult is the parent
        // Add more children as needed
        return children;
    }
}