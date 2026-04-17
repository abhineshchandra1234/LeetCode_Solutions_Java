// 2906. Construct Product Matrix

/**
 * Intuition
 * we will have a product grid
 * we will first find suffix and store it in product grid
 * Then we will traverse product grid and calculate prefix on the go
 * Then each cell value will be equal to product of prefix and suffix
 * This prefix and suffix will be calculated row wise
 * Approach
 * 
 * Complexity
 * Time complexity: O(m*n)
 * Space complexity: O(m*n)
 */

class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int mod = 12345;
        int m = grid.length;
        int n = grid[0].length;

        int[][] p = new int[m][n];

        long suf = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                p[i][j] = (int) suf;
                suf = (suf * grid[i][j]) % mod;
            }
        }

        long pref = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                p[i][j] = (int) ((pref * p[i][j]) % mod);
                pref = (pref * grid[i][j]) % mod;
            }
        }

        return p;
    }
}