// 3567. Minimum Absolute Difference in Sliding Submatrix

/**
 * Intuition
 * we have to use brute force to solve this problem
 * we will traverse through the grid and for each cell traverse matrix of k size
 * we will add all nos of k size matrix in a tree set
 * tree set will have nos sorted and unique
 * we will find min diff among all unique nos and assign it to res[i][j]
 * Finally return res
 * Approach
 * 
 * Complexity
 * Time complexity: O(n^2*k^2)
 * Space complexity: O(k^2)
 */

class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] res = new int[m - k + 1][n - k + 1];

        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                // sorted + unique
                TreeSet<Integer> s = new TreeSet();

                for (int r = i; r <= i + k - 1; r++) {
                    for (int c = j; c <= j + k - 1; c++) {
                        s.add(grid[r][c]);
                    }
                }

                if (s.size() == 1)
                    continue;

                int minDiff = Integer.MAX_VALUE;

                Integer prev = null;
                for (int curr : s) {
                    if (prev != null)
                        minDiff = Math.min(minDiff, curr - prev);
                    prev = curr;
                }

                res[i][j] = minDiff;
            }
        }

        return res;
    }
}