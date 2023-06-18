//2583. Kth Largest Sum in a Binary Tree
/*
 * approach - 
 * we will solve this problem using min heap.
 * we will do level order traversal of the tree and store sum in heap.
 * to get kth largest sum we will keep heap size limited to k
 * At last if heap size is equal to k we will return the top element
 * else if heap size is less than k we will return -1
 * 
 * Time - O(nlogn)
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
    public long kthLargestLevelSum(TreeNode root, int k) {
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            long sum  = 0;
            while(size-->0) {
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            }
            pq.add(sum);
            if(pq.size()>k)
                pq.poll();
        }
        
        if(pq.size()<k)
            return -1;
        else
            return pq.poll();
    }
}