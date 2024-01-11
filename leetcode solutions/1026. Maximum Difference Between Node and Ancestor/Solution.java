/**
 * 1026. Maximum Difference Between Node and Ancestor
 * 
 * Intuition
 * 
 * credits lee215
 * We will solve this problem through DFS
 * Maximum difference will be the difference between root and leaf nodes
 * So we will pass max and min to children and at leaf node we will return diff
 * between max & min through the path from root to leaf.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n), visiting each node once
 * 
 * Space complexity: O(h), recursive stack is equal to height of the
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
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    public int dfs(TreeNode root, int max, int min) {
        if (root == null)
            return max - min;
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        return Math.max(dfs(root.left, max, min), dfs(root.right, max, min));
    }
}