/**
 * 226. Invert Binary Tree
 * 
 * Intuition
 * 
 * credits jmnarloch
 * we will solve this problem using DFS
 * Base cond 1 - If the root is null return null, leaf nodes
 * Recursive cond 1 - Assign inverted right subtree to root.left
 * Recursive cond 2 - Assign inverted left subtree to root.right
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n), we are traversing each node once
 * 
 * Space complexity: O(h), recursive stack is equal to height of the
 * tree
 * 
 */

//DFS
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
    public TreeNode invertTree(TreeNode root) {

        if (root == null)
            return null;

        TreeNode left = root.left, right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
}

// BFS
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
    public TreeNode invertTree(TreeNode root) {

        if (root == null)
            return null;

        Queue<TreeNode> q = new LinkedList();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode node = q.poll();
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;

                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
        }
        return root;
    }
}