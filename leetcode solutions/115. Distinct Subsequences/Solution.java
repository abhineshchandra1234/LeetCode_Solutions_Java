// 115. Distinct Subsequences

/**
 * Intuition
 * we will compare both the strings from the end
 * if we have reached start of target string, we will return 1, ie we have got
 * one valid substring
 * if we have reached start of source string, we will return 0, ie we have no
 * substring to compare
 * if curr dp state is not empty, we will return it
 * if curr chars match, we will explore next char of source and curr char of
 * target and next char of source and next char of target
 * if curr chars doesnt match, we will explore next char of source and curr char
 * of target
 * Approach
 * 
 * Complexity
 * Time complexity: O(m*n)
 * Space complexity: O(m*n)
 */

class Solution {
    int[][] dp = new int[1001][1001];

    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n)
            return 0;

        for (int[] row : dp)
            Arrays.fill(row, -1);
        return solve(s, t, m, n);
    }

    int solve(String s, String t, int m, int n) {
        // got one valid substring
        if (n == 0)
            return dp[m][n] = 1;
        // doesnt have substring to compare
        if (m == 0)
            return dp[m][n] = 0;

        if (dp[m][n] != -1)
            return dp[m][n];

        if (s.charAt(m - 1) == t.charAt(n - 1))
            return dp[m][n] = solve(s, t, m - 1, n) + solve(s, t, m - 1, n - 1);
        else
            return dp[m][n] = solve(s, t, m - 1, n);
    }
}