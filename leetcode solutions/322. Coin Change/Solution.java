/**
 * 322. Coin Change
 * 
 * Intuition
 * 
 * As evident in the question we will solve this problem through dp
 * We will start from base amount 0 and use that to compute rest of the amount
 * No of coins fro ith amount, will be equal to min of curr value and 1 + curr
 * value - c, where c is the coin less than the amount
 * dp[i] = Math.min(dp[i], 1 + dp[i - c]);
 * we can construct any amount by adding a suitable coin to previous amount
 * Finally we will return coins at dp[amount]
 * If max no of coins were asked just replace Math.min with Math.max
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n∗k), for every amount we are traversing each
 * coin
 * 
 * Space complexity: O(n), we are storing min coins for each amount
 * 
 */
class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        Arrays.sort(coins);

        for (int i = 1; i <= amount; i++) {
            for (int c : coins) {
                if (i - c < 0)
                    break;
                if (dp[i - c] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], 1 + dp[i - c]);
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}