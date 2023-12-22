/**
 * 1422. Maximum Score After Splitting a String
 * 
 * Intuition
 * 
 * we will first count ones
 * then we will traverse the string from left and update zeros and ones count
 * and update res with thier sum
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
    public int maxScore(String s) {

        int ones = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == '1')
                ones++;

        int ans = 0;
        int zeros = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1')
                ones--;
            else
                zeros++;

            ans = Math.max(ans, zeros + ones);
        }

        return ans;
    }
}