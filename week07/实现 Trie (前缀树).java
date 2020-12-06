class Trie {

    char letter;

    boolean isWord;

    Trie[] array = new Trie[26];

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        letter = ' ';
        isWord = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie node = this;
        char[] chars = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            if (node.array[chars[i] - 'a'] == null) {
                node.array[chars[i] - 'a'] = new Trie();
            }
            node = node.array[chars[i] - 'a'];
            node.letter = chars[i];
            if (i == word.length() - 1) {
                node.isWord = true;
            }
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie node = this;
        char[] arrays = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            if (node.array[arrays[i] - 'a'] == null) {
                return false;
            }
            node = node.array[arrays[i] - 'a'];
            if (node.letter != arrays[i]) {
                return false;
            }
        }
        return node.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie node = this;
        char[] arrays = prefix.toCharArray();
        for (int i = 0; i < prefix.length(); i++) {
            if (node.array[arrays[i] - 'a'] == null) {
                return false;
            }
            node = node.array[arrays[i] - 'a'];
            if (node.letter != arrays[i]) {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
