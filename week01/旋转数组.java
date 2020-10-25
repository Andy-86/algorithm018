class Solution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        if (k == 0 || length == 0) {
            return;
        }
        k = k % length;
        int count = 0;
        int start = 0;
        while (count < length) {
            int cur = start;
            int pre = nums[cur];
            do {
                int next = (cur + k) % length;
                int tempval = nums[next];
                nums[next] = pre;
                cur = next;
                pre = tempval;
                count++;
            } while (cur != start);
            start++;
        }

    }
}
