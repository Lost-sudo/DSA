package array.samples;

public class MaxProduct {

    public static void main(String[] args) {
        int[] array = {10, 13, 14, 56, 12, 100};
        String result = maxProduct(array);
        System.out.println(result);
    }

    public static String maxProduct(int[] arr){
        int maxProduct = 0;
        String pairs = "";
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] * arr[j] > maxProduct) {
                    maxProduct = arr[i] * arr[j];
                    pairs ="[" + arr[i] + "," + arr[j]+ "]";
                }
            }
        }
        return pairs;
    }
}
