// 1752. Check if Array Is Sorted and Rotated

/**
 * Intuition
 * we will clone nums array, then sort the resultant array
 * then check for each rotation if the resulatant array is equal to nums or not
 * If it is equal return true
 * At last return false, if none of nums array is equal to resultant array
 * Approach
 * 
 * Complexity
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 */

class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        for (int r = 0; r < n; r++) {
            boolean isSorted = true;
            for (int i = 0; i < n; i++) {
                if (sorted[i] != nums[(i + r) % n]) {
                    isSorted = false;
                    break;
                }
            }
            if (isSorted)
                return true;
        }

        return false;
    }
}

/**
 * Intuition 2
 * we will check for peak, in the rotated array there will be max 1 peak
 * if the peak count is more than one, array is not sorted
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int peak = 0;
        for (int i = 0; i < n; i++)
            if (nums[i] > nums[(i + 1) % n])
                peak++;
        return peak <= 1;
    }
}