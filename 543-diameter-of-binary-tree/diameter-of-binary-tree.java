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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[]{0};
        getHeight(root,diameter);
        return diameter[0];
    }

    private int getHeight(TreeNode node, int[] diameter) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.left, diameter);
        int rightHeight = getHeight(node.right, diameter);
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}