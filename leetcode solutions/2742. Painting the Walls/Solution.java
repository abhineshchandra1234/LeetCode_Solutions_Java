/**
 * 2742. Painting the Walls
 * 
 * Intuition
 * 
 * From the question it is clear that we need to keep time of paid worker >=
 * time of unpaid worker for optimal solution
 * we need not sort any array, as we have n walls and the time paid workers take
 * from 1..n that many walls unpaid worker will paint, and it can be any wall of
 * any cost.
 * At every index we will find what is min cost till that index, if we pick the
 * curr wall or skip it
 * pick -> remain - curr wall(1 wall const) - equal of no of walls painted by
 * unpaid painter
 * int paint = cost[i] + dp(i + 1, remain - 1 - time[i], cost, time);
 * skip -> remaining wall and cost will remain same, as both paiters did not
 * paint any walls
 * int dontPaint = dp(i + 1, remain, cost, time);
 * 
 * Approach
 * Complexity
 * 
 * Time complexity:
 * 
 * O(n^2), dp states index, remaining walls
 * 
 * Space complexity:
 * 
 * O(n^2), dp space
 * 
 * 
 */
class Solution {

    int[][] memo;
    int n;

    public int paintWalls(int[] cost, int[] time) {
        n = cost.length;
        memo = new int[n][n + 1];
        return dp(0, n, cost, time);
    }

    public int dp(int i, int remain, int[] cost, int[] time) {
        if (remain <= 0)
            return 0;

        if (i == n)
            return (int) 1e9;

        if (memo[i][remain] != 0)
            return memo[i][remain];

        int paint = cost[i] + dp(i + 1, remain - 1 - time[i], cost, time);
        int dontPaint = dp(i + 1, remain, cost, time);
        memo[i][remain] = Math.min(paint, dontPaint);
        return memo[i][remain];
    }
}