/**
 * 951. Flip Equivalent Binary Trees
 * 
 * Intuition
 * the description is confusing for root2, in this we can do more flips to make
 * it equivalent to root1
 * we will solve this problem through recursion
 * terminating cond1 will be if both roots are not equal return false
 * terminating cond2 will be if both roots values are not equal return false
 * base cond 1, check if both roots left and right childs are equal
 * base cond 2, flip left and right childs and see if they are equal
 * At last return or of base cond1 and base cond2, means childs are equal with
 * or without flip
 * Approach
 * 
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
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

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;

        if (root1.val != root2.val)
            return false;

        boolean noSwap = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        boolean swap = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);

        return noSwap || swap;
    }
}