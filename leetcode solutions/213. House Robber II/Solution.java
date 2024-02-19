/**
 * 213. House Robber II
 * 
 * Intuition
 * 
 * credits jianchao-li
 * It is very similar to house robber problem
 * we cannot rob 0 and n house together
 * so our res will max of robbery(0,n-2) && robbery(1, n-1)
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

        int n = nums.length;
        if (n == 1)
            return nums[0];

        return Math.max(robber(nums, 0, n - 2), robber(nums, 1, n - 1));
    }

    private int robber(int[] nums, int l, int r) {
        int prev2 = 0, prev1 = 0, max = 0;
        for (int i = l; i <= r; i++) {
            max = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = max;
        }
        return max;
    }
}