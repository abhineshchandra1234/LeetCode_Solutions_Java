/**
 * 95. Unique Binary Search Trees II
 * 
 * Intuition
 * 
 * credits liaison
 * we will solve this problem using recursion and dynamic programming
 * for n = 3
 * res will be equal to sum of binary trees created by taking 1, 2 & 3 as root.
 * 1 - [1,null,2,null,3],[1,null,3,2]
 * 2 - [2,1,3]
 * 3 - [3,1,null,null,2],[3,2,null,1]
 * total subtrees is 5
 * 
 * Approach
 * 
 * we can dry run this for n =3.
 * 1 -> l = [1,0], r= [2,3];
 * l = [1,0] -> null
 * r = [2,3] -> taking 2 as root [2,n,3], taking 3 as root [3,2,n]
 * therefore 1 = [1,null,2,null,3],[1,null,3,2]
 * do the same for 2,3 to get total res.
 * since states like [1,0],[2,3] can be repeating we are using memoization.
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * It is difficult to derive time & space complexity
 * 
 * O(3^n), for each node we are running three loops
 * 
 * Space complexity:
 * 
 * O(3^n), recursive call stack, dp also has 3 states
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
    public List<TreeNode> generateTrees(int n) {
        Map<Pair<Integer, Integer>, List<TreeNode>> memo = new HashMap();
        return generateSubtrees(1, n, memo);
    }

    private List<TreeNode> generateSubtrees(int s, int e,
            Map<Pair<Integer, Integer>, List<TreeNode>> memo) {
        List<TreeNode> res = new LinkedList<TreeNode>();
        if (s > e) {
            res.add(null);
            return res;
        }
        if (memo.containsKey(new Pair<>(s, e)))
            return memo.get(new Pair<>(s, e));

        for (int i = s; i <= e; i++) {
            List<TreeNode> leftSubtrees = generateSubtrees(s, i - 1, memo);
            List<TreeNode> rightSubtrees = generateSubtrees(i + 1, e, memo);

            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i, left, right);
                    res.add(root);
                }
            }
        }
        memo.put(new Pair<>(s, e), res);
        return res;
    }
}