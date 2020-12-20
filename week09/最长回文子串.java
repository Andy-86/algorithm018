class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) dp[i][i] = true;
        int maxLen = 1;
        int maxIdx = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i - j < 3) dp[j][i] = true;
                    else if (dp[j + 1][i - 1]) dp[j][i] = true;
                    if (dp[j][i] && (i - j + 1) > maxLen) {
                        maxLen = i - j + 1;
                        maxIdx = j;
                    }
                }
            }
        }
        return s.substring(maxIdx, maxLen + maxIdx);
    }
}
