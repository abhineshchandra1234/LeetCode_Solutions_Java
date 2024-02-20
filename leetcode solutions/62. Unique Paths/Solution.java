/**
 * 62. Unique Paths
 * 
 * Intuition
 * 
 * we will solve this problem through dp
 * we can reach each cell from top or left
 * so no of ways will sum of top & left
 * In dp base case helps us to build the solution using base logic
 * Solution
 * res = top + left
 * dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
 * Base Case
 * if row or col is 0, no of ways is 1
 * 
 * if (i == 0 || j == 0)
 * dp[i][j] = 1;
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(m*n)
 * 
 * Space complexity: O(m*n)
 * 
 */
class Solution {
    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}