/**
 * 377. Combination Sum IV
 * 
 * Intuition
 * 
 * credits FreeTymeKiyan
 * we will solve this problem using dp
 * comb[target] = sum(comb[target - nums[i]]), where 1 <= i < nums.length, and
 * target >= nums[i]
 * any element can contribute to target if it is less than or equal to target.
 * So target will be sum of all these approaches.
 * we are trying to reach target with each element of nums
 * comb[target - nums[i]] will lead to smaller target which we have already
 * calculated
 * 
 * Input: nums = [1,2,3], target = 4
 * comb[4] = 3 + comb[4-3] -> 3 + comb[1]
 * suppose comb[1] is equal to 5
 * we can add 3 to 5 combinations to reach 4
 * so the combinations count remain same as we need just 1 more no
 * 
 * radhe radhe
 * 
 * Approach
 * 
 * dp[0] = 1, target 0 can be achieved with only no 0 so it is assigned 1.
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(n*target), for each target we are traversing whole array
 * 
 * Space complexity:
 * 
 * O(target)
 * 
 */
class Solution {
    public int combinationSum4(int[] nums, int target) {

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int n : nums) {
                if (i >= n)
                    dp[i] += dp[i - n];
            }
        }

        return dp[target];
    }
}