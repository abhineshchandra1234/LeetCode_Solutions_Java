// 2946. Matrix Similarity After Cyclic Shifts

/**
 * Intuition
 * we will find the final position of left shift and right shift
 * If the final position no is not equal to curr no, return false
 * otherwise return true at the end
 * Approach
 * 
 * Complexity
 * Time complexity: O(m*n)
 * Space complexity: O(1)
 */

class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        k = k % n;
        if (k == 0)
            return true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cIdx = j;
                int fIdx;

                if (i % 2 == 0) {
                    fIdx = (j + k) % n;
                } else {
                    fIdx = (j - k + n) % n;
                }

                if (mat[i][cIdx] != mat[i][fIdx])
                    return false;
            }
        }

        return true;
    }
}