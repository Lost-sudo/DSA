package SortingAlgorithm.SelectionSort;

public class Main {
    public static void main(String[] args) {
        SelectionSort newSelectionSort = new SelectionSort();
        int[] array = {10, 3, 2, 5, 8, 4, 1, 9};
        newSelectionSort.printArray(array);
        System.out.println();
        newSelectionSort.selectionSort(array);
        newSelectionSort.printArray(array);
    }
}

class SelectionSort {
    public void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int minimumIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minimumIndex]) {
                    minimumIndex = j;
                }
            }
            if (minimumIndex != i) {
                int temp = array[i];
                array[i] = array[minimumIndex];
                array[minimumIndex] = temp;
                }
            }
        }

    public void printArray(int[] array) {
        for (int data : array) {
            System.out.print(data + " ");
        }
    }
}



