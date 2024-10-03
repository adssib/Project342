package Utilities;

import java.util.regex.Pattern;

/**
 * This class will be used to validate different inputs provided by different users
 * i.e. a function that will validate if the user entered the correct format of a Phone Number or not
 * Another function can be used to not allow the same user register for 2 offering on the same date and time
 * */

public class Validator {
    public static boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "^[0-9]{3} [0-9]{4} [0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);

        return pattern.matcher(phoneNumber).matches();
    }
}
