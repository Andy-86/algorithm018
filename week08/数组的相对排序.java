class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr1.length; ++i) {
            if (arr1[i] > max) {
                max = arr1[i];
            }
        }
        int[] bucket = new int[max + 1];
        for (int i = 0; i < arr1.length; ++i) {
            bucket[arr1[i]]++;
        }
        int[] res = new int[arr1.length];
        int count = 0;
        for (int j = 0; j < arr2.length; j++) {
            while (bucket[arr2[j]] > 0) {
                res[count++] = arr2[j];
                bucket[arr2[j]]--;
            }
        }
        for (int i = 0; i < bucket.length; ++i) {
            while (bucket[i] > 0) {
                res[count++] = i;
                bucket[i]--;
            }
        }
        return res;
    }
}
