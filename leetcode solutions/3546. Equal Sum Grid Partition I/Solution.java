// 3546. Equal Sum Grid Partition I

/**
 * Intuition
 * we will calculate total, rowSum and colSum first
 * Then we will traverse each row, and see if upper sum is equal to lower sum ie
 * total - upper, if it is return true
 * Then we will traverse each col, and see if left sum is equal to right sum ie
 * total - left, if it is return true
 * At last return false, if above conditions doesnt match
 * Approach
 * 
 * Complexity
 * Time complexity: O(m*n)
 * Space complexity: O(m+n)
 */

class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long[] rSum = new long[m];
        long[] cSum = new long[n];

        long total = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += grid[i][j];
                rSum[i] += grid[i][j];
                cSum[j] += grid[i][j];
            }
        }

        if (total % 2 != 0)
            return false;

        long upper = 0;
        for (int i = 0; i < m - 1; i++) {
            upper += rSum[i];
            if (upper == total - upper)
                return true;
        }

        long left = 0;
        for (int j = 0; j < n - 1; j++) {
            left += cSum[j];
            if (left == total - left)
                return true;
        }

        return false;
    }
}