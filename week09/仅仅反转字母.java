class Solution {
    public String reverseOnlyLetters(String S) {
        if (S == null) {
            return S;
        }
        int left = 0;
        int right = S.length() - 1;
        char[] array = S.toCharArray();
        while (left < right) {
            while (left < right && (S.charAt(left) < 'A' || S.charAt(left) > 'z' || (S.charAt(left) > 'Z' && S.charAt(left) < 'a'))) {
                left++;
            }
            while (left < right && (S.charAt(right) < 'A' || S.charAt(right) > 'z' || (S.charAt(right) > 'Z' && S.charAt(right) < 'a'))) {
                right--;
            }
            char tem = array[left];
            array[left++] = array[right];
            array[right--] = tem;
        }
        return new String(array);
    }
}
