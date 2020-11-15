class Solution {
    private int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, 1}, {-1, -1}, {1, -1}, {1, 1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        int y = click[0];
        int x = click[1];
        if (board[y][x] == 'M') {
            board[y][x] = 'X';
        } else {
            dsf(board, x, y);
        }
        return board;
    }

    public void dsf(char[][] board, int x, int y) {
        if (board[y][x] == 'M') {
            board[y][x] = 'X';
            return;
        } else if (board[y][x] != 'E') {
            return;
        }
        int boomCount = 0;
        for (int i = 0; i < 8; i++) {
            int temx = x + directions[i][0];
            int temy = y + directions[i][1];
            if (temx < 0 || temy < 0 || temy >= board.length || temx >= board[0].length) continue;
            if (board[temy][temx] == 'M' || board[temy][temx] == 'X') boomCount++;
        }
        if (boomCount == 0) {
            board[y][x] = 'B';
        } else {
            board[y][x] = (char) ('0' + boomCount);
            return;
        }
        //向8个方向递归
        for (int i = 0; i < 8; i++) {
            int temx = x + directions[i][0];
            int temy = y + directions[i][1];
            if (temx < 0 || temy < 0 || temy >= board.length || temx >= board[0].length) continue;
            dsf(board, temx, temy);
        }
    }
}
