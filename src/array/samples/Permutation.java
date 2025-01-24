package array.samples;

public class Permutation {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {5, 2, 3, 4, 1};
        System.out.println(permutation(arr1, arr2));
    }

    public static boolean permutation(int[] array1, int[] array2) {
        int sum1 = 0;
        int sum2 = 0;
        int mul1 = 1;
        int mul2 = 1;

        if (array1.length == array2.length) {
            for (int i = 0; i < array1.length; i++) {
                sum1 += array1[i];
                sum2 += array2[i];
                mul1 *= array1[i];
                mul2 *= array2[i];
            }
        }
        return sum1 == sum2 && mul1 == mul2;
    }
}
