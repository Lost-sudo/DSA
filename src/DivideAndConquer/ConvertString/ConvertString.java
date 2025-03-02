package DivideAndConquer.ConvertString;

public class ConvertString {
    private int findMinimumOps(String s1, String s2, int i1, int i2) {
        if (i1 == s1.length()) return s2.length() - i2;
        if (i2 == s1.length()) return s1.length() - i1;
        if(s1.charAt(i1) == s2.charAt(i2)) return findMinimumOps(s1, s2, i1+1, i2+1);

        int deleteOp = 1 + findMinimumOps(s1, s2, i1+1, i2);
        int insertOp = 1 + findMinimumOps(s1, s2, i1, i2+1);
        int replaceOp = 1 + findMinimumOps(s1, s2, i1+1, i2+1);

        return Math.min(deleteOp, Math.min(insertOp, replaceOp));
    }

    public int findMinOps(String s1, String s2) {
        return findMinimumOps(s1, s2, 0, 0);
    }
}
