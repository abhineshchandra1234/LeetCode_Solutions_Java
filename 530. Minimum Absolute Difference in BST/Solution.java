/**
 * 530. Minimum Absolute Difference in BST
 * 
 * Intuition
 * 
 * credits shawngao
 * we can solve this problem using DFS (inorder traversal).
 * When we do DFS of bst it returns an sorted list.
 * to get min absolute diff between any two nodes. We need diff of consecutive
 * nodes.
 * 
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
    public int getMinimumDifference(TreeNode root) {

        int min = Integer.MAX_VALUE;
        Integer prev = null;
        Stack<TreeNode> s = new Stack();
        TreeNode curr = root;

        while (curr != null || s.size() > 0) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            if (prev != null)
                min = Math.min(min, curr.val - prev);
            prev = curr.val;
            curr = curr.right;
        }

        return min;
    }
}