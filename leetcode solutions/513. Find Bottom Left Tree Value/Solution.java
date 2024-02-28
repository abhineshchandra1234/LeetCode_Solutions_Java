/**
 * 513. Find Bottom Left Tree Value
 * 
 * Intuition
 * 
 * credits StefanPochmann
 * we will solve this problem through right-to-left BFS, and returning last node
 * This way we do not need to track first node in curr row or track any rows
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n), visiting each node once
 * 
 * Space complexity: O(n), saving n nodes to queue
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
    public int findBottomLeftValue(TreeNode root) {

        Queue<TreeNode> q = new LinkedList();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                root = q.poll();
                if (root.right != null)
                    q.add(root.right);
                if (root.left != null)
                    q.add(root.left);
            }
        }
        return root.val;
    }
}