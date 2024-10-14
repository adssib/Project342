import Utilities.Validator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the user you want to login: ");
        String username = sc.nextLine();
        System.out.println("Enter the password of the user you want to login: ");
        String password = sc.nextLine();

        try {
            String role = Validator.ValidateLogIn(username, password);
            if (role != null) {
                System.out.println("Login successful! Welcome " + role);
            } else {
                System.out.println("Invalid username or password.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        sc.close();

    }
}