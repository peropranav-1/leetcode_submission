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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> que = new LinkedList<>();
        TreeNode curr = root;
        que.add(curr);
        int count = 0;
        while (!que.isEmpty()) {
            List<Integer> miniAns = new ArrayList<>();
            int queLength = que.size();
            for (int i = 0; i < queLength; i++) {
                curr = que.remove();
                miniAns.add(curr.val);
                if (curr.left != null) {
                    que.add(curr.left);
                }
                if (curr.right != null) {
                    que.add(curr.right);
                }
            }
            if (count % 2 == 0) {
                ans.add(miniAns);
                count++;
            } else {
                Collections.reverse(miniAns);
                ans.add(miniAns);
                count++;
            }

        }
        return ans;
    }

}