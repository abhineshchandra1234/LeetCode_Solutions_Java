/**
 * 1277. Count Square Submatrices with All Ones
 * 
 * Intuition
 * we can solve this problem through recursion
 * for each cell we will call the recursive function
 * for each cell dp[i][j], largest square ending at it is equal to 1 + min(left,
 * min(bottom, diagonal))
 * Approach
 * 
 * 
 * Complexity
 * Time complexity: O(m*n)
 * Space complexity: O(m*n)
 * 
 */
class Solution {

    public int countSquares(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        int ans = 0;
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {

            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans += solve(i, j, matrix, dp);
            }
        }

        return ans;
    }

    public int solve(int i, int j, int[][] matrix, int[][] dp) {

        int n = matrix.length;
        int m = matrix[0].length;
        if (i >= n || j >= m)
            return 0;

        if (matrix[i][j] == 0)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int right = solve(i, j + 1, matrix, dp);
        int diagonal = solve(i + 1, j + 1, matrix, dp);
        int below = solve(i + 1, j, matrix, dp);

        return dp[i][j] = 1 + Math.min(right, Math.min(diagonal, below));
    }
}