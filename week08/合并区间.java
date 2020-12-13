class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> res = new ArrayList<int[]>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            int[] last = res.get(res.size() - 1);
            if (last[1] < current[0]) {
                res.add(current);
            } else {
                last[1] = last[1] > current[1] ? last[1] : current[1];
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
