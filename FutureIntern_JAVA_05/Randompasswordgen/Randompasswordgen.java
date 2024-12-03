package Randompasswordgen;

import java.util.Random;

public class Randompasswordgen {
    private static final String CHAR_LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER_CASE = CHAR_LOWER_CASE.toUpperCase();
    private static final String NUMBER = "0123456789";
    private static final String SPECIAL_CHAR = "!@#$%^&*()_-+=<>?";

    public static String generatePassword(int length) {
        String chars = CHAR_LOWER_CASE + CHAR_UPPER_CASE + NUMBER + SPECIAL_CHAR;
        StringBuilder password = new StringBuilder();
        Random rnd = new Random();

        while (password.length() < length) {
            int index = (int) (rnd.nextFloat() * chars.length());
            password.append(chars.charAt(index));
        }

        return password.toString();
    }

    public static void main(String[] args) {
        int passwordLength = 12; // Adjust the password length as needed
        String password = generatePassword(passwordLength);
        System.out.println("Generated Password: " + password);
    }
}