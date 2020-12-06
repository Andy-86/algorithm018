class Solution {
    private List<List<String>> res = new ArrayList<>();
    private Set<Integer> pie = new HashSet<>();
    private Set<Integer> na = new HashSet<>();
    int n = 0;
    int[] path;
    StringBuilder sb = new StringBuilder();

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        path = new int[this.n];
        Arrays.fill(path, -1);
        dsf(0);
        return res;
    }

    public void dsf(int level) {
        if (level == n) {
            res.add(build());
            return;
        }
        for (int i = 0; i < this.n; ++i) {
            if (path[i] == -1 && !pie.contains(i - level) && !na.contains(i + level)) {
                path[i] = level;
                pie.add(i - level);
                na.add(i + level);
                dsf(level + 1);
                path[i] = -1;
                pie.remove(i - level);
                na.remove(i + level);
            }
        }
    }

    public List<String> build() {
        if (sb.length() == 0) {
            for (int i = 0; i < n; i++) {
                sb.append(".");
            }
        }
        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            sb.replace(i, i + 1, "Q");
            array[path[i]] = sb.toString();
            sb.replace(i, i + 1, ".");
        }
        return Arrays.asList(array);
    }
}
