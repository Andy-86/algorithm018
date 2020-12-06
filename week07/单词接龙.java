class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<String>(wordList);
        if (!wordList.contains(endWord)) return 0;
        Queue<String> startSet = new LinkedList<String>();
        startSet.add(beginWord);
        Queue<String> endSet = new LinkedList<String>();
        endSet.add(endWord);
        Set<String> visited = new HashSet<>();
        int step = 1;
        while (!startSet.isEmpty() && !endSet.isEmpty()) {
            //将starSet设置为最小的
            if (startSet.size() > endSet.size()) {
                Queue<String> temp = startSet;
                startSet = endSet;
                endSet = temp;
            }
            Queue<String> temp = new LinkedList<String>();
            for (String str : startSet) {
                if (check(str, wordSet, visited, endSet, temp)) return step + 1;
            }
            startSet = temp;
            step++;
            //System.out.println(startSet);
        }
        return 0;
    }

    public boolean check(String word, Set<String> wordSet, Set<String> visited, Queue<String> endSet, Queue<String> temp) {
        System.out.println(word + " " + endSet);
        char[] array = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char original = array[i];
            for (char j = 'a'; j <= 'z'; j++) {
                if (j == original) continue;
                array[i] = j;
                String tempStr = new String(array);
                if (wordSet.contains(tempStr)) {
                    if (endSet.contains(tempStr)) {
                        System.out.println(word + " " + endSet + " " + tempStr);
                        return true;
                    }
                    if (!visited.contains(tempStr)) {
                        temp.add(tempStr);
                        visited.add(tempStr);
                    }
                }
                array[i] = original;
            }
        }
        return false;
    }

}
