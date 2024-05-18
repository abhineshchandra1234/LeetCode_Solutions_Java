/**
 * 979. Distribute Coins in Binary Tree
 * 
 * Intuition
 * Given
 * 
 * There are n nodes and each node has some coins
 * There are n coins for whole tree
 * 
 * Target
 * 
 * min moves to make each node have 1 coin
 * 
 * Solution
 * 
 * If you are able to find your soln using your logic in dry run means you have
 * understood the algorithm required to solve the problem
 * we will solve this problem through DFS(post-order traversal)
 * From question it is clear that each node should have 1 coin as there are
 * total n coins
 * Excess coins for each node = node.val + left + right - 1
 * Each node will keep one coin for itself
 * If excess coins is positive means it has extra coins, if its negative means
 * it has less coins and need those many coins
 * 
 * Approach
 * 
 * each node will return excess coins to its parent
 * we will find excess coin in root left and right child and assign them to left
 * and right var
 * we will later add mod of left and right to res, as these many moves need to
 * be made from parent to left and right child to balance them
 * terminating cond is if root is null return 0 excess coins.
 * 
 * Note - We are not returning mod of excess coins for each node, as we need to
 * do further computation and positive and negative coins for a root or parent
 * will cancel each other out
 * 
 * Complexity
 * 
 * Time complexity: O(n), visiting each node once
 * 
 * Space complexity: O(n), O(h) height of recursive stack, binary tree generally
 * have n levels or childs for n nodes
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

    int res = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        res += Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1;
    }
}