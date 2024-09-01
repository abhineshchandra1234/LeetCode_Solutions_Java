/**
 * 2022. Convert 1D Array Into 2D Array
 * 
 * Intuition
 * 
 * Given
 * we are given integer array original and two integers m & n
 * Return
 * m*n 2d array else empty array if its impossible
 * 
 * we need to fill each rows with n nos
 * 
 * Approach
 * 
 * we will run two loops row and col wise and start filling elements from the
 * original serially
 * 
 * Complexity
 * 
 * Time complexity: O(m*n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {

    public int[][] construct2DArray(int[] original, int m, int n) {

        if (m * n != original.length)
            return new int[0][0];

        int[][] res = new int[m][n];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = original[index++];
            }
        }

        return res;
    }
}