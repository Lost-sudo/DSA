package DynamicProgramming.HouseRobberBottomUp;

public class Main {
    public static void main(String[] args) {
        int[] arr = {6, 7, 1, 30, 8, 2, 4};
        System.out.println(houseRobber(arr));
    }

    public static int houseRobber(int[] houses) {
        int n = houses.length;
        if (n == 0) return 0;
        if (n == 1) return houses[0];

        int[] dp = new int[n];

        dp[n - 1] = houses[n - 1];
        dp[n - 2] = Math.max(houses[n-2], houses[n-1]);

        for (int i = n - 3; i >= 0; i--) {
            dp[i] = Math.max(houses[i] + dp[i + 2], dp[i + 1]);
        }

        return dp[0];
    }
}
