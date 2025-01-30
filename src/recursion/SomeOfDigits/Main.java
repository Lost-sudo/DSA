package recursion.SomeOfDigits;

public class Main {
    public static void main(String[] args) {
        Main newMain = new Main();

        // Testing the sumOfDigits method
        System.out.println(newMain.sumOfDigits(-10)); // Output: 0 (negative input)
        System.out.println(newMain.sumOfDigits(1234)); // Output: 10 (1 + 2 + 3 + 4)
        System.out.println(newMain.sumOfDigits(0)); // Output: 0 (base case)
        System.out.println(newMain.sumOfDigits(567)); // Output: 18 (5 + 6 + 7)
    }

    /**
     * A recursive method to calculate the sum of the digits of a number.
     *
     * @param n The number whose digits are to be summed.
     * @return The sum of the digits of n, or 0 for negative numbers or 0 input.
     */
    public int sumOfDigits(int n) {
        // If the number is 0 or negative, return 0 (base case and input validation)
        if (n == 0 || n < 0) {
            return 0;
        }

        // Recursive case: Add the last digit (n % 10) to the result of the remaining number (n / 10)
        return n % 10 + sumOfDigits(n / 10);
    }
}
