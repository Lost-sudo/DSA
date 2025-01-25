package array.samples;

public class MissingNumber {
    public static void main(String[] args) {
        int[] myArray = {1, 2, 3, 4, 5, 0, 7};
        int result = findMissingNumber(myArray);
        System.out.println(result);
    }

    static int findMissingNumber(int[] arr) {
        int n = arr.length;
        int expectedSum = (n * (n+1)) / 2;
        int actualSum = 0;

        for (int j : arr) {
            actualSum += j;
        }
        return expectedSum - actualSum;
    }
}
