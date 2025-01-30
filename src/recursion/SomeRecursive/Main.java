package recursion.SomeRecursive;

import java.util.Arrays;

public class Main {
    /**
     * Checks if at least one element in the array satisfies the condition
     * defined in OddFunction.
     *
     * @param arr The integer array to check.
     * @param odd An instance of OddFunction, which defines the condition to
     * check.
     * @return true if at least one element satisfies the condition, false
     * otherwise.
     */
    public boolean someRecursive(int[] arr, OddFunction odd) {
        // Base case: If the array is empty, no element satisfies the condition.
        if (arr.length == 0) {
            return false;
        }

        // Check if the first element satisfies the condition using OddFunction.
        if (odd.run(arr[0]) == false) {
            // If not, call the method recursively with the rest of the array.
            return someRecursive(Arrays.copyOfRange(arr, 1, arr.length), odd);
        } else {
            // If the condition is satisfied, return true.
            return true;
        }
    }

    public static void main(String[] args) {
        Main newMain = new Main();

        // Define an array to test.
        int[] myArray = {1, 2, 3, 4, 5};

        // Create an instance of OddFunction.
        OddFunction odd = new OddFunction();

        // Call the someRecursive method and print the result.
        boolean result = newMain.someRecursive(myArray, odd);
        System.out.println("Does the array contain an odd number? " + result);
    }
}
