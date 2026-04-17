// 1292. Maximum Side Length of a Square with Sum Less than or Equal to
// Threshold

/**
 * Intuition
 * we will create a prefix sum for (i,j), which will store sum from (0,0) to
 * (i,j)
 * Then we will apply binary search on sides
 * In binary search check function, it will check if there exist any square of
 * size side, whose sum is less than or equal to threshold
 * Finally return res
 * Approach
 * 
 * Complexity
 * Time complexity: O(log(n)*n*m), we are applying binary search on side, and
 * checking square of size side for sum
 * Space complexity: O(n*m), creating prefix
 */

class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length;
        int m = mat[0].length;

        // sum from (0,0) to (i,j)
        int[][] prefix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prefix[i][j] = mat[i][j]
                        + (i > 0 ? prefix[i - 1][j] : 0)
                        + (j > 0 ? prefix[i][j - 1] : 0)
                        - (i > 0 && j > 0 ? prefix[i - 1][j - 1] : 0);
            }
        }

        // binary search on side length
        int l = 1, h = Math.min(n, m);
        int res = 0;

        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (check(mid, n, m, threshold, prefix)) {
                res = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return res;
    }

    private boolean check(int side, int n, int m,
            int threshold, int[][] prefix) {
        if (side == 0)
            return true;

        // checking sum of square of size i,j till side length
        // square can be diff size 1, 2, 3, 4
        // it will discard sum from (0,0) to (i,j)
        // and return sum from (i,j) (i+side, j+side)
        for (int i = 0; i + side - 1 < n; i++) {
            for (int j = 0; j + side - 1 < m; j++) {

                int r2 = i + side - 1;
                int c2 = j + side - 1;

                int sum = prefix[r2][c2];
                if (i > 0)
                    sum -= prefix[i - 1][c2];
                if (j > 0)
                    sum -= prefix[r2][j - 1];
                if (i > 0 && j > 0)
                    sum += prefix[i - 1][j - 1];

                if (sum <= threshold)
                    return true;
            }
        }

        return false;
    }
}