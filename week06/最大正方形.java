class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int rows = matrix.length;
        int clos = matrix[0].length;
        int[][] dp = new int[rows + 1][clos + 1];
        int maxLen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= clos; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    // 先计算边长，只有正方形可以使用这种形式假如是 矩形需要使用多一纬数组
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen * maxLen;
    }
}
