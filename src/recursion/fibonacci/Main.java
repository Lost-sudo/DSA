package recursion.fibonacci;

public class Main {

    public static void main(String[] args) {
        Main newMain = new Main();

        // Calculate the 4th Fibonacci number (F(4) = 3)
        int result = newMain.fibonacci(4);
        System.out.println(result); // Output: 3
    }

    /**
     * Recursive function to calculate the nth Fibonacci number.
     *
     * @param n The position in the Fibonacci sequence (0-based).
     * @return The nth Fibonacci number, or -1 if the input is invalid.
     */
    public int fibonacci(int n) {
        // Handle invalid input
        if (n < 0) {
            return -1;
        }

        // Base cases
        if (n == 0 || n == 1) {
            return n;
        }

        // Recursive case: F(n) = F(n-1) + F(n-2)
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
