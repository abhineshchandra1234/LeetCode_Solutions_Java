/**
 * 101. Symmetric Tree
 * 
 * iterative approach - 
 * we will use bfs to solve this.
 * we will initially push root.left and root.right to queue
 * The logic is we are adding left and right nodes to queue.
 * Then checking if they are equal if they are not return false
 * else we will add thier left and right nodes to queue and continue checking them
 * At the end of loop return true means we didnt find asymmetric node in whole tree.
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
    public boolean isSymmetric(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList();
        q.add(root.left);
        q.add(root.right);

        while(!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left==null && right==null)
                continue;
            else if(left==null || right==null || left.val!=right.val)
                return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }
}