package SortingAlgorithm.MergeSort;

public class Main {
    public static void main(String[] args) {
        int[] array = {10, 3, 2, 5, 8, 4, 3, 1, 2, 9, 7, 8};
        MergeSort.mergeSort(array, 0, array.length - 1);
        MergeSort.printArray(array);
    }
}

class MergeSort {

    static void merge(int[] array, int left, int middle, int right) {
        int leftSize = middle - left + 1;
        int rightSize = right - middle;

        int[] leftTempArray = new int[leftSize + 1];
        int[] rightTempArray = new int[rightSize + 1];

        // Copy data to temp arrays
        for (int i = 0; i < leftSize; i++) {
            leftTempArray[i] = array[left + i];
        }
        for (int i = 0; i < rightSize; i++) {
            rightTempArray[i] = array[middle + 1 + i];
        }

        // Set sentinel values (Infinity)
        leftTempArray[leftSize] = Integer.MAX_VALUE;
        rightTempArray[rightSize] = Integer.MAX_VALUE;

        int i = 0, j = 0;
        for (int k = left; k <= right; k++) {  // Fix boundary condition
            if (leftTempArray[i] <= rightTempArray[j]) {
                array[k] = leftTempArray[i];
                i++;
            } else {
                array[k] = rightTempArray[j];
                j++;  // Missing increment added here
            }
        }
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {  // Fix condition (should be left < right)
            int middle = left + (right - left) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    public static void printArray(int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
