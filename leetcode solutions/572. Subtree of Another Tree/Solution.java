/**
 * 572. Subtree of Another Tree
 * 
 * Intuition
 * 
 * credits shawngao
 * we will do pre-order or dfs traversal of nodes
 * We will first check roots, if they are equal return true
 * Else we will call recursive function to check root.left or root.right is
 * equal to other sub tree
 * We will be using isSame helper recursive function to compare two trees using
 * roots.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n), traversing each node through pre-order or dfs
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null)
            return false;

        // pre-order or dfs traversal
        // check root is same as subRoot
        if (isSame(root, subRoot))
            return true;
        // check root.left & subroot or root.right & subroot
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSame(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null)
            return true;
        if (root == null || subRoot == null)
            return false;
        if (root.val != subRoot.val)
            return false;
        return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
    }
}