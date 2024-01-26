/**
 * 576. Out of Boundary Paths
 * 
 * Intuition
 * 
 * Each position paths count will be the sum of its 4 neighs
 * Each position can have different no of paths based on no of max moves
 * first & last rows, cols do not have neighs so thier moves will be added
 * directly to the res.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(N∗m∗n), N is the max moves, for each move
 * we are creating dp for every position
 * 
 * Space complexity: O(m∗n), we are using temp dp to update the
 * final dp
 * 
 */
class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int mod = (int) (1e9 + 7);
        int[][] dp = new int[m][n];
        dp[startRow][startColumn] = 1;
        int count = 0;
        for (int moves = 1; moves <= maxMove; moves++) {
            int[][] temp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == m - 1)
                        count = (count + dp[i][j]) % mod;
                    if (j == n - 1)
                        count = (count + dp[i][j]) % mod;
                    if (i == 0)
                        count = (count + dp[i][j]) % mod;
                    if (j == 0)
                        count = (count + dp[i][j]) % mod;
                    temp[i][j] = (((i > 0 ? dp[i - 1][j] : 0) + (i < m - 1 ? dp[i + 1][j] : 0)) % mod +
                            ((j > 0 ? dp[i][j - 1] : 0) + (j < n - 1 ? dp[i][j + 1] : 0)) % mod) % mod;
                }
            }
            dp = temp;
        }
        return count;
    }
}