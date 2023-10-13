/**
 * 746. Min Cost Climbing Stairs
 * 
 * Intuition
 * 
 * credits MrAke
 * we will solve this problem using bottom up approach
 * It will take 0 cost to reach step 0 or 1. As we are starting from it.
 * We can reach each step either from 1 or 2 steps back
 * dp[i] will store the min cost to reach ith step which will be the min of (
 * cost to reach from 1 step back + cost to reach from 2 step back)
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[n];
    }
}