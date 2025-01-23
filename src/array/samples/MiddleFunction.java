package array.samples;

import java.util.Arrays;

public class MiddleFunction {
    public static void main(String[] args) {
        int[] myArray = {1, 2, 3, 4};
        int[] middle = middle(myArray);
        System.out.println(Arrays.toString(middle));

    }

    public static int[] middle(int[] array) {
        int[] middleArray = new int[array.length - 2];
        int index = 1;
        while (index < array.length - 1) {
            middleArray[index - 1] = array[index];
            index++;
        }
        return middleArray;
    }
}
