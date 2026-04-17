// 3640. Trionic Array II

/**
 * Intuition
 * In solve method we are starting from 0 index and 0 trend
 * if we have reach out of bounds and trend is 3 we will return 0 as it is valid
 * otherwise negative infinity
 * if memo is not infinity, means it is already solved return it
 * if trend is 0, means trend 1 hasnt started yet, skip the curr no and move to
 * next
 * if trend is 3, take the curr no
 * if it is a valid index
 * Calculate curr and next
 * if trend is 0 and is incresing
 * take the curr no and solve from next index
 * if trend is 1
 * And it is increasing take curr and solve from next
 * And if it is decreasing take curr and solve from next with trend 2
 * if trend is 2
 * if it is decresing means trend 2 is still going, take the curr no
 * if it is increasing means trend 3 has started, take the curr and solve from
 * next using trend 3
 * if it is trend 3 and increasing
 * take the curr no and solve from next
 * Finally take max of skip and take, store it in memo and return it
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

class Solution {
    int n;
    long[][] memo;
    long NEG_INF = Long.MIN_VALUE / 2;

    public long maxSumTrionic(int[] nums) {
        n = nums.length;
        memo = new long[n][4];

        for (int i = 0; i < n; i++)
            Arrays.fill(memo[i], Long.MIN_VALUE);

        return solve(0, 0, nums);
    }

    long solve(int i, int trend, int[] nums) {
        if (i == n)
            return (trend == 3) ? 0 : NEG_INF;
        if (memo[i][trend] != Long.MIN_VALUE)
            return memo[i][trend];
        long take = NEG_INF;
        long skip = NEG_INF;

        if (trend == 0)
            skip = solve(i + 1, 0, nums);
        if (trend == 3)
            take = nums[i];

        if (i + 1 < n) {
            int curr = nums[i];
            int next = nums[i + 1];

            if (trend == 0 && next > curr)
                take = Math.max(take, curr + solve(i + 1, 1, nums));
            else if (trend == 1) {
                if (next > curr)
                    take = Math.max(take, curr + solve(i + 1, 1, nums));
                else if (next < curr)
                    take = Math.max(take, curr + solve(i + 1, 2, nums));
            } else if (trend == 2) {
                if (next < curr)
                    take = Math.max(take, curr + solve(i + 1, 2, nums));
                else if (next > curr)
                    take = Math.max(take, curr + solve(i + 1, 3, nums));
            } else if (trend == 3 && next > curr)
                take = Math.max(take, curr + solve(i + 1, 3, nums));
        }
        return memo[i][trend] = Math.max(take, skip);
    }
}