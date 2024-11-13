/**
 * 2641. Cousins in Binary Tree II
 * 
 * Intuition
 * we can solve this problem through BFS
 * we need to calculate sums for each level
 * Then for every root, child values will be assigned as level + 1 sum -
 * siblings sum == cousins sum
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
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
    public TreeNode replaceValueInTree(TreeNode root) {

        Queue<TreeNode> q = new LinkedList();
        q.add(root);

        List<Integer> levelSums = new ArrayList();

        while (!q.isEmpty()) {
            int levelSum = 0;
            int size = q.size();
            while (size-- > 0) {
                TreeNode curr = q.poll();
                levelSum += curr.val;
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
            levelSums.add(levelSum);
        }

        q.add(root);
        int levelIndex = 1;
        root.val = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode curr = q.poll();

                int sibling = (curr.left != null ? curr.left.val : 0) +
                        (curr.right != null ? curr.right.val : 0);

                if (curr.left != null) {
                    curr.left.val = levelSums.get(levelIndex) - sibling;
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    curr.right.val = levelSums.get(levelIndex) - sibling;
                    q.add(curr.right);
                }
            }
            levelIndex++;
        }
        return root;
    }
}