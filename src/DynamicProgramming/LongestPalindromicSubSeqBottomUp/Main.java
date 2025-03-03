package DynamicProgramming.LongestPalindromicSubSeqBottomUp;

public class Main {
    public static void main(String[] args) {
        System.out.println(findLPS("BBABCBCAB"));
    }

    public static int findLPS(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                int k = j + i - 1;

                if (s.charAt(j) == s.charAt(k)) {
                    dp[j][k] = 2 + dp[j + 1][k-1];
                } else {
                    dp[j][k] = Math.max(dp[j+1][k], dp[j][k-1]);
                }
            }
        }

        return dp[0][n-1];
    }
}
