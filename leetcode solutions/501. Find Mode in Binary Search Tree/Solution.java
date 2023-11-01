/**
 * 501. Find Mode in Binary Search Tree
 * 
 * Intuition
 * 
 * First Approach
 * we traverse the tree using dfs or bfs. Then find max freq. Then add elements
 * matching that freq to result.
 * It requires alot of work, so avoiding it
 * T - O(n), S - O(n)
 * Second Approach
 * we do inorder traversal of the tree to get sorted list and find no with
 * highest freq while traversing
 * we do this by calculating maxStreak of each no
 * if currStreak of a no is greater then maxStreak then we reset the res list
 * and maxStreak value.
 * if currStreak is equal to maxStreak then we simply add no to res.
 * if the no is equal to currStreak then increase currStreak.
 * If the no is unique assign 1 to currStreak and reset currNum to no.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
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
    int maxStreak = 0;
    int currStreak = 0;
    int currNum = 0;
    List<Integer> ans = new ArrayList();

    public int[] findMode(TreeNode root) {
        inorder(root);

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }

    private void inorder(TreeNode root) {
        TreeNode curr = root;
        Stack<TreeNode> s = new Stack();

        while (curr != null || s.size() > 0) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            helper(curr.val);
            curr = curr.right;
        }
    }

    private void helper(int num) {
        if (num == currNum)
            currStreak++;
        else {
            currStreak = 1;
            currNum = num;
        }
        if (currStreak > maxStreak) {
            ans = new ArrayList();
            maxStreak = currStreak;
        }
        if (currStreak == maxStreak)
            ans.add(num);
    }
}