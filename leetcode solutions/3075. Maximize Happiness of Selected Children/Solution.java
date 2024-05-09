/**
 * 3075. Maximize Happiness of Selected Children
 * 
 * Intuition
 * Given
 * 
 * we have been given n children happiness
 * we have to pick k children happiness in k turns
 * If we pick one children rest children happiness will reduce by 1
 * min happiness of a children can be 0
 * 
 * Target
 * 
 * we need to maximize our picked k children happiness
 * 
 * Solution
 * 
 * The evident approach is the solution
 * we will solve it through greedy, ie pick optimal solution at each step
 * we will first sort the happiness array
 * then max happiness will be at the end, so we will pick k hapiness from the
 * end, and reduce each happiness by the res size ie use a counter here to count
 * prev picked
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(nlogn), sorting
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {

        Arrays.sort(happiness);
        int n = happiness.length, c = 0;
        long res = 0;

        for (int i = n - 1; i >= n - k; i--) {
            happiness[i] = Math.max(happiness[i] - c++, 0);
            res += happiness[i];
        }

        return res;
    }
}