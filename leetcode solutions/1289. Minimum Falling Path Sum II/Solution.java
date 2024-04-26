/**
 * 1289. Minimum Falling Path Sum II
 * 
 * Intuition
 * 
 * we need to find two smallest in the previous row
 * if the smallest is just above the curr cell we will add secSmallest to curr
 * cell else will add smallest
 * This way each cell at the last row contains min path from the top, we need to
 * find and return minimum among these min paths
 * 
 * Note - we can form path between any cols, except cells in adjacent rows and
 * same col
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(m∗n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int minFallingPathSum(int[][] grid) {

        int n = grid.length, m = grid[0].length;
        for (int i = 1; i < n; i++) {
            int[] small = twoSmallest(grid[i - 1]);
            for (int j = 0; j < m; j++) {
                grid[i][j] += grid[i - 1][j] == small[0] ? small[1] : small[0];
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
            res = Math.min(res, grid[n - 1][i]);

        return res;
    }

    private int[] twoSmallest(int[] grid) {
        int smallest = Integer.MAX_VALUE, secSmallest = Integer.MAX_VALUE;

        int n = grid.length;
        for (int i = 0; i < n; i++) {
            if (grid[i] < smallest) {
                secSmallest = smallest;
                smallest = grid[i];
            } else if (grid[i] < secSmallest)
                secSmallest = grid[i];
        }

        return new int[] { smallest, secSmallest };
    }
}