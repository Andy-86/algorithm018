class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap();
        int[] counter = new int[26];
        for (String s : strs) {
            for (int i = 0; i < s.length(); ++i) {
                counter[s.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < counter.length; i++) {
                sb.append("#");
                sb.append(counter[i]);
            }
            Arrays.fill(counter, 0);
            String key = sb.toString();
            if (!result.containsKey(key)) result.put(sb.toString(), new ArrayList<>());
            result.get(key).add(s);
        }
        return new ArrayList<>(result.values());
    }
}
