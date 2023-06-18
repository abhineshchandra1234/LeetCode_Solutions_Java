/**
 * 129. Sum Root to Leaf Numbers
 * 
 * approach - 
 * we will solve using preorder traversal using recursion, bcs we need sum to include root.
 * we will calculate sum at every node, by multiplying prev sum by 10 and adding curr value
 * if the curr node is child node we will add the sum to total
 * then we will pass the sum to childs of the root.
 * Finally return total.
 * 
 * Time - O(n)
 * Space - O(1)
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int total = 0;
    public int sumNumbers(TreeNode root) {
        
        helper(root,0);
        return total;
    }

    public void helper(TreeNode root,int sum) {

        if(root==null)
            return;
        sum = sum*10 + root.val;
        if(root.left==null && root.right==null) {
            total += sum;
            return;
        }
        helper(root.left,sum);
        helper(root.right,sum);
    }
}