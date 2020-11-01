//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        return getAllUglyNumber(n);
    }

    public int getAllUglyNumber(int n) {
        int i1 = 0, i2 = 0, i3 = 0;
        int[] result = new int[1690];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(result[i1] * 2, result[i2] * 3), result[i3] * 5);
            result[i] = min;
            if (min == result[i1] * 2) i1++;
            if (min == result[i2] * 3) i2++;
            if (min == result[i3] * 5) i3++;
        }
        return result[n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
