/**
 * 102. Binary Tree Level Order Traversal
 * 
 * Intuition
 * 
 * we will use queue to do BFS
 * we will add nodes at each level to temp list and at the end of the level, add
 * the temp list to res
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n), traversing each node once
 * 
 * Space complexity: O(n), storing nodes in queue
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();

        if (root == null)
            return res;

        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList();
            while (size-- > 0) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            res.add(level);
        }
        return res;
    }
}