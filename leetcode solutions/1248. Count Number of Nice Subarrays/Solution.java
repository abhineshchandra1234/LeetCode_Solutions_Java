/**
 * 1248. Count Number of Nice Subarrays
 * 
 * Intuition
 * 
 * given an integer array nums, and an integer k
 * we need to return the count of sub-arrays which contain k odd nos.
 * we can solve this problem using 3 ptrs sliding window
 * we cannot use the usual sliding window as we will miss some subarrays at the
 * right and left ends
 * 
 * Approach
 * 
 * we will traverse nums and count odd nos
 * If we have unsuitable window ie odd nos are more than k, we need to shrink
 * the window
 * we will reduce l and move m to l, if l is odd we will reduce odd count
 * when we get suitable window ie odd nos is equal to k
 * we will move m to first odd no, as subarray between l and m will be part of
 * the array and will create different subarrays combinations
 * we will add length between l and m to res
 * Finally return res
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {

    public int numberOfSubarrays(int[] nums, int k) {

        int n = nums.length;
        int l = 0, m = 0;
        int res = 0, odd = 0;

        for (int r = 0; r < n; r++) {

            if (nums[r] % 2 == 1)
                odd++;

            // handle unsuitable window
            while (odd > k) {
                if (nums[l] % 2 == 1)
                    odd -= 1;
                l += 1;
                m = l;
            }

            // handle suitable scenario
            if (odd == k) {
                while (nums[m] % 2 == 0)
                    m += 1;
                res += m - l + 1;
            }
        }

        return res;
    }
}