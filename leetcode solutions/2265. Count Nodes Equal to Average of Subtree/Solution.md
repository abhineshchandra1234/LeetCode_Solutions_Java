# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we will use recursion and post order traversal to solve this problem
- we will start calculating result from the leaf level and slowly proceed towards root level
- At every node considering it as root we will check if the node.val is equal to its subtree avg, if it is increase res.
- we do this by calculating currSum and currCount which will be equal to the left + right sum or count
```
    int currSum = left[0] + right[0] + node.val;
    int currCount = left[1] + right[1] + 1;
```

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity: `O(n)`
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: `O(n)`
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
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
    private int res;

    public int averageOfSubtree(TreeNode root) {
        res = 0;
        solve(root);
        return res;
    }

    private Pair<Integer, Integer> solve(TreeNode root) {
        if (root == null)
            return new Pair<>(0, 0);

        Pair<Integer, Integer> left = solve(root.left);
        Pair<Integer, Integer> right = solve(root.right);

        int leftSum = left.getKey();
        int leftCount = left.getValue();

        int rightSum = right.getKey();
        int rightCount = right.getValue();

        int sum = leftSum + rightSum + root.val;
        int count = leftCount + rightCount + 1;

        int avg = sum / count;

        if (avg == root.val)
            res++;

        return new Pair<>(sum, count);
    }
}
```