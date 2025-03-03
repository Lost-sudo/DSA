package DynamicProgramming.LongestCommonSubSeqTopDown;

public class Main {
    public static void main(String[] args) {
        System.out.println(findLCSLengthTD("ABCBDAB", "BDCABA"));
    }

    public static int findLCSLengthTD(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = - 1;
            }
        }

        return findLCS(s1, s2, 0, 0, dp);
    }

    public static int findLCS(String s1, String s2, int i1, int i2, int[][] dp) {
        if (i1 == s1.length() || i2 == s2.length()) return 0;

        if (dp[i1][i2] == - 1) {
            if (s1.charAt(i1) == s2.charAt(i2)) {
                dp[i1][i2] = 1 + findLCS(s1, s2, i1+1, i2+1, dp);
            } else {
                int c1 = findLCS(s1, s2, i1+1, i2, dp);
                int c2 = findLCS(s1, s2, i1, i2+1, dp);
                dp[i1][i2] = Math.max(c1, c2);
            }
        }

        return dp[i1][i2];
    }
}
