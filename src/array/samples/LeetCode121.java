package array.samples;

public class LeetCode121 {

    public static void main(String[] args) {
        int[] prices = {50, 30, 10, 30, 20, 50};
        int result = maxProfit(prices);
        System.out.println(result);
    }

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > profit) {
                profit = price - minPrice;
            }
        }
        return profit;
    }
}