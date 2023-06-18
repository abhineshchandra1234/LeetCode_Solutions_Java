/**
 * 2328. Number of Increasing Paths in a Grid
 * 
 * Intuition
 * 
 * credits PhoenixDD
 * We can understand this problem using 1-d array
 * for [1,2,3,4,3], find total no of increasing path
 * Taking each no as starting point 1 -> [1,2,3,4] = 4, 2 -> [2,3,4] = 3, 3 ->
 * [3,4] = 2, 4 -> [4] = 1, 3 -> [3] = 1.
 * total = 4+3+2+1+1 = 11 is the no of increasing paths.
 * lets break 1 -> [1,2,3,4] = 4 further down
 * It consist of 4 increasing paths, [1], [1,2], [1,2,3], [1,2,3,4]
 * same concept we need to apply to 2-d array to get our answer for each node as
 * the starting point we will check the longest increasing path in its 4
 * directions.
 * Sum of all these paths for all nodes will be our answer.
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(m*n), we are visting each node
 * 
 * Space complexity:
 * 
 * O(m*n), to store memo for each node
 * 
 */
class Solution {

    int mod = (int) 1e9 + 7;
    int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    Integer[][] memo;

    public int countPaths(int[][] grid) {
        int res = 0;
        memo = new Integer[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                res = (res + dp(grid, i, j)) % mod;
            }
        }
        return res;
    }

    int dp(int[][] grid, int i, int j) {

        if (memo[i][j] != null)
            return memo[i][j];

        int res = 1;
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length
                    && grid[x][y] > grid[i][j])
                res = (res + dp(grid, x, y)) % mod;
        }
        return memo[i][j] = res;
    }
}