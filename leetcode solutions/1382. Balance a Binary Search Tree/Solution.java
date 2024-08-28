/**
 * 1382. Balance a Binary Search Tree
 * 
 * Intuition
 * 
 * given the root of a bst. we need to return a balanced bst.
 * we will first convert tree to a sorted array using recursive inorder
 * traversal
 * then we will convert sorted array to balanced bst using a recursive func
 * which takes mid as a root
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n), traversing each node once
 * 
 * Space complexity: O(n), recursive stack
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

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sortedElements = new ArrayList();
        InorderTraversal(root, sortedElements);
        return BalancedBst(sortedElements, 0, sortedElements.size() - 1);
    }

    private void InorderTraversal(TreeNode root, List<Integer> sortedElements) {

        if (root == null)
            return;

        InorderTraversal(root.left, sortedElements);
        sortedElements.add(root.val);
        InorderTraversal(root.right, sortedElements);
    }

    private TreeNode BalancedBst(List<Integer> sortedElements, int start, int end) {

        if (start > end)
            return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(sortedElements.get(mid));
        root.left = BalancedBst(sortedElements, start, mid - 1);
        root.right = BalancedBst(sortedElements, mid + 1, end);
        return root;
    }
}