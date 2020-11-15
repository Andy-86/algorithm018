class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Set<String> set = new HashSet<String>();
        int di = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < obstacles.length; i++) {
            set.add(obstacles[i][0] + "#" + obstacles[i][1]);
        }
        int max = 0;
        for (int i : commands) {
            // 上面的Direction是上右下左顺序，向左90度就是求余3
            if (i == -2) {
                di = (di + 3) % 4;
            } else if (i == -1) {
                di = (di + 1) % 4;
            } else if (i > 0) {
                int dirx = direction[di][0];
                int diry = direction[di][1];
                for (int j = 0; j < i; j++) {
                    int temx = dirx + x;
                    int temy = diry + y;
                    String key = temx + "#" + temy;
                    if (!set.contains(key)) {
                        x = temx;
                        y = temy;
                        max = Math.max(max, x * x + y * y);
                    }
                }
            }
        }
        return max;
    }
}
