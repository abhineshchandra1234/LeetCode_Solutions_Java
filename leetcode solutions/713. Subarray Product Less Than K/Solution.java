/***
 * 
 * 713. Subarray Product Less Than K
 * 
 * Intuition
 * 
 * we will solve this problem using two ptrs and sliding window
 * right ptr will expand the window and contain total product
 * left ptr will shrink the window till product becomes less than k
 * No of subarrays for current window will be equal to its size ie right - left
 * + 1 and will be added to res
 * 
 * Approach
 * Input: nums = [10,5,2,6], k = 100
 * Output: 8
 * 10
 * 5, [10, 5]
 * 2, [5, 2]
 * 6, [2,6], [5, 2, 6]
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k <= 1)
            return 0;

        int product = 1, total = 0, n = nums.length;

        for (int left = 0, right = 0; right < n; right++) {
            product *= nums[right];

            while (product >= k)
                product /= nums[left++];

            total += right - left + 1;
        }

        return total;
    }
}