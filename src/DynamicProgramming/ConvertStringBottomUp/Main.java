package DynamicProgramming.ConvertStringBottomUp;

public class Main {
    public static void main(String[] args) {
        System.out.println(findMinOps("horse", "ros"));
    }

    public static int findMinOps(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) dp[i][0] = i;
        for (int j = 0; j <= m; j++) dp[0][j] = j;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int deleteOps = dp[i-1][j] + 1;
                    int insertOps = dp[i][j-1] + 1;
                    int replaceOps = dp[i-1][j-1] + 1;
                    dp[i][j] = Math.min(deleteOps, Math.min(insertOps, replaceOps));
                }
            }
        }

        return dp[n][m];
    }
}
