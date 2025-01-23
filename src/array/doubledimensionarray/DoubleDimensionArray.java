package array.doubledimensionarray;

public class DoubleDimensionArray {

    int[][] arr;

    public DoubleDimensionArray(int numberOfRows, int numberOfColumns) {
        this.arr = new int[numberOfRows][numberOfColumns];
        for (int[] row : arr) {
            for (int col = 0; col < arr[0].length; col++) {
                row[col] = 0;
            }
        }
    }

    public void insertValueInTheArray(int row, int col, int value) {
        try {
            if (arr[row][col] == 0) {
                arr[row][col] = value;
                System.out.println("The value is successfully inserted");
            } else {
                System.out.println("This cell is already occupied.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index for 2D array.");
        }
    }

    public void accessCell(int row, int col) {
        System.out.println("Accessing Row: " + row + ", Col: " + col);
        try {
            System.out.println("Cell value is: " + arr[row][col]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index for 2D array.");
        }
    }

    public void traverse2DArray() {
        for (int[] row : arr) {
            for (int col = 0; col < arr[0].length; col++) {
                System.out.println(row[col] + " ");
            }
            System.out.println();
        }
    }

    public void searchValueIn2DArray(int valueToSearch) {
        try {
            for (int row = 0; row < arr.length; row++) {
                for (int col = 0; col < arr[0].length; col++) {
                    if (arr[row][col] == valueToSearch) {
                        System.out.println("Value was found at index: " + row + " " + col);
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Data don't exist in 2D array.");
        }
    }

    public void deleteValue2DArray(int valueToDelete) {
        for (int[] row : arr) {
            for (int col = 0; col < arr[0].length; col++) {
                if (row[col] == valueToDelete) {
                    row[col] = 0;
                    System.out.println("Value is deleted successfully.");
                }
            }
        }
    }
}
