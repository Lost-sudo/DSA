package recursion.Power;

public class Main {
    public static void main(String[] args) {
        Main newMain = new Main();

        // Compute 2 raised to the power of 4 and print the result
        System.out.println(newMain.power(2, 4)); // Output: 16
    }

    /**
     * Recursive method to calculate the power of a number.
     *
     * @param base The base number.
     * @param exp The exponent (power to which the base is raised).
     * @return The result of base^exp, or -1 if exp is negative.
     */
    public int power(int base, int exp) {
        // Base case 1: Any number raised to the power of 0 is 1
        if (exp == 0) {
            return 1;
        }

        // Base case 2: Return -1 for negative exponents (not handled in this implementation)
        if (exp < 0) {
            return -1;
        }

        // Recursive case: Multiply the base by the result of power(base, exp - 1)
        return base * power(base, exp - 1);
    }
}
