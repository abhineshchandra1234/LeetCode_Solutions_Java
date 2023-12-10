/**
 * 867. Transpose Matrix
 * 
 * Intuition
 * 
 * If it was square matrix you could have swapped elements before main diagonal
 * and your transpose is ready
 * In this rectangular matrix we will take help of an extra array with col and
 * row reverse of original array
 * Then we will just traverse original array and fill reverse positions.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(m∗n)
 * 
 * Space complexity: O(m∗n)
 * 
 */
class Solution {
    public int[][] transpose(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        // row will become col and vice-versa for col
        int[][] ans = new int[m][n];

        // ans will contain reversed row and col
        // we need to fill it
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                ans[j][i] = matrix[i][j];

        return ans;
    }
}