/**
 * 704. Binary Search
 * 
 * Intuition
 * We will solve this using two pointer approach
 * We will run a loop till both ptrs cross each other
 * We will find mid, if mid is equal to target return mid, if target is less
 * than mid discard right else discard left side
 * 
 * Approach
 * start ptr will at 0 and end ptr at last
 * We will run a loop till the start ptr is less than or equal to the right ptr
 * We will find mid, if the target is equal to mid return the mid
 * If the target is less than the mid, move right to mid-1, which means the
 * target is on the left side
 * and we don't need the right side
 * If the target is more than mid-move left to mid+1
 * 
 * Complexity
 * Time complexity:O(logn)
 * Space complexity:O(1)
 */

class Solution {
    public int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (nums[mid] == target)
                return mid;
            else if (target < nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
}