package SortingAlgorithm.BubbleSort;

public class Main {
    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();
        int[] arr = {10, 5, 30, 15, 50, 6};
        bs.bubbleSort(arr);
        bs.printArray(arr);
    }
}

class BubbleSort {
    void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    void printArray(int[] arr) {
        int n = arr.length;
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
