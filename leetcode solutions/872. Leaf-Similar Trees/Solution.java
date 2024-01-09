/**
 * 872. Leaf-Similar Trees
 * 
 * Intuition
 * 
 * we will do dfs to solve this problem
 * here we are doing pre-order traversal using recursion root->left->right
 * we will first process root, if its left and right child are null. we will add
 * its value to the list
 * we will then call recursion on root left and right childs
 * At last we will compare two lists for two roots, if they are equal we will
 * return true else false.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> leaves1 = new ArrayList();
        List<Integer> leaves2 = new ArrayList();
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    private void dfs(TreeNode node, List<Integer> leafValues) {

        if (node == null)
            return;
        if (node.left == null && node.right == null)
            leafValues.add(node.val);
        dfs(node.left, leafValues);
        dfs(node.right, leafValues);
    }
}