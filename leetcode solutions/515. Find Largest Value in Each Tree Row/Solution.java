/**
 * 515. Find Largest Value in Each Tree Row
 * 
 * Intuition
 * 
 * As it is visible in the question we will can solve it easily using bfs
 * At each level take var max as -infinity and update it with curr level nodes
 * value
 * At the end of the level add max to res.
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
    public List<Integer> largestValues(TreeNode root) {

        List<Integer> res = new ArrayList();

        if (root == null)
            return res;

        Queue<TreeNode> q = new LinkedList();
        q.add(root);

        while (!q.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = q.size();
            while (size-- > 0) {
                TreeNode node = q.poll();
                max = Math.max(max, node.val);

                if (node.left != null)
                    q.add(node.left);

                if (node.right != null)
                    q.add(node.right);
            }
            res.add(max);
        }

        return res;
    }
}