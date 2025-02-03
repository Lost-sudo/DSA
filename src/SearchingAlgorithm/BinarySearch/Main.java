package SearchingAlgorithm.BinarySearch;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Searching.binarySearch(array, 7);
    }
}

class Searching {
    public static void binarySearch(int[] array, int value) {
        int start = 0;
        int end = array.length - 1;
        int middle = (start+end) / 2;
        while(array[middle] != value && start <= end) {
            if (value < array[middle]) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
            middle = (start+end) / 2;
        }
        if (array[middle] == value) {
            System.out.println("The element is found at index: " + middle);
        } else {
            System.out.println("The element is not found in the array.");
        }

    }
}