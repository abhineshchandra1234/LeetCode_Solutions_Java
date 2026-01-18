// 1895. Largest Magic Square

/**
 * Intuition
 * we need to check sum of magic squares of all sizes
 * so we start from greatest magic square size ie min of rows and cols
 * First we will calculate prefix sum of all rows and cols, which will help in
 * calculating sum of magic square.
 * while traversing a particular magic square size
 * top-left corner of the row prefix grid, will be the targetSum, which will be
 * equal to entire row or col or both diagonals sum
 * next we will just check, if rest of the row or col or both diagonals sum are
 * equal to targetSum, if they are not, continue
 * if they are return the side
 * Approach
 * 
 * Complexity
 * Time complexity: O(n^3), parsing all magic square sizes, and their row and
 * col sum
 * Space complexity: O(n^2), calculating prefix sum for all rows and cols
 */

class Solution {
    public int largestMagicSquare(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        // row prefix sum
        int[][] rowSum = new int[row][col];
        for (int i = 0; i < row; i++) {
            rowSum[i][0] = grid[i][0];
            for (int j = 1; j < col; j++) {
                rowSum[i][j] = rowSum[i][j - 1] + grid[i][j];
            }
        }

        // col prefix sum
        int[][] colSum = new int[row][col];
        for (int j = 0; j < col; j++) {
            colSum[0][j] = grid[0][j];
            for (int i = 1; i < row; i++)
                colSum[i][j] = colSum[i - 1][j] + grid[i][j];
        }

        // square size from large to small
        for (int side = Math.min(row, col); side >= 2; side--) {
            // top-left corner of square
            for (int i = 0; i + side - 1 < row; i++) {
                for (int j = 0; j + side - 1 < col; j++) {
                    int targetSum = rowSum[i][j + side - 1] -
                            (j > 0 ? rowSum[i][j - 1] : 0);

                    boolean allSame = true;

                    // check all rows
                    for (int r = i + 1; r < i + side; r++) {
                        int rowS = rowSum[r][j + side - 1] -
                                (j > 0 ? rowSum[r][j - 1] : 0);
                        if (rowS != targetSum) {
                            allSame = false;
                            break;
                        }
                    }
                    if (!allSame)
                        continue;

                    // check all cols
                    for (int c = j; c < j + side; c++) {
                        int colS = colSum[i + side - 1][c] -
                                (i > 0 ? colSum[i - 1][c] : 0);
                        if (colS != targetSum) {
                            allSame = false;
                            break;
                        }
                    }
                    if (!allSame)
                        continue;

                    // check diagonals
                    int dig = 0;
                    int antiDig = 0;
                    for (int k = 0; k < side; k++) {
                        dig += grid[i + k][j + k];
                        antiDig += grid[i + k][j + side - 1 - k];
                    }

                    if (dig == targetSum && antiDig == targetSum)
                        return side;
                }
            }
        }

        return 1;
    }
}