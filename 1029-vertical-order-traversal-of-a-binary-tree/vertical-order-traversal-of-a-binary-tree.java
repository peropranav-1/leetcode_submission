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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Map<Integer, Map<Integer, List<Integer>>> map = new HashMap<>();
        getVerticalTraversal(root, queue, map);
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(e -> e.getValue().entrySet().stream()
                        .sorted(Map.Entry.comparingByKey())
                        .flatMap(re -> { Collections.sort(re.getValue()); return re.getValue().stream(); })
                        .toList())
                .toList();
    }

    private void getVerticalTraversal(TreeNode root, Queue<TreeNode> queue,
                                      Map<Integer, Map<Integer, List<Integer>>> map) {
        if (root == null) return;
        Queue<int[]> posQueue = new LinkedList<>(); // tracks [row, col] per node
        queue.add(root);
        posQueue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int[] pos = posQueue.poll();
            int row = pos[0], col = pos[1];

            map.computeIfAbsent(col, k -> new HashMap<>())
               .computeIfAbsent(row, k -> new ArrayList<>())
               .add(node.val);

            if (node.left != null) {
                queue.add(node.left);
                posQueue.add(new int[]{row + 1, col - 1});
            }
            if (node.right != null) {
                queue.add(node.right);
                posQueue.add(new int[]{row + 1, col + 1});
            }
        }
    }
}