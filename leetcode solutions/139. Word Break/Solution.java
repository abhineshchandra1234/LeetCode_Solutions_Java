/**
 * 139. Word Break
 * 
 * Intuition
 * 
 * we will solve this problem using dp
 * dp will have one state boolean representing index of string ends at a word or
 * not.
 * For every index it will check if the substring between last found indexes and
 * curr index exist in dict or not
 * if it does mark the curr index as true and break the loop to check other
 * index.
 * We will get the res at the index equal to length of the string
 * 
 * Approach
 * 
 * to start the process dp[0] will be true.
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(n*m*k), there are n states in dp for each state we traverse through m words
 * in the dict and do k substring operations for each state
 * 
 * k is avg length of word in dict. m is length of dict, n is length of s.
 * 
 * Space complexity:
 * 
 * O(n)
 * 
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}