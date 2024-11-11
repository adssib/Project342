//import UserManagment.*;
//
//import Menu.AdminMenu;
//import Menu.ClientMenu;
//import Menu.InstructorMenu;
//
//import java.util.Scanner;
//
///**
// * TO DO List of Features:
// *  1. Log out for all users
// *  for admin:
// *      1. View Users DONE
// *      2. View bookings, write a toString() method to be used in the menu
// *      3. View Offerings, write a toString() method to be used in the menu
// *      4. Delete User DONE
// *  for instructors:
// *      1. View Account DONE
// *      2. View Taken Offerings DONE
// *      3. take New Offerings DONE
// *      4. View Profile DONE
// *      5. Manage Available cities DONE
// *  for Clients:
// *      1. View Made Bookings DONE
// *      2. View Public Offerings DONE
// *      3. Make a booking DONE
// *      4. Make a booking for a child DONE
// *      5. Manage Children list (add, delete) DONE
// *      6. Cancel booking DONE
// * Things to take care off:
// *      for admin when creating offering make sure it is unique
// *      for instructor, taking an offering means it should be in one of his available Cities DONE
// *      for client no booking on the same date nor same time for 2 things is allowed
// */
//
//public class Menu {
//    private static Scanner scanner = new Scanner(System.in);
//
//    public static void generateMenu(User user) {
//        switch (user) {
//            case Admin admin -> AdminMenu.adminMenu(admin, scanner);
//            case Instructor instructor -> InstructorMenu.instructorMenu(instructor, scanner);
//            case Client client -> ClientMenu.clientMenu(client, scanner);
//            case null, default -> System.out.println("Unknown user type");
//        }
//    }
//
//
//}