/**
 * 1609. Even Odd Tree
 * 
 * Intuition
 * 
 * we will solve this problem through BFS
 * we will start level at 0 and check at each level
 * if level is even then nos are even or strictly decreasing return false
 * if level is odd then nos are odd or strictly increasing return true
 * prev value will be created at each level,
 * if the level is even it will have min value for strictly increasing
 * if the level is odd it will have max value for strictly decreasing
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n), traversing each node once
 * 
 * Space complexity: O(n), storing node in queue
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
    public boolean isEvenOddTree(TreeNode root) {

        Queue<TreeNode> q = new LinkedList();
        int level = 0;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int prev = level % 2 == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            while (size-- > 0) {

                TreeNode node = q.poll();

                if ((level % 2 == 0 && (node.val % 2 == 0 || node.val <= prev)) ||
                        (level % 2 == 1 && (node.val % 2 == 1 || node.val >= prev)))
                    return false;

                if (node.left != null)
                    q.add(node.left);

                if (node.right != null)
                    q.add(node.right);

                prev = node.val;
            }
            level++;
        }
        return true;
    }
}