class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        char[] array = new char[2 * n];
        dsf(result, array, n, 0, 0, 0);
        return result;
    }

    public void dsf(List<String> result, char[] array, int n, int left, int right, int level) {
        //terminator
        if (left < right) return;
        if (left == n && right == n) result.add(new String(array));

        if (left < n) {
            array[level] = '(';
            dsf(result, array, n, left + 1, right, level + 1);
        }
        if (right < n) {
            array[level] = ')';
            dsf(result, array, n, left, right + 1, level + 1);
        }
    }
}
