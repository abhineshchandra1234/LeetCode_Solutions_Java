// 3212. Count Submatrices With Equal Frequency of X and Y

/**
 * Intuition
 * This problem is similar to "3070. Count Submatrices with Top-Left Element and
 * Sum Less Than k"
 * In this we will keep count of X and Y in two arrays
 * Curr cell of X which contain 'X' count, will add values from top & left and
 * subtract diagonal value
 * Similar case will be for Y array
 * At last for curr cell, we will check if X and Y count are equal and X count
 * is greater than 0, we have got one suitable submatrice and increase res count
 * At last return res
 * Approach
 * 
 * Complexity
 * Time complexity: O(m*n)
 * Space complexity: O(m*n)
 */

class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] X = new int[m][n];
        int[][] Y = new int[m][n];

        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                X[i][j] = (grid[i][j] == 'X') ? 1 : 0;
                Y[i][j] = (grid[i][j] == 'Y') ? 1 : 0;

                if (i - 1 >= 0) {
                    X[i][j] += X[i - 1][j];
                    Y[i][j] += Y[i - 1][j];
                }

                if (j - 1 >= 0) {
                    X[i][j] += X[i][j - 1];
                    Y[i][j] += Y[i][j - 1];
                }

                if (i - 1 >= 0 && j - 1 >= 0) {
                    X[i][j] -= X[i - 1][j - 1];
                    Y[i][j] -= Y[i - 1][j - 1];
                }

                if (X[i][j] == Y[i][j] && X[i][j] > 0)
                    res++;
            }
        }

        return res;
    }
}