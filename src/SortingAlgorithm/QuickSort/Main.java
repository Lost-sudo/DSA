package SortingAlgorithm.QuickSort;

public class Main {
    public static void main(String[] args) {
        int[] array = {10, 3, 2, 7, 7, 5, 8, 4, 1, 2, 9, 7, 8, 11};

        QuickSort.quickSort(array, 0, array.length-1);
        QuickSort.printArray(array);
    }
}

class QuickSort {

    static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[end];
        array[end] = temp;

        return i + 1; // Return the correct pivot index
    }

    public static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int pivot = partition(array, start, end);
            quickSort(array, start, pivot-1);
            quickSort(array, pivot+1, end);
        }
    }

    public static void printArray(int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }
    }
}
