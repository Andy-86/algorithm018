class Solution {
    private int[][] direcitons = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int rows = grid.length;
        int clos = grid[0].length;
        boolean[][] visited = new boolean[rows][clos];
        int count = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < clos; j++) {
                if (dsf(visited, grid, i, j, rows, clos)) count++;
            }
        }
        return count;
    }


    public boolean dsf(boolean[][] visited, char[][] grid, int tempRows, int tempClos, int row, int clos) {
        if (grid[tempRows][tempClos] == '1' && !visited[tempRows][tempClos]) {
            visited[tempRows][tempClos] = true;
            for (int i = 0; i < 4; i++) {
                int nextRow = direcitons[i][0] + tempRows;
                int nextClos = direcitons[i][1] + tempClos;
                if (nextRow >= 0 && nextClos >= 0 && nextRow < row && nextClos < clos && !visited[nextRow][nextClos])
                    dsf(visited, grid, nextRow, nextClos, row, clos);
            }
            return true;
        }
        return false;
    }
}
