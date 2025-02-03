package SortingAlgorithm.InsertionSort;

public class Main {
    public static void main(String[] args) {
        InsertionSort newInsertionSort = new InsertionSort();
        int[] array = {10, 3, 2, 5, 8, 4, 3, 1};
        newInsertionSort.printArray(array);
        System.out.println();
        newInsertionSort.insertionSort(array);
        newInsertionSort.printArray(array);
    }
}

class InsertionSort {
    public void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i], j = i;
            while (j > 0 && array[j-1] > temp) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }

    public void printArray(int[] array) {
        for (int data : array) {
            System.out.print(data + " ");
        }
    }
}
