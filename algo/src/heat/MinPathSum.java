package heat;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-25 9:32
 */
public class MinPathSum {

    public static void main(String[] args) {
        MinPathSum s = new MinPathSum();
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(s.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        int minSum = Integer.MAX_VALUE;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 1; i < n; i++) {
            grid[0][i] += grid[0][i - 1];
        }

        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }
}
