/**
 * 2966. Divide Array Into Arrays With Max Difference
 * 
 * Intuition
 * 
 * we need to divide the whole array into sub-arrays of size 3
 * Difference of nos should be max k in each sub-array
 * the condition "Each element of nums should be in exactly one array." is not
 * followed as there are duplicates nos present in one or more array
 * we will sort the array and compare i & i+2 diff if it is less than k, add i,
 * i+1, i+2 at ith position in res
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n∗logn), sorting
 * 
 * Space complexity: O(logn), sorting
 * 
 */
class Solution {
    public int[][] divideArray(int[] nums, int k) {

        Arrays.sort(nums);
        int n = nums.length;
        int[][] ans = new int[n / 3][3];
        for (int i = 0; i < n; i += 3) {
            if (nums[i + 2] - nums[i] > k)
                return new int[0][0];
            ans[i / 3] = new int[] { nums[i], nums[i + 1], nums[i + 2] };
        }
        return ans;
    }
}