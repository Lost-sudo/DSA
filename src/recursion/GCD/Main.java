package recursion.GCD;

public class Main {
    public static void main(String[] args) {
        Main newMain = new Main();

        // Example: Find the GCD of 8 and 4
        System.out.println(newMain.GCD(8, 4)); // Output: 4
    }

    /**
     * Recursive function to calculate the Greatest Common Divisor (GCD) using
     * the Euclidean Algorithm.
     *
     * @param a The first integer.
     * @param b The second integer.
     * @return The GCD of the two integers. Returns -1 for invalid input
     * (negative integers).
     */
    public int GCD(int a, int b) {
        // Handle invalid input: GCD is undefined for negative numbers
        if (a < 0 || b < 0) {
            return -1;
        }

        // Base case: If b is 0, the GCD is a
        if (b == 0) {
            return a;
        }

        // Recursive case: Call GCD with b and the remainder of a divided by b
        return GCD(b, a % b);
    }
}
