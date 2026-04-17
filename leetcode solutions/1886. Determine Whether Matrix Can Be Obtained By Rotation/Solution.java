// 1886. Determine Whether Matrix Can Be Obtained By Rotation

/**
 * Intuition
 * we can rotate mat max 4 times ie 360 degree
 * After 4 rotations we will get the same mat
 * we are checking mat is equal to target at every rotation
 * At last we are returning false, if they are not equal even after 4 rotation
 * to rotate mat 90 degree, we first find transpose of mat, then reverse each
 * row
 * Approach
 * 
 * Complexity
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */

class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {

        int n = mat.length;

        for (int k = 0; k < 4; k++) {
            boolean equal = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] != target[i][j]) {
                        equal = false;
                        break;
                    }
                }
                if (!equal)
                    break;
            }
            if (equal)
                return true;

            rotate(mat);
        }

        return false;
    }

    private void rotate(int[][] mat) {
        int n = mat.length;

        // transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = mat[i][left];
                mat[i][left] = mat[i][right];
                mat[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}