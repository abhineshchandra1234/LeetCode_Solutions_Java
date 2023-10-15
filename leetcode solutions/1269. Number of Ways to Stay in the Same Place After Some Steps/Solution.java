/**
 * 1269. Number of Ways to Stay in the Same Place After Some Steps
 * 
 * Intuition
 * 
 * this problem can be best understood with help of decision tree
 * we will solve this using bottom up approach
 * At each index we have three choices stay, move left, move right
 * Each of these choices will have further three choices
 * All these choices will help to return to 0, so we need to add them
 * stay -> int ans = dp[curr][remain - 1];
 * position will remain same remaining steps will reduce by 1
 * left -> ans = (ans + dp[curr - 1][remain - 1]) % mod;
 * move one position back, remaining steps will reduce by 1
 * right -> ans = (ans + dp[curr + 1][remain - 1]) % mod;
 * move one position fwd, remaining steps will reduce by 1
 * 
 * Approach
 * 
 * we have kept remaining steps in outer as we can only move in any dir or stay
 * if we have steps remaining
 * our ans is at dp[0][steps], we are slowing moving towards it using
 * tablulation.
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(n^2), dp states index and remaining steps
 * 
 * Space complexity:
 * 
 * O(n^2), dp space
 * 
 */
class Solution {
    public int numWays(int steps, int arrLen) {

        int mod = (int) 1e9 + 7;
        arrLen = Math.min(arrLen, steps);
        int[][] dp = new int[arrLen][steps + 1];
        dp[0][0] = 1;

        for (int remain = 1; remain <= steps; remain++) {
            for (int curr = arrLen - 1; curr >= 0; curr--) {
                int ans = dp[curr][remain - 1];

                if (curr > 0)
                    ans = (ans + dp[curr - 1][remain - 1]) % mod;
                if (curr < arrLen - 1)
                    ans = (ans + dp[curr + 1][remain - 1]) % mod;

                dp[curr][remain] = ans;
            }
        }
        return dp[0][steps];
    }
}