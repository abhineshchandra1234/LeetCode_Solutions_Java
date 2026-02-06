// 3634. Minimum Removals to Balance Array

/**
 * Intuition
 * we will solve this problem through sliding window
 * First short the array, so that we can get max and min elements at the ends of
 * the array
 * we will shrink the window when max > k*min
 * It will expand by default
 * At every valid window we will update maxLen with count of elements
 * we need to remove min elements, so our window should be maximum balanced
 * window
 * we would return n - maxLen, which would simbolize min no of elements removed
 * Approach
 * 
 * Complexity
 * Time complexity: O(nlogn), sorting
 * Space complexity: O(1)
 */

class Solution {
    public int minRemoval(int[] nums, int k) {

        int n = nums.length;
        Arrays.sort(nums);

        int i = 0;
        int maxLen = 1;

        for (int j = 0; j < n; j++) {
            long max = nums[j];
            long min = nums[i];

            while (i < j && max > (long) k * min) {
                i++;
                min = nums[i];
            }

            maxLen = Math.max(maxLen, j - i + 1);
        }

        return n - maxLen;
    }
}