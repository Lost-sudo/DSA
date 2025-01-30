package recursion.RecursiveRange;

public class Main {
    public static void main(String[] args) {
        Main newMain = new Main();

        // Testing the recursiveRange method
        System.out.println(newMain.recursiveRange(6)); // Output: 21 (1 + 2 + 3 + 4 + 5 + 6)
        System.out.println(newMain.recursiveRange(10)); // Output: 55 (1 + 2 + ... + 10)
        System.out.println(newMain.recursiveRange(1)); // Output: 1 (only 1 number)
        System.out.println(newMain.recursiveRange(0)); // Output: 1 (edge case, as per the logic)
    }

    /**
     * A recursive method to calculate the sum of all numbers from 1 to num.
     *
     * @param num The upper bound of the range to sum.
     * @return The sum of all integers from 1 to num.
     */
    public int recursiveRange(int num) {
        // Base case: If num is 1 or less, return 1
        if (num <= 1) {
            return 1;
        }

        // Recursive case: Add num to the sum of all numbers from 1 to (num - 1)
        return num + recursiveRange(num - 1);
    }
}
