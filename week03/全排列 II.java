class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Deque<Integer> result = new ArrayDeque<Integer>();
        boolean[] candidate = new boolean[nums.length];
        Arrays.sort(nums);
        permuteAll(nums, candidate, nums.length, result, results);
        return results;
    }

    public void permuteAll(int[] nums, boolean[] candidate, int level, Deque<Integer> result, List<List<Integer>> results) {
        //terminator
        if (level == 0) {
            results.add(new ArrayList<Integer>(result));
            return;
        }
        //drill down
        for (int i = 0; i < nums.length; ++i) {
            if (candidate[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !candidate[i - 1]) continue;
            result.addLast(nums[i]);
            candidate[i] = true;
            permuteAll(nums, candidate, level - 1, result, results);
            candidate[i] = false;
            result.removeLast();
        }
    }
}
