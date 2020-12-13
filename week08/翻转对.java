class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] tem = new int[nums.length];
        return mergeSort(nums, tem, 0, nums.length - 1);
    }

    public int mergeSort(int[] nums, int tem[], int left, int right) {
        if (right <= left) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int count = mergeSort(nums, tem, left, mid) + mergeSort(nums, tem, mid + 1, right);
        // 先统计跨区间对翻转对个数
        for (int i = left, j = mid + 1; i <= mid; i++) {
            while (j <= right && (long) nums[i] > (long) nums[j] * 2) {
                j++;
            }
            count += j - mid - 1;
        }
        if (nums[mid] <= nums[mid + 1]) {
            return count;
        }
        int i = left;
        int j = mid + 1;
        int k = 0;
        for (; i <= mid && j <= right; ) {
            tem[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            tem[k++] = nums[i++];
        }
        while (j <= right) {
            tem[k++] = nums[j++];
        }
        System.arraycopy(tem, 0, nums, left, right - left + 1);
        return count;
    }
}
