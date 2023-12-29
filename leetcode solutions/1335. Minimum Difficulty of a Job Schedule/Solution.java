/**
 * 1335. Minimum Difficulty of a Job Schedule
 * 
 * 
 * Intuition
 * 
 * we will solve this problem using top down approach
 * If day=1, we will just find the max jobDifficulty and return it.
 * n - d is the max idx till we can divide the job
 * If n < d, there are less jobs and more days, so we return -1.
 * For every index and day left we are traversing rest of the index to pick
 * different no of jobs like 1 job, 2 jobs, 3 jobs etc to compute our res.
 * When we are traversing rest of the index we are keeping track of curr
 * maxDifficulty and updating res with min of sum of curr maxDifficulty + res of
 * rest of the array(recursion)
 * Notice idx and days state are changing, we are memoizing it, to avoid
 * repeated computation.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n∗n∗d), For every index and day left we
 * are traversing rest of the index to pick different no of jobs
 * 
 * Space complexity: O(n∗d)
 * 
 */
class Solution {
    Integer[][] memo;

    public int minDifficulty(int[] jobDifficulty, int d) {

        int n = jobDifficulty.length;
        if (n < d)
            return -1;

        memo = new Integer[n][d + 1];

        return solve(jobDifficulty, n, 0, d);
    }

    private int solve(int[] jobDifficulty, int n, int idx, int d) {

        if (memo[idx][d] != null)
            return memo[idx][d];

        if (d == 1) {
            int num = 0;
            for (int i = idx; i < n; i++)
                num = Math.max(num, jobDifficulty[i]);
            return num;
        }

        int maxDifficulty = Integer.MIN_VALUE;
        int res = Integer.MAX_VALUE;

        for (int i = idx; i <= n - d; i++) {
            maxDifficulty = Math.max(maxDifficulty, jobDifficulty[i]);
            res = Math.min(res, maxDifficulty + solve(jobDifficulty, n, i + 1, d - 1));
        }

        return memo[idx][d] = res;
    }
}