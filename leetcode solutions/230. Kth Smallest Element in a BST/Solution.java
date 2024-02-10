/**
 * 230. Kth Smallest Element in a BST
 * 
 * Intuition
 * 
 * I have used inorder template with slight modification to solve this problem
 * left most node will be the smallest
 * So we will just return kth smallest left node
 * Similar problem
 * 94. Binary Tree Inorder Traversal
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n), traversing each node through inorder
 * 
 * Space complexity: O(h), max nodes in stack is equal to height of the
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
    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> s = new Stack();
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if (--k == 0)
                break;
            root = root.right;
        }
        return root.val;
    }
}