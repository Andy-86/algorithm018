class Solution {
    public String reverseStr(String s, int k) {
        if (s == null || k == 0) {
            return s;
        }
        char[] array = s.toCharArray();
        for (int start = 0; start < s.length(); start += 2 * k) {
            int i = start;
            char tem;
            int end = i + k - 1 >= s.length() ? s.length() - 1 : i + k - 1;
            while (end > i) {
                tem = array[i];
                array[i++] = array[end];
                array[end--] = tem;
            }
        }
        return new String(array);
    }
}
