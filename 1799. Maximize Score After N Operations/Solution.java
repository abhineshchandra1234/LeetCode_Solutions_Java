/**
 * 1799. Maximize Score After N Operations
 * 
 * Intuition
 * We will solve this problem using dp
 * For each operation op we will search all the possible pairs
 * For 14 numbers, we will have 2 ^ 14 = 16384 possible combinations.
 * The final result will be stored in dp[1][0] and we will return the same.
 * We will use bitmasking to mark the pair, which has been used.
 * Approach
 * mask&new_mask if new_mask is part of existing mask, it will return 1.
 * 
 * Complexity
 * Time complexity: O(n^2 * 2^n * logn)
 * O(n^2) for loops
 * 
 * O(2^n) no of subproblems or dfs
 * 
 * O(logn) gcd
 * 
 * Space complexity: O(n*2^n) (dp size)
 */
class Solution {
    public int maxScore(int[] nums) {
        int n = nums.length;
        return dfs(nums, new int[n / 2 + 1][1 << n], 1, 0);
    }

    int dfs(int[] nums, int[][] dp, int op, int mask) {
        int n = nums.length;
        if (op > n / 2)
            return 0;
        if (dp[op][mask] == 0) {
            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int new_mask = (1 << j) + (1 << k);
                    if ((mask & new_mask) == 0) {
                        dp[op][mask] = Math.max(dp[op][mask], op * gcd(nums[j], nums[k])
                                + dfs(nums, dp, op + 1, mask + new_mask));
                    }
                }
            }
        }
        return dp[op][mask];
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}