/**
 * 2218. Maximum Value of K Coins From Piles
 * 
 * Intuition
 * We will either include curr pile or exclude curr pile to pick coins.
 * Including curr pile means we will either pick 1 or few or total coins of curr
 * pile and rest we will pick from rest of the piles
 * Excluding curr pile means we will not pick any coin from curr pile and only
 * pick coins from other piles.
 * We will use recursion to solve this and use memoization to remember state, so
 * we will use dp
 * 
 * Approach
 * Initialize dp with rows as n+1 piles and cols as k+1 coins
 * dp[i][k] means picking k coins from piles[i] to piles[n-1]
 * we will use a helper function to solve this
 * first we will compute res excluding curr pile
 * then we will compute curr pile by picking few or all coins from curr pile and
 * rest from other piles.
 * We will update res with max of above result
 * We will return the res and store the res in i,k for futher computation.
 * 
 * Complexity
 * Time complexity:
 * O(n*k), we are computing n piles and max k coins. Also dp size is n,k
 * Space complexity:
 * O(n*k)
 */
class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        // i will be from 0->n-1, n is not needed
        // k will be inclusive of 0
        Integer[][] memo = new Integer[piles.size() + 1][k + 1];
        return dp(piles, memo, 0, k);
    }

    public int dp(List<List<Integer>> piles, Integer[][] memo, int i, int k) {
        // either k coins are consumed or all piles are computed
        if (k == 0 || i == piles.size())
            return 0;
        // it is already computed
        if (memo[i][k] != null)
            return memo[i][k];
        // excluding curr pile
        int res = dp(piles, memo, i + 1, k);
        int curr = 0;

        for (int j = 0; j < Math.min(piles.get(i).size(), k); j++) {
            curr += piles.get(i).get(j);
            // either 1 or all coins of currnt pile and rest of other piles
            // max of exclude and include
            res = Math.max(res, curr + dp(piles, memo, i + 1, k - j - 1));
        }
        return memo[i][k] = res;
    }
}