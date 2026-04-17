// 3379. Transformed Array

/**
 * Intuition
 * we will traverse the array
 * we will find the count of shift using nums[i]%n
 * then we will calculate newIdx by adding shift to it, it can overflow so
 * modulo by n is required
 * newIdx can be negative because of shifting of negative number, so add n to
 * newIdx
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public int[] constructTransformedArray(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int shift = nums[i] % n;
            int newIdx = (i + shift) % n;

            if (newIdx < 0) {
                newIdx += n;
            }

            res[i] = nums[newIdx];
        }

        return res;
    }
}