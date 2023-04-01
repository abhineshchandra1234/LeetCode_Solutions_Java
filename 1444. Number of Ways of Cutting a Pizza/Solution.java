/**
 * Intuition
 * We can solve this using the prefix sum and dp
 * We can cut horizontally through each row and vertically through each column
 * We use the prefix sum to see the presence of an apple then cut, check
 * invalid
 * area with no apples, check valid area with apples present but 0 cuts
 * Remaining
 * 
 * Approach
 * we will first find the prefix sum for the pizza array
 * we will have a DP with three values row, col and k
 * we will apply dfs starting from 0,0
 * Inside dfs will have 3 conds
 * if prefix sum is 0 return 0 ie the sub-section is invalid
 * if the section is valid and k is 0 we found a way
 * if the current dp position is not null return the value to avoid repeated
 * computation
 * make horizontal cuts from r+1 till m-1 and also ensure upper section contains
 * at least 1 apple
 * make vertical cuts from c+1 till n-1 and also ensure left section contains
 * at least 1 apple.
 * Store the result in the dp
 * 
 * Complexity
 * Time complexity:O(k*m*n*(m+n))
 * k*m*n states in dfs and each state need m+n time to cut in horizontal or
 * Vertical
 * Space complexity:O(k*m*n)
 */

class Solution {
    public int ways(String[] pizza, int k) {

        int m = pizza.length, n = pizza[0].length();
        Integer[][][] dp = new Integer[k][m][n];
        // preSum[r][c] is the total no of apples in pizza[r:][c:]
        int[][] preSum = new int[m + 1][n + 1];
        for (int r = m - 1; r >= 0; r--)
            for (int c = n - 1; c >= 0; c--)
                preSum[r][c] = preSum[r][c + 1] + preSum[r + 1][c] - preSum[r + 1][c + 1]
                        + (pizza[r].charAt(c) == 'A' ? 1 : 0);
        return dfs(m, n, k - 1, 0, 0, dp, preSum);
    }

    private int dfs(int m, int n, int k, int r, int c, Integer[][][] dp, int[][] preSum) {
        // if the remaining piece has no apples -> invalid
        if (preSum[r][c] == 0)
            return 0;
        // found valid way after k-1 cuts
        if (k == 0)
            return 1;
        if (dp[k][r][c] != null)
            return dp[k][r][c];
        int ans = 0;
        // cut in horizontal
        for (int nr = r + 1; nr < m; nr++)
            // cut if the upper piece contains at least one apple
            if (preSum[r][c] - preSum[nr][c] > 0)
                ans = (ans + dfs(m, n, k - 1, nr, c, dp, preSum)) % 1_000_000_007;
        // cut in vertical
        for (int nc = c + 1; nc < n; nc++)
            // cut if the left piece contains at least one apple
            if (preSum[r][c] - preSum[r][nc] > 0)
                ans = (ans + dfs(m, n, k - 1, r, nc, dp, preSum)) % 1_000_000_007;
        return dp[k][r][c] = ans;
    }
}