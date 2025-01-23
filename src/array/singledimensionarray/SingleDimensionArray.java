package array.singledimensionarray;

import java.util.Arrays;

public class SingleDimensionArray {
    int[] arr;

    public SingleDimensionArray(int sizeOfArray) {
        arr = new int[sizeOfArray];

        Arrays.fill(arr, Integer.MIN_VALUE);
    }

    public void insert(int location, int valueToBeInserted) {
        try {
            if (arr[location] == Integer.MIN_VALUE) {
                arr[location] = valueToBeInserted;
                System.out.println("Successfully Inserted.");
            } else {
                System.out.println("This cell is already occupied");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index to access array!");
        }
    }

    public void traverseArray() {
        try {
            System.out.println("Array Traversal: ");
            for (int j : arr) {
                System.out.print(j + " ");
            }
        } catch (Exception e) {
            System.out.println("Array no longer exist");
        }
        System.out.println();
    }

    public void searchInArray(int valueToSearch) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == valueToSearch) {
                System.out.println("Value is found at the index of " + i);
                return;
            }
        }
        System.out.println(valueToSearch + " is not found.");
    }

    public void deleteValue(int valueToBeDeleted) {
        try {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == valueToBeDeleted) {
                    arr[i] = Integer.MIN_VALUE;
                    System.out.println("The value has been deleted successfully.");
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The value that is provided is not in range of Array");
        }
    }
}
