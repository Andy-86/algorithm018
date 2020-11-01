
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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<Pair<TreeNode, Boolean>> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(new Pair<>(root, false));
        if (root == null) {
            return list;
        }
        while (!stack.isEmpty()) {
            Pair<TreeNode, Boolean> pair = stack.pop();
            if (pair.getValue()) {
                list.add(pair.getKey().val);
            } else {
                if (pair.getKey().right != null) {
                    stack.push(new Pair<>(pair.getKey().right, false));
                }
                stack.push(new Pair<>(pair.getKey(), true));
                if (pair.getKey().left != null) {
                    stack.push(new Pair<>(pair.getKey().left, false));
                }
            }
        }
        return list;
    }
}
