/**
 * 486. Predict the Winner
 * 
 * Intuition
 * 
 * we will solve this problem using dp, using top-down approach
 * dp[0,n-1] represent maxDiff player 1 can obtain over player 2 for the entire
 * array calculations
 * player 1 can either pick from left or right
 * if he picks from left total diff he gained is
 * nums[left] - maxDiff(nums, left + 1, right);
 * maxDiff(nums, left + 1, right) is the maxDiff palyer 2 has after doing all
 * the calculations over the rest of the array.
 * 
 * Complexity
 * 
 * Time complexity: O(n^2)
 * 
 * Space complexity: O(n^2)
 * 
 */
class Solution {

    Integer[][] memo;

    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        memo = new Integer[n][n];

        return maxDiff(nums, 0, n - 1) >= 0;
    }

    private int maxDiff(int[] nums, int left, int right) {

        if (memo[left][right] != null)
            return memo[left][right];

        if (left == right)
            return nums[left];

        int scoreByLeft = nums[left] - maxDiff(nums, left + 1, right);
        int scoreByRight = nums[right] - maxDiff(nums, left, right - 1);
        memo[left][right] = Math.max(scoreByLeft, scoreByRight);

        return memo[left][right];
    }
}