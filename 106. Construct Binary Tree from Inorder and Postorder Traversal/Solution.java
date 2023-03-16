/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * 
 * approach -
 * inorder -> left-root-right
 * postorder -> left-right-root
 * we will get root from last index of postorder array
 * we can use this root index in inorder to find no of left and right nodes
 * we use recursion to solve this
 * we will make the last no of postorder as root.
 * then we will find root.left and root.right by calling the helper function.
 * In the helper function we will pass the correct range of inorder and postorder using root index in inorder.
 * The trick here is to pass the correct range based on no of nodes
 * 
 * Time - O(n)
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
    Map<Integer,Integer> m = new HashMap();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        for(int i=0;i<inorder.length;i++)
            m.put(inorder[i],i);
        int n = inorder.length;
        return helper(inorder,0,n-1,postorder,0,n-1);
    }

    private TreeNode helper(int[] inorder,int is,int ie,int[] postorder,int ps,int pe) {
        if(is>ie || ps>pe)
            return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int ri = m.get(postorder[pe]);
        root.left = helper(inorder,is,ri-1,postorder,ps,ps+ri-is-1);
        root.right = helper(inorder,ri+1,ie,postorder,ps+ri-is,pe-1);
        return root;
    }
}