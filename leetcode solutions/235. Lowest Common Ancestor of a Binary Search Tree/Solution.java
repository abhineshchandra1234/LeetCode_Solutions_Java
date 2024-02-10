/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * 
 * Intuition
 * 
 * credits StefanPochmann
 * we will treverse down from root to LCS till both p and q are in the same
 * subtree
 * ie both are smaller or larger than the root
 * 
 * Approach
 * 
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * root 6
 * both p & q is less than root and in left subtree
 * root 2
 * one is equal and another is greater, res is 2
 * if we move root to left or right we will not get LCS
 * 
 * Complexity
 * 
 * Time complexity: O(h), where h is the height of the tree
 * 
 * Space complexity: O(1), iterative approach
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - (long) p.val) * (root.val - (long) q.val) > 0)
            root = p.val < root.val ? root.left : root.right;
        return root;
    }
}