/**
 * 678. Valid Parenthesis String
 * 
 * Intuition
 * Approach 1 (Two pointers)
 * 
 * we can solve this problem using two ptrs, one will point to start and other
 * will point to end
 * Both ptrs will move at same pace by 1
 * if we encounter open bracket or asterik using start ptr, increase open count
 * else decrease open count
 * if we encounter close bracket or asterik using end ptr, increase close count
 * else decrease close count
 * we do this so that open bracket, close bracket and asterik could cancel each
 * other out
 * if open bracket and close bracket count is still less than 0, return false,
 * as the brackets in scope are already cancelled above including those of
 * asterik
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
    public boolean checkValidString(String s) {

        int openC = 0, closeC = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '*')
                openC++;
            else
                openC--;
            char d = s.charAt(n - 1 - i);
            if (d == ')' || d == '*')
                closeC++;
            else
                closeC--;

            // '*', '(' & ')' are already canceling each other out
            if (openC < 0 || closeC < 0)
                return false;
        }
        return true;
    }
}