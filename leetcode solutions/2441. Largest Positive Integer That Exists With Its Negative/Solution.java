/**
 * 2441. Largest Positive Integer That Exists With Its Negative
 * 
 * Intuition
 * 
 * we can easily solve this problem using set in O(n) space.
 * to further optimize space we can solve it using 2 pointers
 * we need to first sort the array, min element will be at the start and abs of
 * min element if it exists will be at the end
 * Then we will take sum of both ptrs if it is equal to 0, then abs no exists
 * and return it
 * if the sum is less than 0, there is a mismatch with negative no as greater,
 * we will move start ptr
 * similarly if sum is greater than 0 increase end ptr
 * If the loop is finished we did not get any res, means there is no matching
 * pair, return -1.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(nlogn), sorting
 * 
 * Space complexity: O(logn), sorting
 * 
 */
class Solution {
    public int findMaxK(int[] nums) {

        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;

        while (start < end) {
            if (nums[start] + nums[end] == 0)
                return nums[end];
            else if (nums[start] + nums[end] < 0)
                start++;
            else
                end--;
        }
        return -1;
    }
}