package DynamicProgramming.FibonacciUsingBottomUpTabulation;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(fibTabulation(6));
    }

    public static int fibTabulation(int n) {
        List<Integer> tb = new ArrayList<>();
        tb.add(0);
        tb.add(1);
        for (int i = 2; i <= n-1; i++) {
            int n1 = tb.get(i-1);
            int n2 = tb.get(i-2);
            tb.add(n1+n2);
        }

        return tb.get(n-1);
    }
}
