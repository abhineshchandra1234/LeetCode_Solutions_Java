/**
 * 2134. Minimum Swaps to Group All 1's Together II
 * 
 * Intuition
 * 
 * we are given circular binary array nums
 * we need to return minimum no of swaps required to group all 1's together
 * max swaps will be equal to the total no of ones in the array
 * we will use sliding window to solve this problem
 * using sliding window, we will count no of 1's in the current window
 * total swap for current window = total no of 1's in the array - no of 1's in
 * the curr window
 * For each window we will update res with min of res and total swap for curr
 * window
 * 
 * Approach
 * 
 * Note: we are updating end first, to represent curr window correctly,
 * otherwise it will point outside the window always
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */

class Solution {

    public int minSwaps(int[] nums) {

        int n = nums.length;
        int res = Integer.MAX_VALUE;
        int totalOne = 0;

        for (int no : nums)
            totalOne += no;

        int currOne = nums[0];
        int end = 0;

        for (int start = 0; start < n; start++) {

            // shrink
            if (start != 0)
                currOne -= nums[start - 1];

            // expand
            while (end - start + 1 < totalOne) {
                end++;
                currOne += nums[end % n];
            }

            res = Math.min(res, totalOne - currOne);
        }

        return res;
    }
}
