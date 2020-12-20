class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null) {
            return res;
        }
        int[] need = new int[26];
        int[] window = new int[26];
        for (int i = 0; i < p.length(); i++) {
            need[p.charAt(i) - 'a']++;
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            int curR = s.charAt(i) - 'a';
            window[curR]++;
            while (window[curR] > need[curR]) {
                int curL = s.charAt(left) - 'a';
                window[curL]--;
                left++;
            }
            if (right - left + 1 == p.length()) {
                res.add(left);
            }
            right++;
        }
        return res;
    }
}
