package Menu;

import Data.Geography.OrganisationData;
import Geography.City;
import Services.Offering;
import UserManagment.Instructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InstructorMenu {
    public static void instructorMenu(Instructor instructor, Scanner scanner) {
        boolean isDone = false;
        while (!isDone) {
            System.out.println("\nInstructor Menu");
            System.out.println("1. View Available Cities");
            System.out.println("2. View Taken Offerings");
            System.out.println("3. Take New Offering");
            System.out.println("4. View Profile");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Viewing Available Cities...");
                    List<City> cities= instructor.getAvailable();
                    if(cities.isEmpty()){
                        System.out.println("No cities available");
                    }else {
                        for (City city : cities) {
                            System.out.println(city.getCityName());
                        }
                    }
                    break;
                case 2:
                    System.out.println("Viewing Taken Offerings...");
                    List<Offering> offerings = instructor.getTakenOfferings();
                    if(offerings.isEmpty()){
                        System.out.println("No offerings available");
                    }else{
                        for (Offering offering : offerings) {
                            System.out.println("Offering ID: " + offering.getOfferingId() +
                                    ", Lesson: " + offering.getLesson().getTypeOfLesson());
                        }
                    }
                    break;
                case 3:
                    System.out.println("Taking New Offering...");
                    takeNewOffering(instructor, scanner);
                    break;
                case 4:
                    System.out.println("Viewing Profile...");
                    System.out.println("Name: " + instructor.getUserName());
                    System.out.println("Specialisation: " + instructor.getSpecialisation());
                    System.out.println("Phone: " + instructor.getPhoneNumber());
                    break;
                case 5:
                    System.out.println("Logging out...");
                    isDone = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void takeNewOffering(Instructor instructor, Scanner scanner) {
        System.out.println("Available Offerings:");
        List<Offering> availableOfferings = getAvailableOfferings(instructor);

        if (availableOfferings.isEmpty()) {
            System.out.println("No available offerings match your cities and specialization.");
            return;
        }

        for (int i = 0; i < availableOfferings.size(); i++) {
            Offering offering = availableOfferings.get(i);
            System.out.println((i + 1) + ". Offering ID: " + offering.getOfferingId() +
                    ", Lesson: " + offering.getLesson().getTypeOfLesson() +
                    ", City: " + offering.getLocation().getCity().getCityName());
        }

        System.out.print("Enter the number of the offering you want to take (0 to cancel): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice > 0 && choice <= availableOfferings.size()) {
            Offering selectedOffering = availableOfferings.get(choice - 1);
            boolean success = instructor.takeOffering(selectedOffering);
            if (success) {
                System.out.println("You have successfully taken the offering.");
            } else {
                System.out.println("Unable to take the offering. Please try again.");
            }
        } else if (choice != 0) {
            System.out.println("Invalid selection. Please try again.");
        }
    }

    private static List<Offering> getAvailableOfferings(Instructor instructor) {
        List<Offering> availableOfferings = new ArrayList<>();
        List<Offering> allOfferings = OrganisationData.getOrganisation().getOfferings();

        for (Offering offering : allOfferings) {
            if (offering.getInstructor() == null &&
                    instructor.getAvailable().contains(offering.getLocation().getCity()) &&
                    instructor.getSpecialisation().equals(offering.getLesson().getTypeOfLesson())) {
                availableOfferings.add(offering);
            }
        }

        return availableOfferings;
    }


}
