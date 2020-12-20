class Solution {
    public String reverseWords(String s) {
        if (s == null) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        int j = i;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
            while (j >= 0 && s.charAt(j) != ' ') {
                j--;
            }
            sb.append(s.subSequence(j < 0 ? 0 : j + 1,i < 0 ? 0 : i + 1));
            sb.append(' ');
            i = j - 1;
        }
        return sb.toString().trim();
    }
}
