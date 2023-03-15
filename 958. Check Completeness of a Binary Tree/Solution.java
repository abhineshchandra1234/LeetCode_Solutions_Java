/**
 * 958. Check Completeness of a Binary Tree
 * 
 * approach - 
 * we will solve this using bfs.
 * we will add nodes in queue till we encounter empty node.
 * A complete binary tree will not have any nodes after first empty node.
 * Then we will start poping all empty nodes from queue
 * At last we will return true if queue is empty else false.
 * 
 * Time - O(n)
 * Space - O(n)
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
    public boolean isCompleteTree(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList();
        q.add(root);

        while(q.peek()!=null) {
            TreeNode curr = q.poll();
            q.add(curr.left);
            q.add(curr.right);
        }

        while(!q.isEmpty() && q.peek()==null)
            q.poll();

        return q.isEmpty();
    }
}