// 3904. Smallest Stable Index II

/**
 * Intuition
 * we will store min from curr index to last in an array
 * we do this by traversing from last
 * then we will traverse from start and calculate max on the fly
 * then we will just calculate diff between max and min for curr index
 * if the diff is less than or equal to k, return the curr index
 * At last return -1, if no index is found
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        int[] minIdx = new int[n];
        int min = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            minIdx[i] = min;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);

            if (max - minIdx[i] <= k)
                return i;
        }

        return -1;
    }
}