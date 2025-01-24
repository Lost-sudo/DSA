package array.samples;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {10, 10, 20, 20, 20, 30, 30};
        int result = removeDuplicatesInSortedArray(nums);
        System.out.println("Number of unique elements: " + result);
        // Print the updated array
        for (int i = 0; i < result; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int removeDuplicatesInSortedArray(int[] numberArray) {
        if (numberArray.length == 0) {
            return 0;
        }

        int i = 0; // Pointer for the position of unique elements
        for (int j = 1; j < numberArray.length; j++) { // Start from the second element
            if (numberArray[j] != numberArray[i]) {
                i++; // Move the pointer for unique elements
                numberArray[i] = numberArray[j]; // Place the unique element at the next position
            }
        }
        return i + 1; // Length of the array with unique elements
    }
}
