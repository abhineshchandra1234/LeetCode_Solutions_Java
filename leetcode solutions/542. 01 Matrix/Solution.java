/**
 * 542. 01 Matrix
 * 
 * Intuition
 * 
 * credits hiepit
 * We can solve this problem through BFS.
 * Distance of every 0 from 0 is 0. We will add zeros to queue and then we will
 * pop them one by one and add 1 to the distance of its neighbors.
 * TC - O(m*n) SC - O(m*n)
 * We can also solve this problem using dp
 * Each cell distance will be best of its 4 neighs cells. But it may happen all
 * its 4 neigh computation is not done.
 * so we will first take top & left cell into consideration and run loop from
 * top to bottom and left to right.
 * Then we will take bottom & right cell into consideration and run loop from
 * bottom to top and right to left.
 * TC - O(m*n) SC - O(1)
 * 
 * Complexity
 * 
 * Time complexity: O(m*n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length, n = mat[0].length, INF = m + n;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (mat[r][c] == 0)
                    continue;
                int top = INF, left = INF;
                if (r - 1 >= 0)
                    top = mat[r - 1][c];
                if (c - 1 >= 0)
                    left = mat[r][c - 1];
                mat[r][c] = Math.min(top, left) + 1;
            }
        }

        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (mat[r][c] == 0)
                    continue;
                int bottom = INF, right = INF;
                if (r + 1 < m)
                    bottom = mat[r + 1][c];
                if (c + 1 < n)
                    right = mat[r][c + 1];
                mat[r][c] = Math.min(mat[r][c], Math.min(bottom, right) + 1);
            }
        }
        return mat;
    }
}