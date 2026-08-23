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
    TreeNode head = null;
    TreeNode ptr = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        treeToLL(root);
        root.right = null;
        root.left = null;
        root.right = head.right;
    }

    private void treeToLL(TreeNode root) {
        if (root == null)
            return;
        TreeNode dsNew = new TreeNode(root.val);
        if (head == null) {
            head = dsNew;
            ptr = dsNew;
        } else {
            ptr.right = dsNew;
            ptr = ptr.right;
        }
        treeToLL(root.left);
        treeToLL(root.right);
    }
}