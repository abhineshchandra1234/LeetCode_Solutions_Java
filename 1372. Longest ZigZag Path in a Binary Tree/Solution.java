/**
 * 1372. Longest ZigZag Path in a Binary Tree
 * 
 * Intuition
 * We will solve this using dfs
 * We will pass next direction and currLen to each node
 * We will update maxLen with currLen
 * We will pass currLen+1 and opposite dir to opposite directed node. In case of
 * opposite directed node it is increasing the currLen
 * We will pass 1 as currLen and same dir to same directed node. In case of same
 * directed node it is reseting the path so we pass 1 as currLen
 * 
 * Approach
 * We can arrive at root from left or from right since it has no parents, so
 * called dfs for both dir
 * Inside the helper func updating maxLen with curr len
 * If the dir is right passing currLen as currLen+1 to left node and 1 to right
 * node. passing left dir to left node and right dir to right node ie dir used
 * to reach them.
 * If the dir is left passing currLen as currLen+1 to the right node and 1 to
 * the left node. passing right dir to right node and left dir to left node ie
 * dir used to reach them.
 * 
 * Complexity
 * Time complexity:
 * O(n) -> we are reaching each node once
 * 
 * Space complexity:
 * O(h) -> for dfs operation
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
    public int maxLen = 0;

    public int longestZigZag(TreeNode root) {

        dfs(root, 0, 0);
        dfs(root, 1, 0);
        return maxLen;
    }

    public void dfs(TreeNode root, int dir, int currLen) {
        if (root == null)
            return;
        maxLen = Math.max(maxLen, currLen);
        if (dir == 1) {
            dfs(root.left, 0, currLen + 1);
            dfs(root.right, 1, 1);
        } else {
            dfs(root.right, 1, currLen + 1);
            dfs(root.left, 0, 1);
        }
    }
}