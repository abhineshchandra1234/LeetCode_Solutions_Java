/**
 * 81. Search in Rotated Sorted Array II
 * 
 * Intuition
 * 
 * credits vanAmsen
 * This problem is similar to Search in Rotated Sorted Array and has similar
 * solution.
 * here we will discard duplicates by comparing start and mid, if they are equal
 * increment start.
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(n), in case of many duplicates
 * 
 * Space complexity:
 * 
 * O(1)
 * 
 */
class Solution {
    public boolean search(int[] nums, int target) {

        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target)
                return true;
            if (nums[l] == nums[mid]) {
                l++;
                continue;
            }
            if (nums[l] <= nums[mid]) {
                if (target >= nums[l] && target < nums[mid])
                    r = mid - 1;
                else
                    l = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[r])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }
        return false;
    }
}