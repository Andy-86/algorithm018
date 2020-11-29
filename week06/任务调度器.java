class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;
        int[] bucket = new int[26];
        // 计算桶记录
        for (int i = 0; i < tasks.length; ++i) {
            bucket[tasks[i] - 'A']++;
        }
        int max = 0;
        for (int i = 0; i < bucket.length; i++) {
            max = Math.max(max, bucket[i]);
        }
        int maxCount = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] == max) maxCount++;
        }
        //真实中只有两种情况，一种是能填满所有轮回的桶，则为 tasks.lenght, 不能则为 (max - 1) * (n + 1) + maxCount
        return Math.max((max - 1) * (n + 1) + maxCount, tasks.length);
    }
}
