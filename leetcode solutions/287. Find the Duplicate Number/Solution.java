/**
 * 287. Find the Duplicate Number
 * 
 * Intuition
 * 
 * credits longluo
 * we have index from 0 to n and values from 1 to n
 * for every value we will make its corresponding index value -ve.
 * So duplicate value will try to make the same index value -ve twice and we
 * will return that index or duplicate value.
 * 
 * Approach
 * 
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * here duplicate value 2 will try to make index 2 ie 4 -ve twice.
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int findDuplicate(int[] nums) {

        for (int num : nums) {
            int idx = Math.abs(num);
            if (nums[idx] < 0)
                return idx;
            nums[idx] = -nums[idx];
        }
        return -1;
    }
}