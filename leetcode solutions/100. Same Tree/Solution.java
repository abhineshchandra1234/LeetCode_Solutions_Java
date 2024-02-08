/**
 * 100. Same Tree
 * 
 * Intuition
 * 
 * credits deepankyadav
 * Base cond 1 - if both roots are null, ie leaf nodes, return true
 * Base cond 2 - If one of the roots is null or its value are not equal, return
 * false
 * Recursive cond - Pass both roots left subtrees and Pass both roots right
 * subtrees
 * if both left subtrees and right subtrees are same return true
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(min(p,q)), Min of nodes of p & q
 * 
 * Space complexity: O(min(hp,hq)), min of height of p
 * & q roots for recursive stack
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
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null)
            return true;
        if (p == null || q == null || p.val != q.val)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}