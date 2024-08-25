/**
 * 145. Binary Tree Postorder Traversal
 * 
 * Intuition
 * we are given the root of the binary tree, we need to return the postorder
 * traversal of its value
 * we can modify pre-order traversal to solve this problem
 * in pre-order we used to visit root -> left -> right
 * here we can visit root -> right -> left and later reverse it to get our
 * desired res of left -> right -> root
 * 
 * Approach
 * we will first add root to the stack, then move to its right child
 * once we reach leaf node, we will pop the curr node and move to its left child
 * 
 * Complexity
 * Time complexity: O(n), traversing all nodes
 * Space complexity: O(n), using stack to store nodes
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

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList();

        Stack<TreeNode> s = new Stack();

        while (root != null || !s.isEmpty()) {

            if (root != null) {
                res.add(root.val);
                s.add(root);
                root = root.right;
            } else {
                root = s.pop();
                root = root.left;
            }
        }

        Collections.reverse(res);
        return res;
    }
}