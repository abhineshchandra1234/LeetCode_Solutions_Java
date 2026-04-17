/**
 * 2257. Count Unguarded Cells in the Grid
 * 
 * Intuition
 * First create a grid of size m*n, as it is not given
 * Mark guards and walls on the grid
 * As evident from the question, traverse guards and walls and mark the guards
 * and walls position
 * Inside the helper function, we will traverse in 4 dirs independently and mark
 * cells
 * if there is a guard or wall, we will return, as guard will have its own cells
 * for marking
 * Approach
 * 
 * Complexity
 * Time complexity: O(m*n)
 * Space complexity: O(m*n)
 */
class Solution {

    int unguarded = 0;
    int guarded = 1;
    int guard = 2;
    int wall = 3;

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {

        int[][] grid = new int[m][n];

        for (int[] g : guards) {
            grid[g[0]][g[1]] = guard;
        }

        for (int[] w : walls) {
            grid[w[0]][w[1]] = wall;
        }

        for (int[] g : guards) {
            dfs(g[0] - 1, g[1], grid, 'U');
            dfs(g[0] + 1, g[1], grid, 'B');
            dfs(g[0], g[1] - 1, grid, 'L');
            dfs(g[0], g[1] + 1, grid, 'R');
        }

        int count = 0;

        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == unguarded)
                    count++;
            }
        }
        return count;
    }

    private void dfs(int r, int c, int[][] grid, char dir) {

        if (r < 0 ||
                r >= grid.length ||
                c < 0 ||
                c >= grid[0].length ||
                grid[r][c] == guard ||
                grid[r][c] == wall) {
            return;
        }

        grid[r][c] = guarded;
        if (dir == 'U')
            dfs(r - 1, c, grid, 'U');
        else if (dir == 'B')
            dfs(r + 1, c, grid, 'B');
        else if (dir == 'L')
            dfs(r, c - 1, grid, 'L');
        else if (dir == 'R')
            dfs(r, c + 1, grid, 'R');
    }
}