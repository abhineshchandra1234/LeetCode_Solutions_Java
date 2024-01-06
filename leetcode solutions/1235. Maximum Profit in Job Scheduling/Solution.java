/**
 * 1235. Maximum Profit in Job Scheduling
 * 
 * Intuition
 * 
 * we will solve this problem using top - down approach
 * we will first sort jobs based on start time then it is simple 0/1 knapsack
 * problem
 * we will use dfs to find profit if we include curr job or exclude it
 * then we will just return max of above two values ie inclProf & exclProf.
 * to avoid repeated computation we will store index and profit as states in dp
 * for jobs.
 * we will create job object for our convience and store it in array.
 * job object will consist of startTime, endTime and profit
 * 
 * Approach
 * 
 * if we include curr job we need to call dfs on next suitable job
 * the next suitable job will have start time >= end time of curr job
 * we can find suitable job linearly or through binary search as jobs are sorted
 * based on starting time, and we need job with suitable start time.
 * if we exclude curr job we will call dfs directly on next job ie curr+ 1
 * 
 * Complexity
 * 
 * Time complexity: O(nlogn), we are traversing each job, then
 * finding next suitable job through binary search
 * 
 * Space complexity: O(n), dp states are job index and profit and we are
 * storing these values for n jobs
 * 
 */
class Solution {

    private Map<Integer, Integer> dp;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];

        for (int i = 0; i < n; i++)
            jobs[i] = new int[] { startTime[i], endTime[i], profit[i] };

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        dp = new HashMap();
        return dfs(0, jobs);
    }

    private int dfs(int curr, int[][] jobs) {
        if (curr == jobs.length)
            return 0;

        if (dp.containsKey(curr))
            return dp.get(curr);

        int next = findNext(curr, jobs);
        int inclProf = jobs[curr][2] + (next == -1 ? 0 : dfs(next, jobs));
        int exclProf = dfs(curr + 1, jobs);

        dp.put(curr, Math.max(inclProf, exclProf));
        return Math.max(inclProf, exclProf);
    }

    private int findNext(int curr, int[][] jobs) {
        int lo = curr + 1;
        int hi = jobs.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (jobs[mid][0] >= jobs[curr][1]) {
                if (jobs[mid - 1][0] >= jobs[curr][1])
                    hi = mid - 1;
                else
                    return mid;
            } else
                lo = mid + 1;
        }
        return -1;
    }
}