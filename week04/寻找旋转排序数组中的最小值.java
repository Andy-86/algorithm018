class Solution {
    public int findMin(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return nums[0];
        int letf = 0;
        int right = nums.length - 1;
        if (nums[letf] < nums[right]) return nums[letf];
        while (letf <= right) {
            //假如找到直接退出
            int mid = letf + (right - letf) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            //找不到的情况区分
            if (nums[mid] >= nums[letf]) {
                letf = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[letf];
    }
}
