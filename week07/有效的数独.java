class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return true;
        }
        int rows = board.length;
        int clos = board[0].length;
        Map<Integer, List<Integer>> horizontal = new HashMap<Integer, List<Integer>>();
        Map<Integer, List<Integer>> vertical = new HashMap<Integer, List<Integer>>();
        Map<Integer, List<Integer>> box = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < rows; i++) {
            horizontal.put(i, new ArrayList<Integer>());
            vertical.put(i, new ArrayList<Integer>());
            box.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < clos; j++) {
                if (board[i][j] != '.') {
                    int boxKey = ((int) (i / 3)) * 3 + (j / 3);
                    Integer value = board[i][j] - '0';
                    if (horizontal.get(j).contains(value) || vertical.get(i).contains(value) || box.get(boxKey).contains(value)) {
                        return false;
                    }
                    horizontal.get(j).add(value);
                    vertical.get(i).add(value);
                    box.get(boxKey).add(value);
                }
            }
        }
        return true;
    }
}
