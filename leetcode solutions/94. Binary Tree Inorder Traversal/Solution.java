/**
 * 94. Binary Tree Inorder Traversal
 * 
 * Intuition
 * 
 * we can solve this using DFS and stack
 * we will traverse left -> root -> right
 * Inorder tree returns nos in ascending order in binary tree
 * 
 * Approach
 * 
 * we will run a loop till root is not null or stack is not empty
 * then we will add all left elements of root in the stack
 * then we will pop no from stack treat it as a root and add its val to res (it
 * will cover left and root)
 * then we will update root with root.right to traverse right tree
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */

//Code (Iterative)
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
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList();
        Stack<TreeNode> s = new Stack();
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}

// Code (Recursive)
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
    List<Integer> res = new ArrayList();

    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null)
            return;
        traverse(root.left);
        res.add(root.val);
        traverse(root.right);
    }
}