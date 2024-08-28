/**
 * 650. 2 Keys Keyboard
 * 
 * Intuition
 * we are given integer n, we need to return min operations to get char A, n
 * times on the screen
 * 
 * Approach
 * This problem is hard, if asked in the interview, you are gone
 * we can solve this problem through dynamic programming
 * to reach any no, we can take help of prime factors, which will be max n/2
 * so dp[n] = dp[prime_factor] + dp[n/prime_factor]
 * you can understand it by taking an example of dp[2] = 2, dp[8] = ?
 * using dp[2], find dp[8]
 * 
 * Complexity
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 */

class Solution {

    public int minSteps(int n) {

        int[] dp = new int[1001];
        Arrays.fill(dp, 1000);

        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0)
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
            }
        }
        return dp[n];
    }
}