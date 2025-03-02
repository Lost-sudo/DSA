package DivideAndConquer.LongestPalindromicSubsequence;

public class LongestPalindromicSubsequence {
    private int findLPS(String str, int start, int end) {
        if (start > end) return 0;
        if (start == end) return 1;

        int count1 = 0;
        if (str.charAt(start) == str.charAt(end)) {
            count1 = 2 + findLPS(str, start+1, end-1);
        }
        int count2 = findLPS(str, start+1, end);
        int count3 = findLPS(str, start, end-1);

        return Math.max(count1, Math.max(count2, count3));
    }

    public int findLPS(String s) {
        return this.findLPS(s, 0, s.length()-1);
    }
}
