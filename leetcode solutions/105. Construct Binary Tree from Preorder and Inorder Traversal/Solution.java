/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * 
 * Intuition
 * 
 * we will solve this problem through DFS(pre-order) recursion
 * we can get root from preorder
 * using this root index in inorder we can get no of elements in the left
 * subtree
 * 
 * preorder
 * i -> root
 * i+1 -> root.left
 * numsLeft = inRoot - inStart (inorder)
 * i+numsLeft+1 -> root.right
 * 
 * caching indicies of elements of inorder as we need to calculate numsLeft for
 * every root.
 * 
 * Approach
 * 
 * we are using two ptrs each for inorder and preorder to traverse it
 * Base cond 1 - if two ptrs of inorder and preorder cross each other we have
 * computed that subtree
 * we will calculate root and numsleft
 * then call dfs for root.left and root.right, for preorder index of i+1 and
 * i+numsLeft+1
 * 
 * Complexity
 * 
 * Time complexity: O(n), we are traversing each node using
 * dfs(pre-order)
 * 
 * Space complexity: O(n), we are cahing indices for inorder elements
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
    Map<Integer, Integer> inMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // caching inorder nos & their indices
        inMap = new HashMap();
        for (int i = 0; i < inorder.length; i++)
            inMap.put(inorder[i], i);

        // creating tree and returning its root
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd,
            int[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd);

        return root;
    }
}