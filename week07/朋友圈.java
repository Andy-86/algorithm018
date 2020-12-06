class Solution {
    public int findCircleNum(int[][] M) {
        int len = M.length;
        boolean[] visited = new boolean[len];
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                dsf(visited, M, i);
                count++;
            }
        }
        return count;
    }

    public void dsf(boolean[] visited, int[][] M, int x) {
        if (!visited[x]) {
            visited[x] = true;
            for (int i = 0; i < M.length; i++) {
                if (!visited[i] && M[x][i] == 1) {
                    dsf(visited, M, i);
                }
            }
        }
    }
}
