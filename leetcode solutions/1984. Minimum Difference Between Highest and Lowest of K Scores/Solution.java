// 1984. Minimum Difference Between Highest and Lowest of K Scores

/**
 * Intuition
 * we will sort the array, so that gap between nos are minimum
 * then we will pick k nos, and take difference of highest and lowest ie at the
 * ends of the window
 * Then we will find min among all these differences
 * Approach
 * 
 * Complexity
 * Time complexity: O(nlogn), sorting
 * Space complexity: O(logn), sorting
 */

class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i + k - 1 < n; i++)
            ans = Math.min(ans, nums[i + k - 1] - nums[i]);
        return ans;
    }
}