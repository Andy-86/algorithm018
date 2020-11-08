/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        //terminatro
        if (p_start == p_end) {
            return new TreeNode(preorder[p_start]);
        } else if (p_start > p_end) {
            return null;
        }

        //process current
        int rootValue = preorder[p_start];
        int i = 0;
        for (; i < inorder.length; i++) {
            if (rootValue == inorder[i]) break;
        }
        int letfLen = i - i_start;
        TreeNode root = new TreeNode(rootValue);
        //drill down
        System.out.println(p_start + " " + p_end + " " + i_start + " " + i_end);
        root.left = build(preorder, p_start + 1, p_start + letfLen, inorder, i_start, i);
        root.right = build(preorder, p_start + letfLen + 1, p_end, inorder, i + 1, i_end);
        return root;
    }
}