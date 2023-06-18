/**
 * 1351. Count Negative Numbers in a Sorted Matrix
 * 
 * Intuition
 * credits ikeabord, rock
 * This solution uses the fact that the negative regions of the matrix will form
 * a "staircase" shape, e.g.:
 * ++++++
 * ++++--
 * ++++--
 * +++---
 * +-----
 * +-----
 * then "trace" the outline of the staircase.
 * we will start from bottom-left corner of matrix and count negative no in each
 * row.
 * we can start from top-right too.
 * Last row will have the min nos of the matrix. As min of each row & col is
 * present there
 * If it is all +ve then last row will only be traversed. t - O(m).
 * If it is all -ve first col will only be traversed. t - O(n).
 * 
 * Complexity
 * Time complexity: O(m+n)
 * Space complexity: O(1)
 */
class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length, n = grid[0].length, r = m - 1, c = 0, cnt = 0;
        while (r >= 0 && c < n) {
            if (grid[r][c] < 0) {
                r--;
                cnt += n - c;
            } else
                c++;
        }
        return cnt;
    }
}