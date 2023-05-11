/**
 * 1035. Uncrossed Lines
 * 
 * Intuition
 * we will solve this problem using dp bcs in these different combinations are
 * involved.
 * It is similar to longest common sub-sequence
 * It can be best understood with practical example
 * for nums1 = [1,4,2], nums2 = [1,2,4]
 * if we look at 3 row and 2 col 2,2 is similar
 * so we need to add 1 to result before it ie 2 row and 1 col which is 1.
 * if we look at 2 row and 2 col 4,2 is not similar. There are two possible
 * combinations here first 1 row and 2 col, second 2 row and 1 col, we will take
 * max of these two results.
 * dp array will always contain valid result, that how we avoid crossed line, it
 * can be better understood with 2,2 ex.
 * In this 4,4 is not included.
 * Do dry run for better understanding.
 * 
 * Complexity
 * Time complexity: O(m*n)
 * Space complexity: O(m*n)
 */
class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {

        int m = nums1.length, n = nums2.length, dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }
}