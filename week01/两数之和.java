class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> pair = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (pair.get(nums[i]) != null) {
                return new int[]{pair.get(nums[i]), i};
            }
            pair.put(target - nums[i], i);
        }
        return new int[]{};
    }
}