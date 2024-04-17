/**
 * 988. Smallest String Starting From Leaf
 * 
 * Intuition
 * 
 * we will solve this problem through dfs
 * we will add curr node to path
 * if the curr node is leaf, then we will check reversed path with res, if
 * reversed path is lexicographically smaller than the res
 * we will assign reversed path to res
 * Then we will again reverse the path for futher dfs
 * we will call dfs on left and right child
 * we will reduce path length by 1 for backtracking
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
    public String smallestFromLeaf(TreeNode root) {

        StringBuilder path = new StringBuilder();
        StringBuilder res = new StringBuilder();
        dfs(root, path, res);
        return res.toString();
    }

    private void dfs(TreeNode root, StringBuilder path, StringBuilder res) {

        if (root == null)
            return;

        path.append((char) ('a' + root.val));
        if (root.left == null && root.right == null) {
            String curr = path.reverse().toString();
            if (res.length() == 0 || curr.compareTo(res.toString()) < 0) {
                res.setLength(0);
                res.append(curr);
            }
            path.reverse();
        }

        dfs(root.left, path, res);
        dfs(root.right, path, res);

        path.setLength(path.length() - 1);
    }
}