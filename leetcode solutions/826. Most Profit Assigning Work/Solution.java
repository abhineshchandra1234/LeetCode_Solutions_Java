/**
 * 826. Most Profit Assigning Work
 * 
 * Intuition

    you have n jobs, with thier difficulties and profits
    you have m workers, with thier max capacity of work
    Return the max profit, after assigning jobs to the workers
    For desired result we need to assign most profitable job to the worker-
    According to its skill level, as they can do max 1 job
    And same job can be picked by the multiple worker

Approach

    We will follow the evident approach in the question
    we will create a job entity, by combining difficulty and profit
    we will sort the jobs based on difficulty
    then we will sort the workers based on capacity
    then we will traverse each worker
    for each worker we will traverse job once and add the max profit of all the suitable jobs to res
    we traverse job once as we have got max profit for that particular capacity
    and next capacities are much larger and can use the same profit or a higher profit

Complexity

    Time complexity: O(nlogn), sorting

    Space complexity: O(n), storing job details

 */
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        int n = profit.length;
        int[][] job = new int[n][2];

        for (int i = 0; i < n; i++) {
            job[i][0] = difficulty[i];
            job[i][1] = profit[i];
        }

        Arrays.sort(job, (a, b) -> a[0] - b[0]);
        Arrays.sort(worker);

        int j = 0, res = 0, best = 0;
        for (int i = 0; i < worker.length; i++) {
            while (j < n && worker[i] >= job[j][0]) {
                best = Math.max(best, job[j][1]);
                j++;
            }
            res += best;
        }

        return res;
    }
}
