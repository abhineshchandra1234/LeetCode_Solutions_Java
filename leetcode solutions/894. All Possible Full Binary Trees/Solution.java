/**
 * 894. All Possible Full Binary Trees
 * 
 * Intuition
 * 
 * The question ask us to return the no of full binary trees we can form using
 * diff combinations of n nodes.
 * a full binary tree will always have odd number of nodes root + even no of
 * child nodes.
 * In any full binary tree there will 1 root node and rest n-1 nodes will be
 * divided between left and right subtree.
 * we will place i nodes in the left subtree and n-1-i nodes in the right
 * subtree.
 * we will create a list of full binary tree for left and right subtree.
 * we will form a full binary tree by taking root(1-7) and diff combinations of
 * left,right
 * left and right subtree should have odd nodes, so left subtree will have nodes
 * 1,3,5 and right subtree will have nodes 5,3,1 for n=7.
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(2^n/2), for every node we have two choices left and right, and we have n/2
 * nodes 1,3,5,7.
 * 
 * Space complexity:
 * 
 * O(n*2^n/2),there can be 2^n/2 nodes for n nodes
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
    private Map<Integer, List<TreeNode>> memo = new HashMap();

    public List<TreeNode> allPossibleFBT(int n) {

        if (n % 2 == 0)
            return new ArrayList<TreeNode>();
        if (n == 1)
            return Arrays.asList(new TreeNode());
        if (memo.containsKey(n))
            return memo.get(n);

        List<TreeNode> res = new ArrayList();
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - 1 - i);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0, l, r);
                    res.add(root);
                }
            }
        }

        memo.put(n, res);
        return res;
    }
}