class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        LinkedList<Integer> result = new LinkedList<Integer>();
        build(results, result, 1, n, k);
        return results;
    }

    public void build(List<List<Integer>> results, LinkedList<Integer> result, int start, int end, int k) {
        //terminator
        if (k == 0) {
            results.add(new ArrayList<Integer> (result));
            return;
        }
        //drill down
        for (int i = start; i <= end - k + 1; i++) {
            result.addLast(i);
            build(results, result, i + 1, end, k - 1);
            result.removeLast();
        }
    }
}
