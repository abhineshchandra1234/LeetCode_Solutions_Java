/**
 * 34. Find First and Last Position of Element in Sorted Array
 * 
 * Intuition
 * 
 * I have used binary search algorithm to find left and right index of element
 * in duplicates array
 * One thing I have added here is to check if the element exists or not, which
 * is important
 * radhe radhe :)
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(logn)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findLeft(nums, target);
        result[1] = findRight(nums, target);
        return result;
    }

    private int findLeft(int[] nums, int target) {
        int left = 0, right = nums.length;
        Boolean exist = false;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else {
                right = mid;
                if (nums[mid] == target)
                    exist = true;
            }

        }
        return exist ? left : -1;
    }

    private int findRight(int[] nums, int target) {
        int left = 0, right = nums.length;
        Boolean exist = false;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
                if (nums[mid] == target)
                    exist = true;
            }

        }
        return exist ? right - 1 : -1;
    }
}