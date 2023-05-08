/**
 * 1572. Matrix Diagonal Sum
 * 
 * Intuition
 * for primary diagonal we know we have same row and col
 * for secondary diagonal we have ith row and n-1-ith col.
 * To avoid adding duplicate cell for odd n we have first added primary diagonal
 * sum and put a cond that i!=n-1-i before adding secondary diagonal sum.
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {
    public int diagonalSum(int[][] mat) {

        int sum = 0, n = mat.length;
        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
            if (i != n - 1 - i)
                sum += mat[i][n - 1 - i];
        }
        return sum;
    }
}