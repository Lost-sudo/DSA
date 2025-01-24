package array.samples;

public class SearchArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int result = searchNumberArray(arr, 5);
        System.out.println(result);
    }

    public static int searchNumberArray(int[] arr, int valueToSearch) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == valueToSearch) {
                return i;
            }
        }
        throw new IllegalArgumentException("Value not found in the array");
    }
}
