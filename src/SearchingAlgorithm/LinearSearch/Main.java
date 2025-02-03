package SearchingAlgorithm.LinearSearch;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 3, 2, 10, 23, 11};
        Searching.linearSearch(array, 22);
    }
}

class Searching {
    public static void linearSearch(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                System.out.println("The element is found at index: " + i);
                return;
            }
        }
        System.out.println("The element is not found in the array");
    }
}