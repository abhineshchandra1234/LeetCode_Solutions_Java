/**
 * 1937. Maximum Number of Points with Cost
 * 
 * Intuition
 * we are given m*n integer matrix points
 * we need to return max points
 * the brute force approach is to use two rows prev and curr
 * But it will take O(n^2) time to update curr, as it is comparing with all
 * cells of prev
 * an optimized way is to use four rows prev, left, right and curr
 * we already know how to calculate prev
 * left is nothing but max of prev till that index from left including penalty
 * right is also same but calculated from right side
 * when we calculate curr, it will be max of left or right at that index plus
 * curr value at that index
 * with this approach we will get max in O(1) instead of O(n) for each cell, and
 * can be reused
 * we are assigning curr to prev at last, which contain all final values for the
 * last row
 * traverse prev and find max, that is our res
 * Approach
 * 
 * Complexity
 * Time complexity: O(m*n), O(m*3*n)
 * Space complexity: O(m)
 */
class Solution {

    public long maxPoints(int[][] points) {

        int n = points.length;
        int m = points[0].length;

        long[] prev = new long[m];

        for (int i = 0; i < m; i++)
            prev[i] = points[0][i];

        long[] left = new long[m];
        long[] right = new long[m];
        long[] curr = new long[m];

        for (int i = 0; i < n - 1; i++) {

            left[0] = prev[0];
            for (int k = 1; k < m; k++)
                left[k] = Math.max(left[k - 1] - 1, prev[k]);

            right[m - 1] = prev[m - 1];
            for (int k = m - 2; k >= 0; k--)
                right[k] = Math.max(right[k + 1] - 1, prev[k]);

            for (int j = 0; j < m; j++) {
                curr[j] = Math.max(left[j], right[j]) + points[i + 1][j];
            }

            prev = curr;
        }

        long res = 0;
        for (int i = 0; i < m; i++)
            res = Math.max(res, prev[i]);

        return res;
    }
}