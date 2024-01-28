/**
 * 1074. Number of Submatrices That Sum to Target
 * 
 * Intuition
 * 
 * credit lee215
 * we will store prefix sum for each cell, so prefix sum for whole row will be
 * at the last cell
 * when we take sum of prefix sum of each row, we get prefix sum for whole
 * matrix ending at (n,n) starting at (0,0)
 * As evident in the question we will run two loops for cols and 1 loop for row
 * to cover every submatrices
 * 
 * Approach
 * 
 * Input: matrix = [[1,-1],[-1,1]], target = 0
 * Output: 5
 * Explanation: The two 1x2 submatrices,
 * plus the two 2x1 submatrices, plus the 2x2 submatrix.
 * 
 * when you dry run the code you will res as
 * 2*1,
 * 1*2,
 * 1*2, 2*2
 * 2*1
 * 
 * Complexity
 * 
 * Time complexity: O(m∗n∗n), we are running two loops for cols
 * and running 1 loop for row
 * 
 * Space complexity: O(m), we are storing freq of prefix sum of all rows
 * 
 */
class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {

        int res = 0, m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 1; j < n; j++)
                matrix[i][j] += matrix[i][j - 1];

        Map<Integer, Integer> counter = new HashMap();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                counter.clear();
                counter.put(0, 1);
                int cur = 0;
                for (int k = 0; k < m; k++) {
                    cur += matrix[k][j] - (i > 0 ? matrix[k][i - 1] : 0);
                    res += counter.getOrDefault(cur - target, 0);
                    counter.put(cur, counter.getOrDefault(cur, 0) + 1);
                }
            }
        }

        return res;
    }
}