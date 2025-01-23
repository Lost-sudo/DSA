package array.samples;

import java.util.Arrays;

public class DuplicateNumber {
    public static void main(String[] args) {
        int[] myNumbers = {1, 1, 2, 2, 3, 4, 5};
        int[] result = removeDuplicates(myNumbers);
        System.out.println(Arrays.toString(result));
    }

    public static int[] removeDuplicates(int[] arr) {
        int n = arr.length;
        int[] newArr = new int[n];
        int index = 0;

        for (int i = 0; i < n; i++) {
            boolean isDuplicate = false;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                newArr[index++] = arr[i];
            }
        }
        return Arrays.copyOf(newArr, index);
    }
}
