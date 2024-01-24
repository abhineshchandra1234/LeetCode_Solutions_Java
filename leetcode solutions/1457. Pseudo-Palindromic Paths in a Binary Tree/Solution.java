/**
 * 1457. Pseudo-Palindromic Paths in a Binary Tree
 * 
 * Intuition
 * 
 * credits lee215
 * For palindromic path max 1 element will have odd freq
 * we will traverse each node through dfs(preorder) traversal.
 * we will store freq of all nodes of a path using bitmask in count using xor
 * operation
 * so even freq will be 0 and odd freq will be 1
 * If we reach leaf node and count just have one 1 bit and rest as 0
 * which is suitable palindromic path
 * we will increase res
 * palindromic path(count) follows power of 2 as it will also have just one 1
 * bit.
 * 
 * Approach
 * 
 * count - 1, it flips the rightmost 1 bit to 0 and rest low bit 0 to 1
 * if count has just one 1 bit or palindromic path then (count & (count - 1)) ==
 * 0
 * the same is followed with power of 2 nos
 * 
 * here also digits are flipped and we get 0
 * 2&3 == 0, 4&3==0, 8&7==0, 16&15==0
 * 
 * Complexity
 * 
 * Time complexity: O(n), visiting each node once
 * 
 * Space complexity: O(h), recursive stack for tree
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
    public int pseudoPalindromicPaths(TreeNode root) {

        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int count) {
        if (root == null)
            return 0;
        // odd freq using xor
        count ^= 1 << root.val;
        int res = dfs(root.left, count) + dfs(root.right, count);
        // leaf node & palidromic path or power of 2
        if (root.left == root.right && (count & (count - 1)) == 0)
            res++;
        return res;
    }
}