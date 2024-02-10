/**
 * 98. Validate Binary Search Tree
 * 
 * Intuition
 * 
 * credits issac3
 * we will do inorder traversal of tree
 * Considering each node as root
 * check if left node ie prev is less than root
 * check if root ie prev is less than right
 * 
 * Approach

    similar problems with minor changes
        Binary Tree Inorder Traversal
        Kth Smallest Element in a BST

 * Complexity
 * 
 * Time complexity: O(n), traversing each node using inorder traversal
 * 
 * Space complexity: O(h), max nodes in stack is height of tree
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
    public boolean isValidBST(TreeNode root) {

        Stack<TreeNode> s = new Stack();
        TreeNode prev = null;
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if (prev != null && root.val <= prev.val)
                return false;
            prev = root;
            root = root.right;
        }
        return true;
    }
}