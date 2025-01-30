package recursion.DecimalToBinary;

public class Main {

    public static void main(String[] args) {
        Main newMain = new Main();

        // Example: Convert 13 to binary
        System.out.println(newMain.decimalToBinary(13)); // Output: 1101
    }

    /**
     * Recursive function to convert a decimal number to its binary equivalent.
     *
     * @param n The decimal number to be converted.
     * @return The binary representation of the number as an integer.
     */
    public int decimalToBinary(int n) {
        // Base case: If the number is 0, return 0 (binary of 0 is 0).
        if (n == 0) {
            return 0;
        }

        // Recursive case:
        // Take the remainder when divided by 2 (least significant bit).
        // Multiply the result of the recursive call by 10 to shift left in binary.
        return n % 2 + 10 * decimalToBinary(n / 2);
    }
}
