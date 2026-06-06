// 2574. Left and Right Sum Differences

/**
 * Intuition
 * we will solve this problem using two variables lSum, rSum
 * we will traverse nums from left to right and update curr idx in res with lsum
 * and update lsum with sum of curr idx of nums
 * Then we will traverse nums from right to left and update curr idx in res with
 * diff of curr idx of res and rSum and update rSum with sum of curr idx of nums
 * Finally return res array
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int lSum = 0;
        for (int i = 0; i < n; i++) {
            ans[i] = lSum;
            lSum += nums[i];
        }

        int rSum = 0;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = Math.abs(ans[i] - rSum);
            rSum += nums[i];
        }

        return ans;
    }
}