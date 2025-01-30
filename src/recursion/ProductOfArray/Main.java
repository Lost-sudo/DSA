package recursion.ProductOfArray;

public class Main {
    public static void main(String[] args) {
        Main newMain = new Main();

        // Define an array of integers
        int[] myArray = {1, 2, 3, 4, 5};

        // Get the length of the array
        int arrayLength = myArray.length;

        // Call the recursive method and print the result
        System.out.println(newMain.productOfArray(myArray, arrayLength)); // Output: 120 (1 * 2 * 3 * 4 * 5)
    }

    /**
     * Recursive method to calculate the product of all elements in an array.
     *
     * @param A The array of integers.
     * @param N The number of elements to consider from the array (initially the
     * length of the array).
     * @return The product of all elements in the array up to index N-1.
     */
    public int productOfArray(int[] A, int N) {
        // Base case: If N is 0 or less, return 1 (multiplicative identity)
        if (N <= 0) {
            return 1;
        }

        // Recursive case: Multiply the last element of the current subarray (A[N-1]) with the product of the rest of the array
        return productOfArray(A, N - 1) * A[N - 1];
    }
}
