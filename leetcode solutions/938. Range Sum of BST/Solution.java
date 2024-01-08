/**
 * 938. Range Sum of BST
 * 
 * Intuition
 * 
 * In BST left node is strictly decreasing and right node is strictly increasing
 * than parent node
 * we will traverse nodes level wise and discard subtrees not in range to
 * optimize computation
 * if parent node value <= L then its left child will be discarded as thier
 * value will be even lesser
 * if parent node value >= R then its right child will be discarded as thier
 * value will be even more
 * Then we will simply check if node value is in the range to add curr node
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n), n is the no of nodes
 * 
 * Space complexity: O(h), h is the height of the tree
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
    public int rangeSumBST(TreeNode root, int low, int high) {

        Stack<TreeNode> s = new Stack();
        s.push(root);
        int sum = 0;
        while (!s.isEmpty()) {
            TreeNode n = s.pop();
            if (n == null)
                continue;
            if (n.val > low)
                s.push(n.left);
            if (n.val < high)
                s.push(n.right);
            if (low <= n.val && n.val <= high)
                sum += n.val;
        }
        return sum;
    }
}