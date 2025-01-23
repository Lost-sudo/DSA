package array.doubledimensionarray;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        DoubleDimensionArray tda = new DoubleDimensionArray(3, 3);
        tda.insertValueInTheArray(0, 0, 10);
        tda.insertValueInTheArray(0, 1, 20);
        tda.insertValueInTheArray(1, 2, 30);
        tda.insertValueInTheArray(2, 0, 40);
        System.out.println(Arrays.deepToString(tda.arr));
        tda.accessCell(0, 1);
        tda.traverse2DArray();
        tda.searchValueIn2DArray(40);
        tda.deleteValue2DArray(40);
        tda.traverse2DArray();
    }
}
