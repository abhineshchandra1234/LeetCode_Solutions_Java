/**
 * 1614. Maximum Nesting Depth of the Parentheses
 * 
 * Intuition
 * 
 * Since string is a VPS, no of open brackets will be equal to close brackets
 * So Depth will be equal to max no of open brackets, brackets not in scope will
 * cancel each other out.
 * 
 * Approach 2 (stack)
 * 
 * the same principal will be followed in case of stack
 * we will push '(' to stack, and when we encounter ')' we will pop '('
 * we will update res for every char with max of stack size which represent no
 * of '('
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int maxDepth(String s) {

        int res = 0, curr = 0;

        for (char c : s.toCharArray()) {
            if (c == '(')
                res = Math.max(res, ++curr);
            else if (c == ')')
                curr--;
        }
        return res;
    }
}