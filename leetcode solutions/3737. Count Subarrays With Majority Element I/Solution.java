// 3737. Count Subarrays With Majority Element I

/**
 * Intuition
 * we will generate all possible subarrays using two loops
 * for any subarray, if the curr no is equal to the target increase count
 * otherwise decrease count
 * through this we need not calculate if target is the majority element
 * if the count is positive means target no is greater than non target no and we
 * will increase the res
 * Finally return the res
 * Approach
 * 
 * Complexity
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */

class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = i; j < n; j++) {
                cnt += (nums[j] == target ? 1 : -1);
                if (cnt > 0)
                    ans++;
            }
        }
        return ans;
    }
}