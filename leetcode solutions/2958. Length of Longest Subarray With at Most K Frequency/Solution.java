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

        int res = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap();
        for (int left = 0, right = 0; right < n; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.get(nums[right]) > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}