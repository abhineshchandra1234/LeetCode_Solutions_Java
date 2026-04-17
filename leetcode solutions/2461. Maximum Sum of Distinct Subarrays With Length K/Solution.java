/**
 * 2461. Maximum Sum of Distinct Subarrays With Length K
 * 
 * Intuition
 * we can solve this problem through sliding window
 * to know whether all nos are distinct in the subarray, check the size of the
 * hashmap
 * if the window size is more shrink the window, by decreasing no count in the
 * map
 * if the count is 0, remove the no from the map
 * if the window size is k, and all nos are distinct
 * update res with curr_sum
 * 
 * Approach
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        long res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        long curr_sum = 0;

        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            curr_sum += nums[r];
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            if (r - l + 1 > k) {
                map.put(nums[l], map.getOrDefault(nums[l], 0) - 1);
                if (map.getOrDefault(nums[l], 0) == 0)
                    map.remove(nums[l]);
                curr_sum -= nums[l];
                l += 1;
            }

            if (map.size() == k && r - l + 1 == k)
                res = Math.max(res, curr_sum);
        }
        return res;
    }
}