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
    List<String> ans = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        getList(root, new ArrayList<>());
        return ans;
    }

    private void getList(TreeNode root, List<Integer> ds) {
        if (root == null) {
            ds.add(null);
            return;
        }
        ds.add(root.val);

        if (root.left == null && root.right == null) {
            getAns(ds);
            return;
        }
        getList(root.left, ds);
        ds.remove(ds.size() - 1);
        getList(root.right, ds);
        ds.remove(ds.size() - 1);
    }

    private void getAns(List<Integer> ds) {
        String miniAns = "";
        if (ds.size() < 1)
            return;
        if (ds.size() == 1) {
            miniAns = miniAns + ds.get(0);
            ans.add(miniAns);
            return;
        }
        miniAns = miniAns + ds.get(0);
        for (int i = 1; i < ds.size(); i++) {
            miniAns = miniAns + "->" + ds.get(i);
        }
        ans.add(miniAns);
    }
}