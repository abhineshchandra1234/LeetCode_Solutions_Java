// 3418. Maximum Amount of Money Robot Can Earn

/**
 * Intuition
 * we will solve this problem using dp and memoization
 * we will first check down, and get its max value
 * then we will check right, and get its max value
 * we will take max of above two values
 * max value will be from [i][j] to [m-1][n-1]
 * Then we will check skip value for down, and get its value
 * then we will check skip value for right, and get its value
 * we will again take max of above two values
 * Then lastly we take max of best and skip best value and assign it to current
 * cell and return the max value
 * Approach
 * 
 * Complexity
 * Time complexity: O(m*n)
 * Space complexity: O(m*n)
 */

class Solution {
    int m, n;
    int[][][] dp;

    public int maximumAmount(int[][] coins) {
        m = coins.length;
        n = coins[0].length;

        dp = new int[m][n][3];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }

        return solve(coins, 0, 0, 2);
    }

    private int solve(int[][] coins, int i, int j, int nu) {
        if (i >= m || j >= n)
            return Integer.MIN_VALUE;

        if (i == m - 1 && j == n - 1) {
            if (coins[i][j] < 0 && nu > 0)
                return 0;
            return coins[i][j];
        }

        if (dp[i][j][nu] != Integer.MIN_VALUE)
            return dp[i][j][nu];

        int best = Integer.MIN_VALUE;

        int down = solve(coins, i + 1, j, nu);
        if (down != Integer.MIN_VALUE)
            best = Math.max(best, coins[i][j] + down);

        int right = solve(coins, i, j + 1, nu);
        if (right != Integer.MIN_VALUE)
            best = Math.max(best, coins[i][j] + right);

        if (coins[i][j] < 0 && nu > 0) {
            int downSkip = solve(coins, i + 1, j, nu - 1);
            int rightSkip = solve(coins, i, j + 1, nu - 1);

            int skipBest = Math.max(downSkip, rightSkip);
            if (skipBest != Integer.MIN_VALUE)
                best = Math.max(best, skipBest);
        }

        return dp[i][j][nu] = best;
    }
}