/**
 * 129. Sum Root to Leaf Numbers
 * 
 * Intuition
 * 
 * we will solve this problem through dfs
 * As evident in the question, we will calculate curr sum at each node and pass
 * that sum to child nodes
 * we will return total of sums returned by left and right child nodes
 * curr sum = prev sum * 10 + node.val, prev sum will be 0 for root node
 * 
 * Approach
 * 
 * Terminating cond 1 - If root or curr node is null return sum as 0
 * Terminating cond 2 - If curr node has no child return the curr sum
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(h), recursive stack
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
    public int sumNumbers(TreeNode root) {

        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int pSum) {
        if (root == null)
            return 0;
        int sum = pSum * 10 + root.val;
        if (root.left == null && root.right == null)
            return sum;
        return dfs(root.left, sum) + dfs(root.right, sum);
    }
}