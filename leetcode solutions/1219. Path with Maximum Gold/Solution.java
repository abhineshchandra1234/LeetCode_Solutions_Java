/**
 * 1219. Path with Maximum Gold
 * 
 * Intuition
 * 
 * we will solve this problem through dfs and backtracking
 * we will traverse each cell and update res with max gold of each cell
 * For each cell we will call dfs in all 4 dirs and find the local max and
 * return it
 * the terminating logic for dfs is we have reached a node at the end of matrix
 * ie have all visited neighs or a node whose neighs has no gold, then return 0
 * the prev node will return sum of its and next cell gold following
 * backtracking approach
 * Finally local max will be calculated at the cell level and it will be sent
 * back to calculate global max for all cells.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(m*n*4^k), we have total m*n cells and for each cell we can
 * have 4^k different paths
 * 
 * Space complexity: O(k), recursive stack can grow a max of size k
 * 
 */
class Solution {
    public int getMaximumGold(int[][] grid) {

        int n = grid.length, m = grid[0].length;
        int res = 0;
        // find max among all cells
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                res = Math.max(res, dfs(grid, n, m, i, j));
        return res;
    }

    int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    // find max for a cell including all paths
    private int dfs(int[][] grid, int n, int m, int i, int j) {

        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0)
            return 0;

        int origin = grid[i][j];
        grid[i][j] = 0;
        int res = 0;
        for (int[] d : dirs)
            res = Math.max(res, dfs(grid, n, m, i + d[0], j + d[1]));
        grid[i][j] = origin;
        return res + origin;
    }
}