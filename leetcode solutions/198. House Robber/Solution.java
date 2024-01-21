/**
 * 198. House Robber
 * 
 * Intuition
 * 
 * credits heroes3001
 * we will solve this problem using bottom-up approach
 * for each house, user can either rob current house nums[i] & prev2 house or
 * just prev1 house
 * so we will use dp and each house nums[i], will represent max value robber
 * stole till that house
 * Each house will contain max of above two choices
 * so nums[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
 * We will return this max value of the last house, which will represent max
 * value stolen till that house
 * There are two dp states involved dp[i-1] & dp[i-2], used two variables prev1
 * & prev2 to optimize the solution
 * when curr (max_stolen) will move to nums[i+1], prev2 will move to prev1, then
 * prev1 will move to curr(max_stolen)
 * Similar problems
 * [70. Climbing
 * Stairs](https://leetcode.com/problems/climbing-stairs/description/?envType=daily-question&envId=2024-01-18)
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int rob(int[] nums) {

        int prev1 = 0, prev2 = 0, max_stolen = 0;
        for (int num : nums) {
            max_stolen = Math.max(prev2 + num, prev1);
            prev2 = prev1;
            prev1 = max_stolen;
        }
        return max_stolen;
    }
}