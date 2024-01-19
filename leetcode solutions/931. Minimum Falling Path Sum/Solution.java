/**
 * 931. Minimum Falling Path Sum
 * 
 * Intuition
 * 
 * credits votrubac
 * we will solve this problem using inplace dp
 * we will start from the first row and add min path to each element
 * the min path to matrix[i][j] = min of (matrix[i-1][j-1], matrix[i-1][j],
 * matrix[i-1][j+1])
 * Finally the min element in the last row is our ans
 * 
 * Approach
 * 
 * Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * Output: 13
 * [2, 1, 3]
 * [6, 5, 4] -> [7, 6, 5]
 * [7, 8, 9] -> [7, 8, 9] -> [13, 13, 14]
 * 
 * you can see we have two min paths in last row, return any of them
 * 
 * Complexity
 * 
 * Time complexity: O(n∗n), traversing matrix
 * 
 * Space complexity: O(1), inplace dp
 * 
 */
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++)
                matrix[i][j] += Math.min(matrix[i - 1][j],
                        Math.min(matrix[i - 1][Math.max(0, j - 1)],
                                matrix[i - 1][Math.min(n - 1, j + 1)]));
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
            res = Math.min(res, matrix[n - 1][i]);

        return res;
    }
}