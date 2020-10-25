class Solution {
    public int removeDuplicates(int[] nums) {
        int p = 0;
        int q = 1;
        for (; q < nums.length; q++) {
            if (nums[p] != nums[q]) {
                nums[++p] = nums[q];
            }
        }
        return p + 1;
    }
}
