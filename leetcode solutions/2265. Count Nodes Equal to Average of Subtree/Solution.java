/**
 * 2265. Count Nodes Equal to Average of Subtree
 * 
 * Intuition
 * 
 * we will use recursion and post order traversal to solve this problem
 * we will start calculating result from the leaf level and slowly proceed
 * towards root level
 * At every node considering it as root we will check if the node.val is equal
 * to its subtree avg, if it is increase res.
 * we do this by calculating currSum and currCount which will be equal to the
 * left + right sum or count
 * 
 * int currSum = left[0] + right[0] + node.val;
 * int currCount = left[1] + right[1] + 1;
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
    int res = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return res;
    }

    private int[] dfs(TreeNode node) {
        if (node == null)
            return new int[] { 0, 0 };

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int currSum = left[0] + right[0] + node.val;
        int currCount = left[1] + right[1] + 1;

        if (currSum / currCount == node.val)
            res++;
        return new int[] { currSum, currCount };
    }
}