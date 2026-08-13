/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isNodeSame(root.left, root.right);
    }

    private boolean isNodeSame(TreeNode left, TreeNode right) {
        if (left == null && right != null)
            return false;
        if (right == null && left != null)
            return false;
        if (right == null && left == null)
            return true;
        if (right.val != left.val)
            return false;
        return isNodeSame(left.left, right.right) && isNodeSame(left.right, right.left);
    }
}