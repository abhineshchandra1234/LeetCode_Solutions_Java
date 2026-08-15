// 3702. Longest Subsequence With Non-Zero Bitwise XOR

/**
 * Intuition
 * we will take xor of all nos and store it in res
 * if the res is 0 means one no is casuing it, so we will return n-1 othwerwise
 * return n
 * there is one corner case of all zeros, in that case we will return 0
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;

        int res = 0;
        boolean allZero = true;

        for (int num : nums) {
            res ^= num;
            if (num != 0)
                allZero = false;
        }

        if (allZero)
            return 0;

        return res == 0 ? n - 1 : n;
    }
}