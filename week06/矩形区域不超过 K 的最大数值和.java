class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) return 0;
        int rows = matrix.length;
        int clos = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < clos; i++) {
            // 先设置滚筒计算
            int[] sumarry = new int[rows];
            // 计算左边届是i 右边是j的矩阵的最大值
            for (int j = i; j < clos; j++) {
                for (int r = 0; r < rows; r++) {
                    sumarry[r] += matrix[r][j];
                }
                //根据summary 汇总
                max = Math.max(getMax(sumarry, k), max);
                if (max == k) return k;
            }
        }
        return max;
    }

    public int getMax(int[] arr, int k) {
        // 先使用动态规划查询是否最大值比k小
        int sumMax = Integer.MIN_VALUE;
        int realMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; ++i) {
            if (sumMax > 0) sumMax += arr[i];
            else sumMax = arr[i];
            realMax = Math.max(realMax, sumMax);
        }
        if (realMax <= k) return realMax;
        // 不行只能暴力
        realMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                // 使用双指针轮训
                sum += arr[j];
                if (sum <= k) realMax = Math.max(realMax, sum);
                if (realMax == k) return k;
            }
        }
        return realMax;
    }
}
