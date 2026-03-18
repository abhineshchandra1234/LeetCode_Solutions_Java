// 3070. Count Submatrices with Top-Left Element and Sum Less Than k

/**
 * Intuition
 * At every cell we need to find sum of matrix from top left to curr cell
 * This can be done if we add top and left cell to curr cell value minus the
 * diagonal cell
 * diagonal cell values are in both top and left cell, so we subtract it
 * Approach
 * 
 * Complexity
 * Time complexity: O(m*n)
 * Space complexity: O(1)
 */

class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // top
                if (i > 0)
                    grid[i][j] += grid[i - 1][j];
                // left
                if (j > 0)
                    grid[i][j] += grid[i][j - 1];
                // diagonal
                if (i > 0 && j > 0)
                    grid[i][j] -= grid[i - 1][j - 1];

                if (grid[i][j] <= k)
                    count++;
                else
                    break;
            }
        }

        return count;
    }
}