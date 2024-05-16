/**
 * 2331. Evaluate Boolean Binary Tree
 * 
 * Intuition
 * 
 * we will use DFS to solve this problem
 * we will recursion to compute the res
 * if the node is 0 or 1, return its value
 * if the node is 2, perform or operation on recursive left node and right node
 * if the node is 3, perform and operation on recursive left node and right node
 * And the best way to compare values is a switch operation
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(h), traversing height of the tree in DFS
 * 
 * Space complexity: O(h), recursive stack length
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
    public boolean evaluateTree(TreeNode root) {

        switch (root.val) {
            case 0:
            case 1:
                return root.val == 1;
            case 2:
                return evaluateTree(root.left) || evaluateTree(root.right);
            default:
                return evaluateTree(root.left) && evaluateTree(root.right);
        }
    }
}