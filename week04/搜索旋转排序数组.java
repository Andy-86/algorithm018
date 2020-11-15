class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        //看是否需要查找最小数
        if (nums[left] > nums[right]) {
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] > nums[mid + 1]) {
                    left = mid + 1;
                    break;
                }
                if (nums[mid] >= nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        right = left == 0 ? nums.length - 1 : left - 1;
        System.out.println(nums[left]);
        System.out.println(nums[right]);
        //找出对应区间
        if (target < nums[left] || target > nums[right]) return -1;
        if (target >= nums[0]) {
            left = 0;
        } else {
            right = nums.length - 1;
        }
        //二分查找
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

}
