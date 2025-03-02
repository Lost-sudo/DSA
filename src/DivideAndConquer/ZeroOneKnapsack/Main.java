package DivideAndConquer.ZeroOneKnapsack;

public class Main {
    public static void main(String[] args) {
        ZeroOneKnapsack zok = new ZeroOneKnapsack();
        int[] profits = {31, 26, 17, 72};
        int[] weights = {3, 1, 2, 5};

        System.out.println(zok.knapSack(profits, weights, 5));
    }
}
