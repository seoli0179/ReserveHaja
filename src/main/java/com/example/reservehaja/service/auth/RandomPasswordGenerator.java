package com.example.reservehaja.service.auth;

import org.springframework.context.annotation.Bean;

import java.util.Random;

public class RandomPasswordGenerator {

    private static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMERIC_CHARS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+[]{}|;:'\",.<>/?";

    public static String generateRandomPassword() {
        int length = generateRandomLength();
        String allChars = LOWERCASE_CHARS + UPPERCASE_CHARS + NUMERIC_CHARS + SPECIAL_CHARS;

        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allChars.length());
            password.append(allChars.charAt(randomIndex));
        }

        return password.toString();
    }

    private static int generateRandomLength() {
        // Generate a random number between 8 and 12 (inclusive)
        return new Random().nextInt(5) + 8;
    }

    public static void main(String[] args) {
        String generatedPassword = generateRandomPassword();
        System.out.println("Generated Password: " + generatedPassword);
    }

}
