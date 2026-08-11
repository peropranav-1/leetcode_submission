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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorderTraversalRecursive(root, ans);
        return ans;
    }

    private void postorderTraversalRecursive(TreeNode root, List<Integer> ans) {
        if(root == null) return;
        postorderTraversalRecursive(root.left, ans);
        postorderTraversalRecursive(root.right, ans);
        ans.add(root.val);
    }
}