class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int[] dp = new int[len];
        int max = 0;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i > 1 ? dp[i - 2] : 0) + 2;
                } else {
                    int pre = i - dp[i - 1] - 1;
                    if (pre >= 0 && s.charAt(pre) == '(') {
                        dp[i] = dp[i - 1] + 2 + ((pre > 0) ? dp[pre - 1] : 0);
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
