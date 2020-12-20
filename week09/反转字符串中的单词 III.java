class Solution {
    public String reverseWords(String s) {
        int i = 0;
        int j = 0;
        char[] array = s.toCharArray();
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) == ' ') {
                i++;
            }
            j = i;
            while (j < s.length() && s.charAt(j) != ' ') {
                j++;
            }
            int left = i;
            int right = j - 1;
            while (left < right) {
                char tem = array[left];
                array[left++] = array[right];
                array[right--] = tem;
            }
            i = j;
        }
        return new String(array);
    }
}
