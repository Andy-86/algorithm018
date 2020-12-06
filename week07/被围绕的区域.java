class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int rows = board.length;
        int clos = board[0].length;
        // 建立并查集
        UninFile uninFile = new UninFile(rows * clos + 1);
        int endPoint = rows * clos;
        // 将第一行和最后一行的 O 建立联通区域
        for (int i = 0; i < clos; i++) {
            if (board[0][i] == 'O') {
                uninFile.union(getIdx(0, i, clos), endPoint);
            }
            if (board[rows - 1][i] == 'O') {
                uninFile.union(getIdx(rows - 1, i, clos), endPoint);
            }
        }
        //合并第一列和最后一列
        for (int i = 1; i < rows - 1; i++) {
            if (board[i][0] == 'O') {
                uninFile.union(getIdx(i, 0, clos), endPoint);
            }
            if (board[i][clos - 1] == 'O') {
                uninFile.union(getIdx(i, clos - 1, clos), endPoint);
            }
        }
        int[][] directions = {{1, 0}, {0, 1}};
        // 将非外围的也进行合并
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < clos; j++) {
                if (board[i][j] == 'O') {
                    for (int[] direction : directions) {
                        int temi = direction[1] + i;
                        int temj = direction[0] + j;
                        if (temi < rows && temj < clos && board[temi][temj] == 'O') {
                            uninFile.union(getIdx(i, j, clos), getIdx(temi, temj, clos));
                        }
                    }
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < clos; j++) {
                if (board[i][j] == 'O') {
                    if (!uninFile.isConnected(getIdx(i, j, clos), endPoint)) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }

    public int getIdx(int i, int j, int clos) {
        return i * clos + j;
    }

    class UninFile {
        int[] parent;

        public UninFile(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            int xPerent = parent[parent[x]];
            if (xPerent == x) {
                return x;
            }
            return find(xPerent);
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        public void union(int x, int y) {
            int xPerent = find(x);
            int yParnet = find(y);
            if (xPerent == yParnet) {
                return;
            }
            parent[xPerent] = yParnet;
        }
    }
}
