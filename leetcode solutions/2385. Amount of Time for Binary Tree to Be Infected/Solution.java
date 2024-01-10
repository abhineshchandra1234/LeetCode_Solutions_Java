/**
 * 2385. Amount of Time for Binary Tree to Be Infected
 * 
 * Intuition
 * 
 * Infection is starting from start node and proceeding level by level in all
 * directions
 * So we will simply construct a graph for all nodes, then do a BFS from start
 * node
 * Total time will be equal to no of levels
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    private Map<Integer, List<Integer>> adjacencyList = new HashMap();

    public int amountOfTime(TreeNode root, int start) {
        convertToGraph(root);
        Queue<Integer> q = new LinkedList();
        Set<Integer> v = new HashSet();

        q.add(start);
        int time = -1;

        while (!q.isEmpty()) {
            time++;
            int size = q.size();
            while (size-- > 0) {
                int curr = q.poll();
                v.add(curr);

                if (adjacencyList.containsKey(curr))
                    for (int neigh : adjacencyList.get(curr))
                        if (!v.contains(neigh))
                            q.add(neigh);
            }
        }
        return time;
    }

    private void convertToGraph(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null) {
            adjacencyList.computeIfAbsent(root.val, k -> new ArrayList()).add(root.left.val);
            adjacencyList.computeIfAbsent(root.left.val, k -> new ArrayList()).add(root.val);
        }
        if (root.right != null) {
            adjacencyList.computeIfAbsent(root.val, k -> new ArrayList()).add(root.right.val);
            adjacencyList.computeIfAbsent(root.right.val, k -> new ArrayList()).add(root.val);
        }
        convertToGraph(root.left);
        convertToGraph(root.right);
    }
}