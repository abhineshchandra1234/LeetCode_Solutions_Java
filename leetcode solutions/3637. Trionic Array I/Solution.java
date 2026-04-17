// 3637. Trionic Array I

/**
 * Intuition
 * we will first check increasing sequence using linear iteration
 * If i is at intial index or reach end, means we cannot check next two steps
 * return false
 * Then we will check decreasing sequence
 * Again check if i has reached end
 * Then again check increasing sequence
 * now finally check if i has reached end, means we have got our 3 parts, return
 * true
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public boolean isTrionic(int[] nums) {

        int n = nums.length;
        int i = 0;

        // increasing
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }
        if (i == 0 || i == n - 1)
            return false;
        // decreasing
        while (i + 1 < n && nums[i] > nums[i + 1]) {
            i++;
        }
        if (i == n - 1)
            return false;
        // increasing
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }
        return i == n - 1;
    }
}