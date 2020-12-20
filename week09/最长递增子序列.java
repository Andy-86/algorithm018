class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] res = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            int j = i;
            int maxRes = 0;
            for (; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    maxRes = Math.max(maxRes, res[j]);
                }
            }
            res[i] = maxRes + 1;
            max = Math.max(res[i], max);
        }
        return max;
    }
}
