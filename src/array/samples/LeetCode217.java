package array.samples;

public class LeetCode217 {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 4, 5};
        int[] array1 = {1, 2, 3, 4, 5};
        boolean result = isUnique(array);
        boolean result1 = isUnique(array1);
        System.out.println(result);
        System.out.println(result1);
    }

    public static boolean isUnique(int[] arr) {
        boolean isUnique = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    isUnique = false;
                    break;
                }
            }
        }
        return isUnique;
    }
}
