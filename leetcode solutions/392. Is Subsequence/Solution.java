/**
 * 392. Is Subsequence
 * 
 * Intuition
 * 
 * credits mageshyt
 * As it is visible in the question
 * we will parse t string and see s string first char matches in t if it does
 * increase subsequence count and move to next char of s
 * At last if the subsequence count is equal to s length, we got our res.
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
    public boolean isSubsequence(String s, String t) {

        if (s.length() > t.length())
            return false;
        if (s.length() == 0)
            return true;
        int subsequence = 0;
        for (int i = 0; i < t.length(); i++) {
            if (subsequence >= s.length())
                break;
            if (s.charAt(subsequence) == t.charAt(i))
                subsequence++;
        }
        return subsequence == s.length();
    }
}