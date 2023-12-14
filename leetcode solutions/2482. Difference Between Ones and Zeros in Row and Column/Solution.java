/**
 * 2482. Difference Between Ones and Zeros in Row and Column
 * 
 * Intuition
 * 
 * By the question it is clear that we can solve it in place by using 4 arrays
 * to store count of zeros and ones for each rol and col
 * how to optimize it, we can solve it just by using 2 arrays to store count of
 * ones for each row and col
 * Next 2 arrays can be calculated from the existing arrays
 * rowZeros[i] = cols - rowOnes[i]
 * colZeros[j] = rows - colOnes[j]
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(m∗n)
 * 
 * Space complexity: O(m+n)
 * 
 */
class Solution {
    public int[][] onesMinusZeros(int[][] grid) {

        int rows = grid.length, cols = grid[0].length;
        int[] rowOnes = new int[rows];
        int[] colOnes = new int[cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (grid[i][j] == 1) {
                    rowOnes[i]++;
                    colOnes[j]++;
                }

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                grid[i][j] = rowOnes[i] + colOnes[j] - (cols - rowOnes[i]) - (rows - colOnes[j]);

        return grid;
    }
}