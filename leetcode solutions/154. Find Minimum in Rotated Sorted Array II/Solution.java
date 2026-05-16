// 154. Find Minimum in Rotated Sorted Array II

/**
 * Intuition
 * we can solve this problem through binary serach
 * since it contains duplicates, we will first skip duplicates on left and right
 * side, then apply binary search
 * left and right ptr will point to start and end of nums array
 * we will find mid
 * compare mid with resIdx, if mid is less than resIdx, replace resIdx with mid
 * Then compare mid with left and right ptrs
 * if mid is greater than r, means min lies on right side, move left to mid +1
 * if mid is less than r, means min lies on left side, move right to mid-1
 * Approach
 * 
 * Complexity
 * Time complexity: O(n) skiping duplicates, O(logn) without dulicates
 * Space complexity: O(1)
 */

class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, resIdx = 0;

        while (l <= r) {
            // remove left duplicates
            while (l < r && nums[l] == nums[l + 1])
                l++;
            // remove right duplicates
            while (l < r && nums[r] == nums[r - 1])
                r--;
            int mid = l + (r - l) / 2;

            if (nums[mid] < nums[resIdx])
                resIdx = mid;
            // min is on right side
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            }
            // min is on left side
            else {
                r = mid - 1;
            }
        }
        return nums[resIdx];
    }
}