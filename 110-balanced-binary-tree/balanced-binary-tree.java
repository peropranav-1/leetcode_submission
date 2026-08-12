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
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int lHeight = heightOfTree(root.left);
        int rHeight = heightOfTree(root.right);

        if (Math.abs(lHeight - rHeight) > 1)
            return false;

        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);

        return left && right;
    }

    private int heightOfTree(TreeNode root) {
        if (root == null)
            return 0;
        int height = 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
        return height;
    }
}