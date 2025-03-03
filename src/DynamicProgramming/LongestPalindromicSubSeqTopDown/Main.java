package DynamicProgramming.LongestPalindromicSubSeqTopDown;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> memo = new HashMap<>();
        String str = "ELRMENMET";
        System.out.println(findLPS(str, 0, str.length()-1, memo));
    }

    public static int findLPS(String s, int start, int end, HashMap<String, Integer> memo) {
        if (start > end) return 0;
        if (start == end) return 1;

        String key = start + "," + end;
        if (memo.containsKey(key)) return memo.get(key);

        int count1 = 0;
        if (s.charAt(start) == s.charAt(end)) {
            count1 = 2 + findLPS(s, start+1, end-1, memo);
        }
        int count2 = findLPS(s, start+1, end, memo);
        int count3 = findLPS(s, start, end-1, memo);

        int res = Math.max(count1, Math.max(count2, count3));
        memo.put(key, res);

        return res;
    }
}
