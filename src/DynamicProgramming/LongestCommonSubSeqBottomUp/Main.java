package DynamicProgramming.LongestCommonSubSeqBottomUp;

public class Main {
    public static void main(String[] args) {
        System.out.println(findLCSBU("ABCBDAB", "BDCABA"));
    }

    public static int findLCSBU(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }

        int index = dp[0][0];
        char[] lcs =  new char[index];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n && j < m) {
            if (s1.charAt(i) == s2.charAt(j)) {
                lcs[k++] = s1.charAt(i);
                i++;
                j++;
            } else if (dp[i+1][j] >= dp[i][j+1]) {
                i++;
            } else {
                j++;
            }
        }

        System.out.println(lcs);
        return dp[0][0];
    }
}
