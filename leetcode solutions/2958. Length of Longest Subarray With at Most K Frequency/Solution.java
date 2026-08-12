/**
 * 2958. Length of Longest Subarray With at Most K Frequency
 * 
 * Intuition
 * 
 * here the brute force is the optimized approach
 * we will maintain a hashmap to store freq of each no
 * we will expand the window using right ptr
 * we will update freq of each no
 * we will keep shrinking window till the curr no freq becomes less than or
 * equal to k, we do not need to maintain max freq
 * we will update res with max of window size, for each suitable window
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> mp = new HashMap();

        int i = 0, j = 0, res = 0;

        while (j < n) {
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);

            while (i < j && mp.getOrDefault(nums[j], 0) > k) {
                mp.put(nums[i], mp.get(nums[i]) - 1);
                if (mp.get(nums[i]) == 0)
                    mp.remove(nums[i]);
                i++;
            }

            res = Math.max(res, j - i + 1);
            j++;
        }

        return res;
    }
}