class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = i > 1 ? dp[i - 2] + 2 : 2;
                } else {
                    int pre = i - 1 - dp[i - 1];
                    if (pre >= 0 && s.charAt(pre) == '(') {
                        dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
