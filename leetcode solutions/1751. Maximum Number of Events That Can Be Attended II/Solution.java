/**
 * 1751. Maximum Number of Events That Can Be Attended II
 * 
 * Intuition
 * 
 * credits Invulnerable
 * It is a an standard 0/1 knapsack problem.
 * We have two options
 * We can either skip curr event then there will be no change in profit
 * We can attend curr event then the next event whoes start is greater than its
 * end day.
 * We will store the max of these two options in dp.
 * to find next event we need to sort the events
 * 
 * Approach
 * 
 * we will have dp[pos][k]
 * dp[0][k] will contain our answer and it will solve it in bottom-up approach.
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(n*k*logn), O(n*k) -> dp, O(logn) -> binary search to find next event.
 * 
 * Space complexity:
 * 
 * O(n*k) -> dp
 * 
 */
class Solution {
    public int maxValue(int[][] events, int k) {

        int n = events.length;
        Arrays.sort(events, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        Integer[][] dp = new Integer[n + 1][k + 1];
        return solve(dp, events, n, 0, k);
    }

    private int solve(Integer[][] dp, int[][] events, int n, int pos, int k) {

        if (pos >= n || k == 0)
            return 0;

        if (dp[pos][k] != null)
            return dp[pos][k];

        int i = binarySearch(events, pos + 1, events.length - 1, events[pos][1]);

        return dp[pos][k] = Math.max(solve(dp, events, n, pos + 1, k),
                events[pos][2] + solve(dp, events, n, i, k - 1));
    }

    private int binarySearch(int[][] events, int l, int h, int target) {

        while (l <= h) {

            int mid = l + (h - l) / 2;
            if (events[mid][0] <= target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }

        }
        return l;
    }
}