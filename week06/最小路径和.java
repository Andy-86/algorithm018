class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int clos = grid[0].length;
        int[][] dp = new int[rows][clos];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < clos; j++) {
                if (i > 0 && j > 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                } else if (i == 0 && j > 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (i > 0 && j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                }
            }
        }
        return dp[rows - 1][clos - 1];
    }
}
