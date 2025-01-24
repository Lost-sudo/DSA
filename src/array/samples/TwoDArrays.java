package array.samples;

public class TwoDArrays {
    public static void main(String[] args) {
        // Define a 3x3 2D array
        int[][] my2DArray = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        // Call the method to calculate the sum of diagonal elements
        int sum = sumDiagonalElements(my2DArray);

        // Print the calculated sum of diagonal elements
        System.out.println(sum); // Expected output: 15
    }

    /**
     * This method calculates the sum of the diagonal elements of a square matrix.
     * A diagonal element is one where the row index equals the column index.
     *
     * @param array The 2D array (square matrix) to process.
     * @return The sum of diagonal elements.
     */
    public static int sumDiagonalElements(int[][] array) {
        int sum = 0; // Initialize sum to 0

        // Loop through each row (and column, since it's square)
        for (int i = 0; i < array.length; i++) {
            // Add the element where row index equals column index
            sum += array[i][i];
        }

        // Return the total sum of diagonal elements
        return sum;
    }
}
