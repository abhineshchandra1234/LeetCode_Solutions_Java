/**
 * 124. Binary Tree Maximum Path Sum
 * 
 * Intuition
 * 
 * credits arkaung
 * we will solve this problem through DFS
 * Base cond if node is null return gain as 0
 * Recursive cond 1 Find max of gain on node.left and 0, as we do not want to
 * decrease gain by adding negative value
 * Recursive cond 2 Find max of gain of node.right and 0
 * Computation 1 Update currMaxPath, considering curr node as root by adding
 * nodes value and left gain and right gain
 * Computation 2 Update maxPath with max of currMaxPath
 * Return return sum of node.val and max of left gain and right gain, as path
 * can contain only left or right node
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n), we traverse each node once
 * 
 * Space complexity: O(h), recursive call stack is equal to height of
 * tree
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
    int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMaxGain(root);
        return maxPath;
    }

    private int getMaxGain(TreeNode node) {
        if (node == null)
            return 0;
        int gainOnLeft = Math.max(getMaxGain(node.left), 0);
        int gainOnRight = Math.max(getMaxGain(node.right), 0);

        int currMaxPath = node.val + gainOnLeft + gainOnRight;
        maxPath = Math.max(maxPath, currMaxPath);

        return node.val + Math.max(gainOnLeft, gainOnRight);
    }
}