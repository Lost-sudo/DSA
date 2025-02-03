package SortingAlgorithm.MergeSort;

import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        int[] array = {10, 3, 2, 5, 8, 4, 3, 1, 2, 9, 7, 8};
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array)); // Print sorted array
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    private static void merge(int[] array, int left, int middle, int right) {
        int leftSize = middle - left + 1;
        int rightSize = right - middle;

        int[] leftArray = Arrays.copyOfRange(array, left, middle + 1);
        int[] rightArray = Arrays.copyOfRange(array, middle + 1, right + 1);

        int i = 0, j = 0, k = left;

        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < leftSize) {
            array[k++] = leftArray[i++];
        }

        while (j < rightSize) {
            array[k++] = rightArray[j++];
        }
    }
}
