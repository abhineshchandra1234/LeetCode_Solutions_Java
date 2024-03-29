/**
 * 2962. Count Subarrays Where Max Element Appears at Least K Times
 * 
 * Intuition
 * 
 * we will solve this problem through sliding window
 * It is asking res of max no of whole array and not of any subarray, so we can
 * calculate max at start
 * the tricky part in sliding window is calculating no of subarrays for each
 * valid window
 * here no of subarrays for valid window will be n-j, as we have already got max
 * no occuring atleast k times, no after j are all valid and contribute to total
 * subarrays
 * It is fixed sliding window problem where we expand window by 1 till it
 * reaches end
 * we shrink window when we have atleast k max nos, to find different sub-arrays
 * 
 * Approach
 * 
 * Input: nums = [1,3,2,3,3], k = 2
 * Output: 6
 * 3 is max
 * 1, 3, 2, 3 -> first valid window
 * first valid window subarrays -> n-j -> 5-3 -> 2 -> [1, 3, 2, 3], [1, 3, 2, 3,
 * 3]
 * [1, 3, 2, 3, 3] valid as we have already got max no k times
 * [1, 3, 2, 3, 5]
 * [1, 3, 2, 3, 3, 5]
 * [1, 3, 2, 3, 1, 1, 1]
 * you can see different variants of valid n-j
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public long countSubarrays(int[] nums, int k) {

        int max = Integer.MIN_VALUE;
        for (int no : nums)
            max = Math.max(max, no);

        int n = nums.length, maxCount = 0;
        long res = 0;
        for (int i = 0, j = 0; j < n; j++) {

            if (nums[j] == max)
                maxCount++;

            while (maxCount >= k) {
                res += n - j;
                if (nums[i++] == max)
                    maxCount--;
            }
        }
        return res;
    }
}