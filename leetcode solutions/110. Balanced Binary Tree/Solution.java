// 110. Balanced Binary Tree

/**
 * Intuition
 * we will solve this using recursion
 * if curr node is null, return true, first base case
 * Find left and right height, by calling recursion on curr.left and curr.right
 * Check if difference of left and right height is more than 1, if it is return
 * false
 * check curr.left and curr.right is balanced
 * Approach
 * 
 * Complexity
 * Time complexity: O(n^2), we are calling recursion on every node and then
 * calling height on each node
 * Space complexity: O(h), max height of tree will be in call stack
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
    public boolean isBalanced(TreeNode root) {

        if (root == null)
            return true;

        int leftH = height(root.left);
        int rigH = height(root.right);

        if (Math.abs(leftH - rigH) > 1)
            return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if (root == null)
            return 0;
        int leftH = height(root.left);
        int rigH = height(root.right);

        return Math.max(leftH, rigH) + 1;
    }
}