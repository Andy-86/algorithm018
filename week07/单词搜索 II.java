class Solution {
    class TrieNode {
        TrieNode[] array = new TrieNode[26];

        String word;
    }

    public TrieNode build(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); ++i) {
                int idx = word.charAt(i) - 'a';
                if (p.array[idx] == null) {
                    p.array[idx] = new TrieNode();
                }
                p = p.array[idx];
            }
            p.word = word;
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<String>();
        if (board == null || board.length == 0 || words == null || words.length == 0) {
            return list;
        }
        int rows = board.length;
        int clos = board[0].length;
        TrieNode root = build(words);
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < clos; j++) {
                dfs(board, i, j, root, list);
            }
        }
        return list;
    }

    public void dfs(char[][] board, int i, int j, TrieNode root, List<String> list) {
        // terminator
        int idx = board[i][j] - 'a';
        if (board[i][j] == '#' || root.array[idx] == null) {
            return;
        }
        if (root.array[idx].word != null) {
            list.add(root.array[idx].word);
            // 减少重复元素
            root.array[idx].word = null;
        }
        char tem = board[i][j];
        //防止访问已经访问的节点
        board[i][j] = '#';
        //drill down
        if (i > 0) {
            dfs(board, i - 1, j, root.array[idx], list);
        }
        if (j > 0) {
            dfs(board, i, j - 1, root.array[idx], list);
        }
        if (i < board.length - 1) {
            dfs(board, i + 1, j, root.array[idx], list);
        }
        if (j < board[0].length - 1) {
            dfs(board, i, j + 1, root.array[idx], list);
        }
        // reset current
        board[i][j] = tem;
    }

}
