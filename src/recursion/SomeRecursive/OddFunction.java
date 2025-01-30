package recursion.SomeRecursive;

public class OddFunction {
        /**
         * Checks if the given number is odd.
         *
         * @param num The number to check.
         * @return true if the number is odd, false if it is even.
         */
        boolean run(int num) {
            // A number is odd if it is not divisible by 2.
            if (num % 2 == 0) {
                return false; // Even number
            } else {
                return true;  // Odd number
            }
        }

}
