package algorithms.assigment_problems;

public class BusiestBusRow {

    static int[] busiestRow(int[][] grid) {
        int bestRow = 0;
        int bestTotal = Integer.MIN_VALUE;

        for (int i = 0; i < grid.length; i++) {
            int total = 0;
            for (int value : grid[i]) {
                total += value;
            }
            if (total > bestTotal) {
                bestTotal = total;
                bestRow = i;
            }
        }

        return new int[]{bestRow, bestTotal};
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2, 0, 1},
                {3, 3, 1},
                {1, 1, 1}
        };
        int[] result = busiestRow(grid);
        System.out.println("Row " + result[0] + ", Total " + result[1]);
    }
}