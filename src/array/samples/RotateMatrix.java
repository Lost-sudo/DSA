package array.samples;

import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateMatrix(arr);
        System.out.println(Arrays.deepToString(arr)); // Print the rotated matrix
    }

    /**
     * Rotates a square matrix 90 degrees clockwise in place.
     * @param matrix The square matrix to rotate.
     */
    public static void rotateMatrix(int[][] matrix) {
        // Ensure the matrix is non-empty and square (n x n)
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return; // Exit if the input is invalid
        }

        int n = matrix.length; // Get the size of the matrix

        // Process the matrix layer by layer
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer; // The first index of the current layer
            int last = n - 1 - layer; // The last index of the current layer

            // Iterate through elements in the current layer
            for (int i = first; i < last; i++) {
                int offset = i - first; // Offset within the layer

                // Save the top element (will be overwritten)
                int top = matrix[first][i];

                // Move the left element to the top
                matrix[first][i] = matrix[last - offset][first];

                // Move the bottom element to the left
                matrix[last - offset][first] = matrix[last][last - offset];

                // Move the right element to the bottom
                matrix[last][last - offset] = matrix[i][last];

                // Assign the saved top element to the right
                matrix[i][last] = top;
            }
        }
    }
}
