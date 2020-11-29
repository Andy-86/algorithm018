class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.startsWith("0")) return 0;
        int cur0 = 1;
        int cur1 = 1;
        for (int i = 1; i < s.length(); i++) {
            int sum = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
            if (s.charAt(i) == '0') {
                if (sum > 26) return 0;
                cur1 = cur0;
                cur0 = 0;
                continue;
            }
            if (sum > 26) {
                cur0 = cur1;
            } else {
                int tem = cur1;
                cur1 = cur1 + cur0;
                cur0 = tem;
            }
        }
        return cur1;
    }
}
