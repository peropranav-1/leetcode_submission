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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> finalAns = new ArrayList<>();
        if (root == null)
            return finalAns;
        List<List<Integer>> ans = getLevelOrder(root);
        for (int i = 0; i < ans.size(); i++) {
            finalAns.add(ans.get(i).getLast());
        }
        return finalAns;
    }

    private List<List<Integer>> getLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        TreeNode curr = root;
        que.add(curr);
        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> miniAns = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                curr = que.remove();
                miniAns.add(curr.val);
                if (curr != null && curr.left != null) {
                    que.add(curr.left);
                }
                if (curr != null && curr.right != null) {
                    que.add(curr.right);
                }
            }
            ans.add(miniAns);
        }
        return ans;
    }
}