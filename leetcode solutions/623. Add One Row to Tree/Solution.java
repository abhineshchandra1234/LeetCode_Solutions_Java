/**
 * 623. Add One Row to Tree
 * 
 * Intuition
 * 
 * we will solve this problem through BFS as we need to insert new nodes at a
 * level
 * If the depth is 1 we will create a new node add root to its left and return
 * it
 * If the depth is more than 1, we will use a var level and do bfs
 * when we reach level==depth-1, for every node at that level, we will create a
 * new left and right node.
 * For other levels we will simply add child nodes to queue
 * Then we will assign curr left and right child to new node, then assign new
 * node to curr node
 * Thats it finally return root.
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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        if (depth == 1) {
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }

        Queue<TreeNode> q = new LinkedList();
        q.add(root);

        int level = 0;
        while (!q.isEmpty()) {
            level++;
            int size = q.size();
            while (size-- > 0) {
                TreeNode curr = q.poll();
                if (level != depth - 1) {
                    if (curr.left != null)
                        q.add(curr.left);
                    if (curr.right != null)
                        q.add(curr.right);
                } else {
                    TreeNode newLeft = new TreeNode(val);
                    newLeft.left = curr.left;
                    curr.left = newLeft;

                    TreeNode newRight = new TreeNode(val);
                    newRight.right = curr.right;
                    curr.right = newRight;
                }
            }
        }

        return root;
    }
}