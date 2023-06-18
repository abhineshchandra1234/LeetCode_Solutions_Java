/**
 * 1312. Minimum Insertion Steps to Make a String Palindrome
 * 
 * Intuition
 * for palindrome take string as two strings
 * s1 - s , s2-> reverse(s)
 * If both are equal than it is palindrome
 * like s1 -> "zzazz" s2 -> "zzazz"
 * longest common subsequence in this is 5, we need to add 0 chars to make it
 * palindrome
 * s1 -> "mbadm" s2 -> "mdabm" lcs is 3, we need to add 5-3 = 2 chars to make it
 * palindrome.
 * we will use dp to solve this. dp[i][j] means length of longest common
 * subsequence for first i chars of s1 and first j chars of s2.
 * 
 * Approach
 * We run two loops to update dp bcs we are using top down approach and building
 * on top of prev result.
 * when chars of both string match we add 1 to prev res.
 * when it doesnt match we take max of two strings bcs either strings can make
 * longest subsequence and we need max for that range.
 * Refer 516. Longest Palindromic Subsequence for more info
 * Complexity
 * 
 * Time complexity:
 * O(n^2) - we are taking combinations of first i chars of s1 and first j chars
 * of s2.
 * 
 * Space complexity:
 * 
 * O(n^2)
 * Look at the dp size to understand t & s complexity
 */
class Solution {
    public int minInsertions(String s) {

        int n = s.length();
        // n+1 will store res of first n chars of string
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // i+1,j+1 is curr chars of s1 and s2
                // if both are equal add 1 to existing res
                // if not take max of existing res.
                dp[i + 1][j + 1] = s.charAt(i) == s.charAt(n - j - 1) ? dp[i][j] + 1
                        : Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }
        // dp[n][n] will contain length of longest subsequence
        return n - dp[n][n];
    }
}