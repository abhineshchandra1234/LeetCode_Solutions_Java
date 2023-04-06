/**
 * 1254. Number of Closed Islands
 * 
 * Intuition
 * The basic logic is current cell should be land and all its 4 direction should
 * be water, if it is return true.
 * we will use dfs to check its all 4 direction.
 * base cond 1 - out of bounds return false
 * base cond 2 - if curr cell is land return true
 * body - mark curr cell as visited and check its four direction.
 * return - return true if all 4 dirs contain water.
 * 
 * Approach
 * We will traverse through grid and if curr cell is land and all its 4
 * directions is water, increase the island count.
 * We will pass curr position to helper method and it will check all the four
 * dirs
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

class Solution {
    public int closedIsland(int[][] grid) {

        int row = grid.length, col = grid[0].length, count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 && dfs(grid, i, j))
                    count++;
            }
        }
        return count;
    }

    private boolean dfs(int[][] grid, int x, int y) {

        int n = grid.length, m = grid[0].length;
        if (x < 0 || x >= n || y < 0 || y >= m)
            return false;

        if (grid[x][y] == 1)
            return true;
        // mark visited
        grid[x][y] = 1;
        boolean left = dfs(grid, x, y - 1), right = dfs(grid, x, y + 1);
        boolean up = dfs(grid, x - 1, y), down = dfs(grid, x + 1, y);
        return left && right && up && down;
    }
}