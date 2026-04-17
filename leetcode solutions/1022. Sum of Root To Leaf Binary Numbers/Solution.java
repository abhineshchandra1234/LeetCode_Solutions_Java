// 1022. Sum of Root To Leaf Binary Numbers

/**
 * Intuition
 * we will solve this problem through recursion
 * we will have two base conditions
 * if root is null return 0
 * if the root has no child return val
 * when we add any bit, curr no will left shift so its val will multiply by 2
 * and we are adding curr bit val
 * then we are calling recursion on left and right childs and returning its sum
 * Approach
 * 
 * Complexity
 * Time complexity: O(n), traversing each node
 * Space complexity: O(h), recursion stack
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
    public int sumRootToLeaf(TreeNode root) {
        return solve(root, 0);
    }

    private int solve(TreeNode root, int val) {
        if (root == null)
            return 0;
        val = (2 * val) + root.val;
        if (root.left == null & root.right == null)
            return val;
        return solve(root.left, val) + solve(root.right, val);
    }
}