package Utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * This class will be used to validate different inputs provided by different users
 * i.e. a function that will validate if the user entered the correct format of a Phone Number or not
 * Another function can be used to not allow the same user register for 2 offering on the same date and time
 * */

public class Validator {

    public static String UsersCataloguePath = "Data/Users.txt";

    public static boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "^[0-9]{3} [0-9]{4} [0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);

        return pattern.matcher(phoneNumber).matches();
    }

    public static String ValidateLogIn(String username, String password) throws IOException {
        Scanner scanner = new Scanner(new FileReader(UsersCataloguePath));

        while (scanner.hasNextLine()) {
            String st = scanner.nextLine().trim();

            String role = VerifyLogin(st, username.trim(), password.trim());
            if (role != null) {
                scanner.close();
                return role;
            }
        }
        scanner.close();
        return null;
    }


    private static String VerifyLogin(String st, String username, String password) {
        String[] values = st.split(",");

        String fileUsername = values[1].trim();
        String filePassword = values[2].trim();
        String userRole = values[4].trim();

        return fileUsername.equals(username) && filePassword.equals(password) ? userRole : null;
    }

}
