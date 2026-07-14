// 3336. Find the Number of Subsequences With Equal GCD

/**
 * Intuition
 * we will solve this problem using dp
 * we have three choices
 * we can skip the curr no
 * add curr no to seq 1, and take gcd of curr no and existing gcd
 * add curr no to seq 2, and take gcd of curr no and existing gcd
 * we will take sum of all three and store in dp[i][first][second]
 * our base condition is both sequence are non empty and both gcd are same, we
 * have got one valid solution
 * our gcd can be equal to max element, so we have take maxEl+1 instead of 200
 * Approach
 * 
 * Complexity
 * Time complexity: O(n^3)
 * Space complexity: O(n^3)
 */

class Solution {
    int mod = (int) (1e9 + 7);
    int[][][] t;

    public int subsequencePairCount(int[] nums) {
        int n = nums.length;

        int maxEl = -1;
        for (int x : nums)
            maxEl = Math.max(maxEl, x);
        int[][][] dp = new int[n + 1][maxEl + 1][maxEl + 1];

        for (int first = 0; first <= maxEl; first++) {
            for (int second = 0; second <= maxEl; second++) {
                boolean bothNonEmpty = (first != 0 && second != 0);
                boolean gcdsMatch = (first == second);
                dp[n][first][second] = (bothNonEmpty && gcdsMatch) ? 1 : 0;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int first = maxEl; first >= 0; first--) {
                for (int second = maxEl; second >= 0; second--) {
                    int skip = dp[i + 1][first][second];
                    int take1 = dp[i + 1][gcd(first, nums[i])][second];
                    int take2 = dp[i + 1][first][gcd(second, nums[i])];
                    dp[i][first][second] = (int) ((0L + skip + take1 + take2) % mod);
                }
            }
        }

        return dp[0][0][0];
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}