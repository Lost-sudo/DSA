package DynamicProgramming.NumberFactorTopDown;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        System.out.println(numberFactor(4, memo));
        System.out.println(numberFactor(5, memo));
        System.out.println(numberFactor(6, memo));
    }

    public static int numberFactor(int n, HashMap<Integer, Integer> memo) {
        if (n == 0 || n == 1 || n == 2) return 1;
        if (n == 3) return 2;

        if (memo.containsKey(n)) return memo.get(n);

        int result = numberFactor(n - 1, memo) + numberFactor(n - 3, memo) + numberFactor(n - 4, memo);

        memo.put(n, result);
        return memo.get(n);
    }
}
