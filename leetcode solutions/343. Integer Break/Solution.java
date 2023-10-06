/**
 * 343. Integer Break
 * 
 * Intuition
 * 
 * we will solve this problem through recursion
 * 
 * for (int j = 1; j < i; j++) {
 * int res = dfs[j] * dfs[i - j];
 * 
 * This is the basic logic
 * We are taking j value from 1 till i-1 or num-1 not num to have min 2 products
 * We are using memoization to save state and avoid repeated calculation
 * we will reach n through 1..2..3, so running a loop to calculate them first,
 * as they will be used to calculate n (outer loop)
 * dp[i], represent max product for i
 * 
 * Approach
 * 
 * dp[i] = i == n ? 0 : i;
 * If the no is n we are assigning it 0, to further break it, otherwise leave
 * the no as it is like n = 4, we need to break it
 * i = 3, we need not further break it as it is already calculated.
 * 
 * Complexity
 * 
 * Time complexity: O(n^2)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public int integerBreak(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = i == n ? 0 : i;
            for (int j = 1; j < i; j++) {
                int p = dp[j] * dp[i - j];
                dp[i] = Math.max(dp[i], p);
            }
        }
        return dp[n];
    }
}