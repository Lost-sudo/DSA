package recursion.factorial;

public class Main {
    public static void main(String[] args) {
        // Create an instance of the Main class
        Main r = new Main();

        // Call the factorial method with the number 4
        int result = r.factorial(4);

        // Print the result (Expected output: 24)
        System.out.println(result);
    }

    /**
     * Recursive function to calculate the factorial of a number.
     *
     * @param n The number whose factorial is to be calculated.
     * @return The factorial of n, or -1 if the input is invalid.
     */
    public int factorial(int n) {
        // Check for invalid input (negative numbers)
        if (n < 1) {
            return -1;
        }

        // Base case: factorial of 0 or 1 is 1
        if (n == 0 || n == 1) {
            return 1;
        }

        // Recursive case: n! = n * (n-1)!
        return n * factorial(n - 1);
    }
}
