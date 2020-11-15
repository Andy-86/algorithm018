class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gid = 0;
        int sid = 0;
        while (gid < g.length && sid < s.length) {
            //轮询满足孩子当最小饼干
            if (g[gid] <= s[sid]) gid++;
            sid++;
        }
        return gid;
    }
}
