/**
 * 516. Longest Palindromic Subsequence
 * 
 * Intuition
 * We will solve this using dp
 * dp[i,j] represents longest palindromic subsequence for substring(i,j)
 * Therefore we will get our answer at dp[0,n-1]
 * dp[i,i] will be equal to 1 as lps value will be 1 for 1 char
 * dp[i,j] = dp[i+1][j-1] + 2, if ends chars are equal for new substring
 * here we are calculating lps for substring(i,j) by adding 2 to already
 * computed lps for substring(i+1,j-1).
 * dp[i,j] = Math.max(dp[i+1][j],dp[i][j-1]), if end chars are not equal
 * here we are calculating lps for substring(i,j) by taking max of lps of
 * subtring(i+1,j) & substring(i,j-1)
 * eg - sdddd -> lps(ddd) + lps(d), here max is in right side
 * dddds -> lps(d) + lps(ddd), here max is in left side
 * sddde -> lps(s) + lps(ddd), lps(ddd) + lps(e), here both sides are equal it
 * doesnt matter which side we chose
 * 
 * Approach
 * Initialize dp of n rows & cols
 * traverse row from end to 0 and col from row+1 to end as we need 0,n-1 value.
 * intialize i,i as 1 for single char
 * If ends chars are same add 2 to already computed i+1,j-1 to find new value
 * for i,j.
 * If ends chars are not same pick max of two possible substrings i,j-1 & i+1,j
 * Finally return value at 0,n-1
 * 
 * Complexity
 * Time complexity: O(n^2)
 * Space complexity: O(n^2)
 */
class Solution {
    public int longestPalindromeSubseq(String s) {

        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][n - 1];
    }
}