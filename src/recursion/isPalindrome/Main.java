package recursion.isPalindrome;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Using a Scanner object to take user input
        try (Scanner newScan = new Scanner(System.in)) {
            System.out.println("Enter your word to check if it is a palindrome: ");
            String yourWord = newScan.nextLine(); // Read user input

            Main newMain = new Main();

            // Check if the input word is a palindrome
            boolean palindrome = newMain.isPalindrome(yourWord);

            // Print result
            if (palindrome) {
                System.out.println("Your word is a Palindrome.");
            } else {
                System.out.println("Your word is not a Palindrome.");
            }
        }
    }

    /**
     * Recursive function to check if a string is a palindrome.
     *
     * @param s The string to be checked.
     * @return true if the string is a palindrome, false otherwise.
     */
    public boolean isPalindrome(String s) {
        // Convert the string to lowercase for case-insensitive comparison
        s = s.toLowerCase();

        // Base case 1: If the string is empty or has one character, it is a palindrome
        if (s.isEmpty() || s.length() == 1) {
            return true;
        }

        // Base case 2: If the first and last characters are not the same, it is not a palindrome
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            // Recursive case: Remove the first and last characters and check the remaining substring
            return isPalindrome(s.substring(1, s.length() - 1));
        }

        // If the first and last characters are not the same, return false
        return false;
    }
}