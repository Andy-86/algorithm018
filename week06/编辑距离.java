class Solution {
    public int minDistance(String word1, String word2) {
        int row = word1.length();
        int clos = word2.length();
        // dp 数组定义word1 前i个 和 word2 前j 个的最小操作次数
        int[][] dp = new int[row + 1][clos + 1];
        for (int i = 1; i <= row; i++) dp[i][0] = dp[i - 1][0] + 1;
        for (int j = 1; j <= clos; j++) dp[0][j] = dp[0][j - 1] + 1;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= clos; j++) {
                // 假如相等，即不用操作
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                    //dp[i - 1][j - 1] 即 替换，dp[i - 1][j] 删除 dp[i][j - 1] 新增
                else dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        }
        return dp[row][clos];
    }
}
