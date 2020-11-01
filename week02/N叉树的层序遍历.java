/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        levelOrder(result, root, 0);
        return result;
    }

    public void levelOrder(List<List<Integer>> result, Node root, int level) {
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        List<Integer> levelList = result.get(level);
        levelList.add(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            levelOrder(result, root.children.get(i), level + 1);
        }
    }
}
