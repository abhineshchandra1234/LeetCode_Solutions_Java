/**
 * 1905. Count Sub Islands
 * 
 * Intuition
 * 
 * we are given two binary matrices m*n grid1 and grid2
 * we need to return no of islands in grid2 that are considered sub-islands
 * It is clear from the question that whole island of grid2 will be subisland
 * and it cannot be partial subisland
 * 
 * Approach
 * 
 * we will traverse grid2, if the current cell is not visited and is land, we
 * will mark its neighs and itself as visited and check if it is subisland or
 * not
 * to check the subisland the curr grid2 island should be land in grid1
 * If all lands of current island in grid2 is also land in grid1 then current
 * island in grid2 is considered subisland.
 * 
 * Complexity
 * 
 * Time complexity: O(m*n), traverse matrix
 * 
 * Space complexity: O(m*n), boolean visited array
 * 
 */
class Solution {

    int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int countSubIslands(int[][] grid1, int[][] grid2) {

        int n = grid2.length;
        int m = grid2[0].length;

        boolean[][] visited = new boolean[n][m];

        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && isLand(i, j, grid2)) {
                    visited[i][j] = true;
                    if (helper(i, j, grid1, grid2, visited))
                        res += 1;
                }
            }
        }

        return res;
    }

    private boolean helper(int i, int j, int[][] grid1, int[][] grid2, boolean[][] visited) {

        int n = grid2.length;
        int m = grid2[0].length;

        boolean isSubIsland = true;

        if (!isLand(i, j, grid1))
            isSubIsland = false;

        for (int[] dir : dirs) {
            int nexti = i + dir[0];
            int nextj = j + dir[1];

            if (nexti >= 0 && nexti < n && nextj >= 0 && nextj < m && !visited[nexti][nextj]
                    && isLand(nexti, nextj, grid2)) {
                visited[nexti][nextj] = true;
                boolean nextCellSubLand = helper(nexti, nextj, grid1, grid2, visited);
                isSubIsland = isSubIsland && nextCellSubLand;
            }
        }

        return isSubIsland;
    }

    private boolean isLand(int x, int y, int[][] grid) {
        return grid[x][y] == 1;
    }
}