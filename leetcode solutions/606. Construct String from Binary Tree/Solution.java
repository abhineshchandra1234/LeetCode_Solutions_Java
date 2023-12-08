/**
 * 606. Construct String from Binary Tree
 * 
 * Intuition
 * 
 * we can easily solve this problem through recursion and DFS
 * Its structure will be same as preorder recursive func
 * we will follow the steps as given in the question to solve it
 * Case 1 If the root is itself null return an empty string
 * our base string will root.val + ""
 * Case 2 if the root left and right childs are null or empty strings return
 * base string
 * Case 3 if the root left child is null or empty string return root.val + () +
 * (root.right)
 * Case 4 if the root right child is null return root.val + (root.left)
 * if the above terminating conds doesnt satisfy we will return res +
 * (root.left) + (root.right)
 * 
 * Approach
 * Complexity
 * 
 * Time complexity:
 * 
 * O(n), we are visiting each node
 * 
 * Space complexity:
 * 
 * O(h), recursive call stack
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
    public String tree2str(TreeNode root) {

        if (root == null)
            return "";

        String res = root.val + "";

        String left = tree2str(root.left);
        String right = tree2str(root.right);

        if (left == "" && right == "")
            return res;
        if (left == "")
            return res + "()" + "(" + right + ")";
        if (right == "")
            return res + "(" + left + ")";
        return res + "(" + left + ")" + "(" + right + ")";
    }
}