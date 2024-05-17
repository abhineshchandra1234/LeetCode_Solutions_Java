/**
 * 1325. Delete Leaves With a Given Value
 * 
 * Intuition
 * 
 * we will try to recreate the tree using DFS
 * Call recursive func on root left and right child and assign thier return
 * values to left and right childs respectively.
 * Terminating cond - If the curr node is leaf ie left and right child is null
 * ie equal and curr node value is equal to the target return null else root
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n), visting each node once
 * 
 * Space complexity: O(n), height of recursive stack
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
    public TreeNode removeLeafNodes(TreeNode root, int target) {

        if (root.left != null)
            root.left = removeLeafNodes(root.left, target);
        if (root.right != null)
            root.right = removeLeafNodes(root.right, target);

        return root.left == root.right && root.val == target ? null : root;
    }
}