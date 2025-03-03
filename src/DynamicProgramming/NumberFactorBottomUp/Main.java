package DynamicProgramming.NumberFactorBottomUp;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(numberFactor(4));
        System.out.println(numberFactor(5));
        System.out.println(numberFactor(6));
    }

    public static int numberFactor(int n) {
        if (n < 0) return 0;
        int[] dp = new int[n + 1];

        dp[0] = 1;
        if (n >= 1) dp[1] = 1;
        if (n >= 2) dp[2] = 1;
        if (n >= 3) dp[3] = 2;

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 4];
        }

        return dp[n];
    }
}
