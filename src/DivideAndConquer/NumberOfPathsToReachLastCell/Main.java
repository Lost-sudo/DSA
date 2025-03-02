package DivideAndConquer.NumberOfPathsToReachLastCell;

public class Main {
    public static void main(String[] args) {
        NumberOfPathsToReachLastCell noptrlc = new NumberOfPathsToReachLastCell();
        int[][] array = {
                {4, 7, 1, 6},
                {5, 7, 3, 9},
                {3, 2, 1, 2},
                {7, 1, 6, 3},
        };
        int cost = 25;
        System.out.println(noptrlc.numberOfPaths(array, array.length-1, array[0].length-1, cost));
    }
}
