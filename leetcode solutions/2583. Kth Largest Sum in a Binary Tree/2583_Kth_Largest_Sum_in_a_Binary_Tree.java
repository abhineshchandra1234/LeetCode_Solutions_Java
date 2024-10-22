/**
 * 2583. Kth Largest Sum in a Binary Tree
 * 
 * Intuition
 * we can solve this problem using BFS and min heap
 * we require min heap, to check the no of labels
 * min heap will store all the sums of the level
 * Approach
 * 
 * 
 * Complexity
 * Time complexity: O(n)*log(k), traversing n nodes and k nodes adjusting in
 * heap
 * Space complexity: O(n), adding all nodes to queue
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

    public long kthLargestLevelSum(TreeNode root, int k) {

        PriorityQueue<Long> pq = new PriorityQueue();

        Queue<TreeNode> q = new LinkedList();

        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();
            long sum = 0;
            while (size-- > 0) {
                TreeNode curr = q.poll();
                sum += curr.val;
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
            pq.add(sum);
            if (pq.size() > k)
                pq.poll();
        }

        if (pq.size() < k)
            return -1;
        return pq.peek();
    }
}