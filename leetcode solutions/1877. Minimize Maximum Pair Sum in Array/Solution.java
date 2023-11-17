/**
 * 1877. Minimize Maximum Pair Sum in Array
 * 
 * Intuition
 * 
 * credits lee215
 * we need to minimize the maximum pair sum, we can do this if we simply
 * minimize each pair sum
 * we can do this by pairing max with min nos subsequently
 * 
 * Approach
 * 
 * so we sorted the array to get max and min pair and used two ptrs to traverse
 * them
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(nlogn), sorting
 * 
 * Space complexity:
 * 
 * O(1)
 * 
 */
class Solution {
    public int minPairSum(int[] nums) {

        Arrays.sort(nums);
        int res = 0, n = nums.length;
        for (int i = 0; i < n / 2; i++)
            res = Math.max(res, nums[i] + nums[n - i - 1]);
        return res;
    }
}