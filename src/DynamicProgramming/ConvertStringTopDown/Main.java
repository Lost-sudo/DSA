package DynamicProgramming.ConvertStringTopDown;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(findMinimumOps("horse", "ros"));
    }

    public static int findMinimumOps(String s1, String s2) {
        HashMap<String, Integer> memo = new HashMap<>();
        return findMinOps(s1, s2, 0, 0, memo);
    }

    private static int findMinOps(String s1, String s2, int i1, int i2, HashMap<String, Integer> memo) {
        if (i1 == s1.length()) return s2.length() - i2;
        if (i2 == s2.length()) return s1.length() - i1;

        String key = i1 + "," + i2;
        if (memo.containsKey(key)) return memo.get(key);

        if (s1.charAt(i1) == s2.charAt(i2)) {
            memo.put(key, findMinOps(s1, s2, i1+1, i2+1, memo));
        } else {
            int deleteOps = 1 + findMinOps(s1, s2, i1+1, i2, memo);
            int insertOps = 1 + findMinOps(s1, s2, i1, i2+1, memo);
            int replaceOps = 1 + findMinOps(s1, s2, i1+1, i2+1, memo);

            memo.put(key, Math.min(deleteOps, Math.min(insertOps, replaceOps)));
        }

        return memo.get(key);

    }
}
