/**
 * 1140. Stone Game II
 * 
 * Intuition
 * This problem is tricky it should be under hard.
 * Its not cool to see soln and brag or assume einstein
 * It is difficult to understand and explain
 * If curr player picks m piles, next player will have an option to pick 1 to
 * 2*m piles.
 * input p=[2,7,9]
 * suppose alice picks 1 pile
 * Alice take = 18 - 16 = 2
 * res = 2 + 16 - max bob take
 * Now bob will pick next
 * Bob can pick max 16
 * since bob is last player it gets all 16.
 * res = 2 + 16 - (16) = 2 alice take
 * input p=[2,7,9]
 * suppose alice picks 2 pile
 * Alice take = 18 - 9 = 9
 * res = 9 + 9 - max bob take
 * Now bob will pick next
 * Bob can pick max 9
 * since bob is last player it gets all 9.
 * res = 9 + 9 - (9) = 9
 * Note Suppose bob has the option to pick max 2 piles but he gets max take on 1
 * pile then he will only pick 1 pile.
 * It gets complicated on larger sets.
 * max 1 player take = curr take of 1 player + max 2 player can take - actual 2
 * player take.
 * 
 * Complexity
 * Time complexity: O(n^3)
 * Space complexity: O(n^2)
 */
class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] presum = Arrays.copyOf(piles, n);
        for (int i = n - 2; i >= 0; i--)
            presum[i] += presum[i + 1];
        return dfs(presum, 1, 0, new int[n][n]);
    }

    private int dfs(int[] presum, int m, int p, int[][] memo) {
        // last player takes all
        if (p + 2 * m >= presum.length)
            return presum[p];

        if (memo[p][m] > 0)
            return memo[p][m];

        int res = 0, take = 0;
        for (int i = 1; i <= 2 * m; i++) {
            // current take
            take = presum[p] - presum[p + i];
            // take max of current + what lefts from other player max take
            res = Math.max(res, take + presum[p + i] - dfs(presum, Math.max(i, m), p + i, memo));
        }
        memo[p][m] = res;
        return res;
    }
}