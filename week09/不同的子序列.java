class Solution {
    public int numDistinct(String s, String t) {
        if (s == null || t == null) {
            return 0;
        }
        int rows = s.length();
        int clos = t.length();
        int[][] dp = new int[rows + 1][clos + 1];
        for (int j = 0; j < clos; j++) {
            dp[0][j] = 0;
        }
        for (int i = 0; i < rows; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= clos; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[rows][clos];
    }
}
