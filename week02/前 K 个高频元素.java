class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        List<Integer>[] list = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int i = map.get(key);
            if (list[i] == null) {
                list[i] = new ArrayList();
            }
            list[i].add(key);
        }
        int count = 0;
        for (int i = list.length - 1; i >= 0; i--) {
            if (list[i] == null) continue;
            for (int j = 0; j < list[i].size() && count < k; ++j) {
                res[count] = list[i].get(j);
                count++;
            }
            if (count == k)
                break;
        }
        return res;
    }
}
