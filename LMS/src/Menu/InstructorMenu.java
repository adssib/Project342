//package Menu;
//
//import Data.Geography.CityDataGenerator;
//import Data.Geography.OrganisationData;
//import Geography.City;
//import Services.Offering;
//import UserManagment.Instructor;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class InstructorMenu {
//    public static void instructorMenu(Instructor instructor, Scanner scanner) {
//        boolean isDone = false;
//        while (!isDone) {
//            System.out.println("\nInstructor Menu");
//            System.out.println("1. View Available Cities");
//            System.out.println("2. View Taken Offerings");
//            System.out.println("3. Take New Offering");
//            System.out.println("4. View Profile");
//            System.out.println("5. Add Available Cities");
//            System.out.println("6. Logout");
//            System.out.print("Choose an option: ");
//
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // Consume newline
//
//            switch (choice) {
//                case 1:
//                    System.out.println("Viewing Available Cities...");
//                    List<City> cities= instructor.getAvailable();
//                    if(cities.isEmpty()){
//                        System.out.println("No cities available");
//                    }else {
//                        for (City city : cities) {
//                            System.out.println(city.getCityName());
//                        }
//                    }
//                    break;
//                case 2:
//                    System.out.println("Viewing Taken Offerings...");
//                    List<Offering> offerings = instructor.getTakenOfferings();
//                    if(offerings.isEmpty()){
//                        System.out.println("No offerings available");
//                    }else{
//                        for (Offering offering : offerings) {
//                            System.out.println("Offering ID: " + offering.getOfferingId() +
//                                    ", Lesson: " + offering.getLesson().getTypeOfLesson());
//                        }
//                    }
//                    break;
//                case 3:
//                    System.out.println("Taking New Offering...");
//                    takeNewOffering(instructor, scanner);
//                    break;
//                case 4:
//                    System.out.println("Viewing Profile...");
//                    System.out.println("Name: " + instructor.getUserName());
//                    System.out.println("Specialisation: " + instructor.getSpecialisation());
//                    System.out.println("Phone: " + instructor.getPhoneNumber());
//                    break;
//                case 5:
//                    System.out.println("Adding Available Cities...");
//                    ManageAvailableCities(instructor, scanner);
//                case 6:
//                    System.out.println("Logging out...");
//                    isDone = true;
//                    break;
//                default:
//                    System.out.println("Invalid option. Please try again.");
//            }
//        }
//    }
//
//    private static void ManageAvailableCities(Instructor instructor, Scanner scanner) {
//        boolean isDone = false;
//        while (!isDone) {
//            List<City> availableCities = instructor.getAvailable();
//            System.out.println("\nManage Available Cities");
//            System.out.println("1. View Available Cities");
//            System.out.println("2. Add City");
//            System.out.println("3. Remove City");
//            System.out.println("4. Back to Instructor Menu");
//            System.out.print("Choose an option: ");
//
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // Consume newline
//
//            switch (choice) {
//                case 1:
//                    viewAvailableCities(availableCities);
//                    break;
//                case 2:
//                    addCity(instructor, scanner);
//                    break;
//                case 3:
//                    removeCity(instructor, scanner);
//                    break;
//                case 4:
//                    isDone = true;
//                    break;
//                default:
//                    System.out.println("Invalid option. Please try again.");
//            }
//        }
//    }
//
//    private static void viewAvailableCities(List<City> cities) {
//        if (cities.isEmpty()) {
//            System.out.println("You have no available cities.");
//        } else {
//            System.out.println("Your Available Cities:");
//            for (int i = 0; i < cities.size(); i++) {
//                System.out.println((i + 1) + ". " + cities.get(i).getCityName());
//            }
//        }
//    }
//
//    private static void addCity(Instructor instructor, Scanner scanner) {
//        List<City> allCities = CityDataGenerator.generateCities();
//        List<City> availableCities = instructor.getAvailable();
//
//        System.out.println("Cities you can add:");
//        List<City> addableCities = new ArrayList<>();
//        for (City city : allCities) {
//            if (!availableCities.contains(city)) {
//                addableCities.add(city);
//                System.out.println((addableCities.size()) + ". " + city.getCityName());
//            }
//        }
//
//        if (addableCities.isEmpty()) {
//            System.out.println("There are no more cities you can add.");
//            return;
//        }
//
//        System.out.print("Enter the number of the city you want to add (0 to cancel): ");
//        int choice = scanner.nextInt();
//        scanner.nextLine(); // Consume newline
//
//        if (choice > 0 && choice <= addableCities.size()) {
//            City selectedCity = addableCities.get(choice - 1);
//            instructor.addCity(selectedCity);
//            System.out.println("Added " + selectedCity.getCityName() + " to your available cities.");
//        } else if (choice != 0) {
//            System.out.println("Invalid selection. Please try again.");
//        }
//    }
//
//    private static void removeCity(Instructor instructor, Scanner scanner) {
//        List<City> availableCities = instructor.getAvailable();
//
//        if (availableCities.isEmpty()) {
//            System.out.println("You have no cities to remove.");
//            return;
//        }
//
//        System.out.println("Your available cities:");
//        for (int i = 0; i < availableCities.size(); i++) {
//            System.out.println((i + 1) + ". " + availableCities.get(i).getCityName());
//        }
//
//        System.out.print("Enter the number of the city you want to remove (0 to cancel): ");
//        int choice = scanner.nextInt();
//        scanner.nextLine(); // Consume newline
//
//        if (choice > 0 && choice <= availableCities.size()) {
//            City selectedCity = availableCities.get(choice - 1);
//            availableCities.remove(selectedCity);
//            System.out.println("Removed " + selectedCity.getCityName() + " from your available cities.");
//        } else if (choice != 0) {
//            System.out.println("Invalid selection. Please try again.");
//        }
//    }
//
//    private static void takeNewOffering(Instructor instructor, Scanner scanner) {
//        System.out.println("Available Offerings:");
//        List<Offering> availableOfferings = getAvailableOfferings(instructor);
//
//        if (availableOfferings.isEmpty()) {
//            System.out.println("No available offerings match your cities and specialization.");
//            return;
//        }
//
//        for (int i = 0; i < availableOfferings.size(); i++) {
//            Offering offering = availableOfferings.get(i);
//            System.out.println((i + 1) + ". Offering ID: " + offering.getOfferingId() +
//                    ", Lesson: " + offering.getLesson().getTypeOfLesson() +
//                    ", City: " + offering.getLocation().getCity().getCityName());
//        }
//
//        System.out.print("Enter the number of the offering you want to take (0 to cancel): ");
//        int choice = scanner.nextInt();
//        scanner.nextLine(); // Consume newline
//
//        if (choice > 0 && choice <= availableOfferings.size()) {
//            Offering selectedOffering = availableOfferings.get(choice - 1);
//
//            // Check if the offering's city is in the instructor's available cities
//            if (instructor.getAvailable().contains(selectedOffering.getLocation().getCity())) {
//                boolean success = instructor.takeOffering(selectedOffering);
//                if (success) {
//                    selectedOffering.setAvailable(true);  // Update the isAvailable status
//                    System.out.println("You have successfully taken the offering.");
//                } else {
//                    System.out.println("Unable to take the offering. Please try again.");
//                }
//            } else {
//                System.out.println("This offering is not in one of your available cities. You cannot take it.");
//            }
//        } else if (choice != 0) {
//            System.out.println("Invalid selection. Please try again.");
//        }
//    }
//
//    private static List<Offering> getAvailableOfferings(Instructor instructor) {
//        List<Offering> availableOfferings = new ArrayList<>();
//        List<Offering> allOfferings = OrganisationData.getOrganisation().getOfferings();
//
//        for (Offering offering : allOfferings) {
//            if (offering.getInstructor() == null &&
//                    instructor.getAvailable().contains(offering.getLocation().getCity()) &&
//                    instructor.getSpecialisation().equals(offering.getLesson().getTypeOfLesson()) &&
//                    !offering.isAvailable()) {  // Check if the offering is not already taken
//                availableOfferings.add(offering);
//            }
//        }
//
//        return availableOfferings;
//    }
//
//
//}
