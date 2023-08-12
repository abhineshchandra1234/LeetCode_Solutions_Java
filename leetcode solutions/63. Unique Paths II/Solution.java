/**
 * 63. Unique Paths II
 * 
 * Intuition
 * 
 * Everyone knows sky is blue but very few know why
 * 
 * Recursive Approach
 * we can solve this problem using dfs and bottom-up approach using recursion
 * and memoization
 * we call the approach bottom-up because we get the solution first at the
 * bottom, and solution is computated upwards from there
 * we can reach any cell from either top or left cell.
 * So total path for curr cell = paths for (top + left)
 * It is a valid path if we reach the last cell recursively.
 * Iterative Approach
 * We will solve using bfs and top-down approach
 * We call the approach top-down as we get the solution first at the top, and
 * solution is computated downwards as we move from top to bottom.
 * try to solve this problem using dry run from top cell to understand it
 * better.
 * we can reach cells in first row and col using a single path either through
 * left or top direction.
 * For rest of the cells we can reach from top or left or both. so we will take
 * the sum of that.
 * dp[i][j] = dp[i-1][j] + dp[i][j-1];
 * If the curr cell has obstacle we cannot reach it so we will assign it with
 * zero.
 * we can further optimize it as we just need two cols curr and prev one, which
 * we can store in two arrays.
 * curr[i] = curr[i-1] + prev[i]
 * we can optimize it even further as curr[i] has same state as prev[i], as we
 * are reaching curr[i] only from top through prev[i]
 * so we just need to add left paths from curr[i-1]
 * This way curr[i] is getting all the paths taking top and left dirs into
 * consideration.
 * curr[i] += curr[i-1]
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(m*n)
 * 
 * Space complexity:
 * 
 * O(n)
 * 
 * 
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        return dp[width - 1];
    }
}