// 3689. Maximum Total Subarray Value I

/**
 * Intuition
 * we need to find subarray which will have max value and min value
 * these two are global values and need to be part of the original array
 * so we will take whole array, find its max and min value
 * then we will take a difference of these values and multiply it by k, since we
 * can take same subarray multiple times
 * the resultant will be our answer and we will return it
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int m1 = Integer.MAX_VALUE;
        int m2 = Integer.MIN_VALUE;
        for (int x : nums) {
            m1 = Math.min(m1, x);
            m2 = Math.max(m2, x);
        }
        return (long) (m2 - m1) * k;
    }
}