/**
 * 209. Minimum Size Subarray Sum
 * 
 * Intuition
 * 
 * credits jeantimex
 * We will solve this problem using sliding window
 * We will try to minimize the window till it staisfy the cond sum >= target, so
 * that we can get the result.
 * The end ptr will be used to expand the window and add the nos to the sum.
 * You can see we are using one ptr to expand the window and other ptr to shrink
 * the window till the specific cond is satisfied.
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < nums.length) {
            sum += nums[j++];

            while (sum >= target) {
                min = Math.min(min, j - i);
                sum -= nums[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}