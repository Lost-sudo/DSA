package DynamicProgramming.HouseRobberTopDown;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        int[] arr = {6, 7, 1, 30, 8, 2, 4};
        System.out.println(houseRobber(arr, 0, memo));

    }

    public static int houseRobber(int[] houses, int currentHouse, HashMap<Integer, Integer> memo) {
        if (currentHouse >= houses.length) return 0;

        if (!memo.containsKey(currentHouse)) {
            int stealFirstHouse = houses[currentHouse] + houseRobber(houses, currentHouse+2, memo);
            int skipFirstHouse = houseRobber(houses, currentHouse+1, memo);
            memo.put(currentHouse, Math.max(stealFirstHouse, skipFirstHouse));
        }

        return memo.get(currentHouse);
    }
}
