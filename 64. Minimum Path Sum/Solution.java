/**
 * Intuition
 * we need to use (0,0) cell and solve this problem inplace using dynamic
 * programming.
 * If we calculate the min value for each cell starting from 0,0 we will get the
 * min value at n-1,n-1
 * 
 * Approach
 * we will first calculate min value of each cell of the 0th row and col
 * For 0th row each cell will have a value as the sum of curr and left cell
 * For 0th col each cell will have value as the sum of curr and top cell
 * For rest of the cells we will use 0th row & 0th col to calculate their value.
 * Rest of the cells will have value as the sum of curr and Min(left,top)
 * 
 * Complexity
 * Time complexity: O(n*n)
 * Space complexity: O(1)
 */
class Solution {
    public int minPathSum(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0)
                    grid[i][j] = grid[i][j];
                else if (i == 0 && j != 0)
                    grid[i][j] += grid[i][j - 1];
                else if (j == 0 && i != 0)
                    grid[i][j] += grid[i - 1][j];
                else
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}