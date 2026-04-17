// 3643. Flip Square Submatrix Vertically

/**
 * Intuition
 * we have starting coordinates and ending coordinates we generate from k
 * we will have 2 ptrs, one will point to start row and another will point to
 * end row
 * we will just swap all their nos, increase start ptr and decrease end ptr
 * Finally return the grid
 * Approach
 * 
 * Complexity
 * Time complexity: O(k^2)
 * Space complexity: O(1)
 */

class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {

        int startR = x;
        int endR = x + k - 1;

        int startC = y;
        int endC = y + k - 1;

        while (startR < endR) {
            for (int j = startC; j <= endC; j++) {
                int temp = grid[startR][j];
                grid[startR][j] = grid[endR][j];
                grid[endR][j] = temp;
            }
            startR++;
            endR--;
        }

        return grid;
    }
}