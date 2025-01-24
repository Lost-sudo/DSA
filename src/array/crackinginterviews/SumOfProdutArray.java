package array.crackinginterviews;

public class SumOfProdutArray {
    public static void main(String[] args) {
        int[] myArray = {1, 2, 3, 4, 5};
        sumOfProductOfArray(myArray);
    }

    static void sumOfProductOfArray(int[] array) {
        int sum = 0;
        int product = 1;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            product *= array[i];
        }

        System.out.println(sum + " , " + product);
    }
}
