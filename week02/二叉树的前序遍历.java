

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<Pair<TreeNode, Boolean>> stack = new Stack<Pair<TreeNode, Boolean>>();
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        stack.push(new Pair(root, false));
        while (!stack.isEmpty()) {
            Pair<TreeNode, Boolean> pair = stack.pop();
            if (!pair.getValue()) {
                if (pair.getKey().right != null) stack.push(new Pair(pair.getKey().right, false));
                if (pair.getKey().left != null) stack.push(new Pair(pair.getKey().left, false));
                stack.push(new Pair(pair.getKey(), true));
            } else {
                res.add(pair.getKey().val);
            }
        }
        return res;
    }
}
