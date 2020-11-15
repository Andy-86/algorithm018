class Solution {
    public int jump(int[] nums) {
        int step = 0;
        int end = 0;
        int maxPoint = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            maxPoint = Math.max(maxPoint, nums[i] + i);
            if (i == end) {
                end = maxPoint;
                step++;
            }
        }
        if (maxPoint >= nums.length - 1)
            return step;
        else {
            return 0;
        }
    }
}
