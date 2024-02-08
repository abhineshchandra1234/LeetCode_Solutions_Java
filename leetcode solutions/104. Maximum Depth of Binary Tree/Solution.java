/**
 * 104. Maximum Depth of Binary Tree
 * 
 * Intuition
 * 
 * credits sukhseeratkaur0226
 * we can solve this problem through DFS and BFS
 * Through DFS base condtion if root is null then return 0
 * At last return max depth of left and right subtree + 1
 * return Math.max(maxLeft, maxRight) + 1
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n), traversing each node once
 * 
 * Space complexity: O(h), recursive stack is height of the tree
 * 
 */

//DFS
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
    public int maxDepth(TreeNode root) {

        if (root == null)
            return 0;
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);
        return Math.max(maxLeft, maxRight) + 1;
    }
}

// BFS
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
    public int maxDepth(TreeNode root) {

        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return count;
    }
}