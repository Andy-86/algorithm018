class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        //for (int i = 0; i < dp.length; i++) dp[i][i] = true;
        int time = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i - j < 2 || dp[j + 1][i - 1]) {
                        dp[j][i] = true;
                        time++;
                    }
                }
            }
        }
        return time;
    }
}
