class Solution {
    public boolean canJump(int[] nums) {
        int lastIdx = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastIdx) {
                lastIdx = i;
            }
        }
        return lastIdx == 0;
    }
}
