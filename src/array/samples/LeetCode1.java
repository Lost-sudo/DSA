package array.samples;

import java.util.Arrays;

public class LeetCode1 {
    public static void main(String[] args) {
        int[] arrayOfNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] result = twoSum(arrayOfNumbers, 7);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] arraysOfNumbers, int target) {
        for (int i = 0; i < arraysOfNumbers.length; i++) {
            for (int j = i + 1; j < arraysOfNumbers.length; j++) {
                if (arraysOfNumbers[i] + arraysOfNumbers[j] == target) {
                    return new int[]{arraysOfNumbers[i], arraysOfNumbers[j]};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution found.");
    }
}
