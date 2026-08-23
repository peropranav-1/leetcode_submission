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
class NodeWithCords {
    TreeNode node;
    int level;
    int vertical;

    public NodeWithCords(TreeNode node, int level, int vertical) {
        this.node = node;
        this.level = level;
        this.vertical = vertical;
    }
}

public class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<NodeWithCords> queue = new LinkedList<>();
        queue.offer(new NodeWithCords(root, 0, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                NodeWithCords node = queue.peek();
                if (node != null && node.node.left != null) {
                    queue.offer(new NodeWithCords(node.node.left, node.level + 1, node.vertical - 1));
                }
                if (node != null && node.node.right != null) {
                    queue.offer(new NodeWithCords(node.node.right, node.level + 1, node.vertical + 1));
                }
                NodeWithCords curr = queue.peek();
                if (curr == null) continue;
                if (map.containsKey(curr.vertical)) {
                    if (map.get(curr.vertical).containsKey(curr.level)) {
                        PriorityQueue<Integer> pq = map.get(curr.vertical).get(curr.level);
                        pq.add(curr.node.val);
                        map.get(curr.vertical).put(curr.level, pq);
                    } else {
                        PriorityQueue<Integer> pq = new PriorityQueue<>();
                        pq.add(curr.node.val);
                        map.get(curr.vertical).put(curr.level, pq);
                    }
                } else {
                    TreeMap<Integer, PriorityQueue<Integer>> levelMap = new TreeMap<>();
                    PriorityQueue<Integer> pq = new PriorityQueue<>();
                    pq.add(curr.node.val);
                    levelMap.put(curr.level, pq);
                    map.put(curr.vertical, levelMap);
                }
                queue.remove();
            }
        }
        for (Map.Entry<Integer, TreeMap<Integer, PriorityQueue<Integer>>> entry : map.entrySet()) {
            List<Integer> miniRes = new ArrayList<>();
            for (Map.Entry<Integer, PriorityQueue<Integer>> insideEntry : entry.getValue().entrySet()) {
                while (!insideEntry.getValue().isEmpty()) {
                    miniRes.add(insideEntry.getValue().poll());
                }
                miniRes.addAll(insideEntry.getValue());
            }
            res.add(miniRes);
        }
        return res;
    }
}