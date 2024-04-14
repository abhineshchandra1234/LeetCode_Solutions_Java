/**
 * 404. Sum of Left Leaves
 * 
 * Intuition
 * 
 * As evident in the question we can solve this problem through dfs (recursion)
 * Terminating cond - If root is null return or add 0 to res
 * Favourable cond 1 - If root has non-null left nodes with no childs, then we
 * can add its value to res and then we also need to add dfs of right node to
 * res
 * In case any left leave is present in right node.
 * Favourable cond 2 - If left nodes has childs then we can take sum of dfs of
 * left node plus dfs of right node
 * 
 * Approach
 * 
 * If you want to reduce complexity of dfs for checking child nodes childs, then
 * we can use a boolean var isLeft
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */

// Code 1
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
    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null)
            return 0;
        if (root.left != null && root.left.left == null
                && root.left.right == null)
            return root.left.val + sumOfLeftLeaves(root.right);

        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}

// Code 2
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
    public int sumOfLeftLeaves(TreeNode root) {

        return dfs(root, false);
    }

    private int dfs(TreeNode root, boolean isLeft) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return isLeft ? root.val : 0;
        return dfs(root.left, true) + dfs(root.right, false);
    }
}