package sorting.assigment_problems;

public class WarehouseBinGridScan {

    static int[] warehouseSummary(int[][] grid) {
        int total = 0, maxVal = Integer.MIN_VALUE, maxRow = 0, maxCol = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];
                if (grid[i][j] > maxVal) {
                    maxVal = grid[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        return new int[]{total, maxRow, maxCol};
    }

    public static void main(String[] args) {
        int[][] grid = {
                {4, 9, 2},
                {7, 1, 6},
                {3, 12, 5}
        };
        int[] result = warehouseSummary(grid);
        System.out.println("total = " + result[0] + ", maxCoordinate = (" + result[1] + ", " + result[2] + ")");
    }
}