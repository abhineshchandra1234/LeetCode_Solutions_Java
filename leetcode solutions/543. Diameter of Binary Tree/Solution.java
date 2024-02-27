/**
 * 543. Diameter of Binary Tree
 * 
 * Intuition
 * 
 * credits shawngao
 * we will solve this problem through DFS through recursion
 * longest path for every node = max depth of left subtree + max depth of right
 * subtree
 * 
 * Approach
 * 
 * Term cond 1 - If the root is null return 0
 * Term cond 2 - For every node return max of (left depth and right depth) + 1
 * Recur cond 1 - calculate left depth by passing root.left
 * Recur cond 2 - calculate right depth by passing root.right
 * Computation - Update max with max of leftDepth + rightDepth
 * 
 * Complexity
 * 
 * Time complexity: O(n), visiting each node once
 * 
 * Space complexity: O(h), recursive stack is equal to height of tree
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

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        max = Math.max(max, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}