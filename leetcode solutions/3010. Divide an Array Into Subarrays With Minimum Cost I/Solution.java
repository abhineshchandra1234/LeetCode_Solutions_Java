// 3010. Divide an Array Into Subarrays With Minimum Cost I

/**
 * Intuition
 * we cannot skip first no, as it is asking for subarray not subsequence
 * Then we will find first min and sec min
 * Then return sum of all three
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        int first = nums[0];
        int sec = Integer.MAX_VALUE;
        int thir = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            if (nums[i] < sec) {
                thir = sec;
                sec = nums[i];
            } else if (nums[i] < thir)
                thir = nums[i];
        }

        return first + sec + thir;
    }
}