/*
 * 33. Search in Rotated Sorted Array
 * 
 * Intuition
 * 
 * I will use binary search to solve this problem.
 * we will first compare with mid, if it is equal to target return mid
 * Then we will search the left side if it is sorted, then update both the ptrs
 * If left side is not sorted means right side is sorted and we will search the
 * target there.
 * un-sorted half will also have some sorted part, and we can do binary search
 * on sorted array, that we are trying to achieve through this approach.
 * ex of unsorted array
 * initial - [0,1,2,4,5,6,7] pivot index - 6
 * final - [7,0,1,2,4,5,6]
 * 
 * Approach
 * 
 * sorted cond nums[l] <= nums[mid]
 * 
 * Complexity
 * 
 * Time complexity: O(logn)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int search(int[] nums, int target) {

        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[l] <= nums[mid]) {
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
        return -1;
    }
}