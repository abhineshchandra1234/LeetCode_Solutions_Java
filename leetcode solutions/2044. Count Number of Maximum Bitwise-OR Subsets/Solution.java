/**
 * 2044. Count Number of Maximum Bitwise-OR Subsets
 * 
 * Intuition
 * we can solve this problem through recursion
 * First find max or for all nos
 * then we will call recursive function
 * we can take each no for every index or skip it
 * if we take the no, its or will be added to currOr
 * our base condition will be index has reached the end and currOr is equal to
 * targetOr return 1 else 0
 * our res will be sum of no of subsets with or without the curr no
 * to further optimize it we can use memoization
 * For same index, currOr value can be repeated, as seen in the recursive tree
 * so memoization states will be index and currOr
 * Approach
 * 
 * Complexity
 * Time complexity: O(n * maxOr), dp states
 * Space complexity: O(n * maxOr), dp states
 */

class Solution {
    public int countMaxOrSubsets(int[] nums) {

        int n = nums.length;
        int maxOr = 0;

        for (int num : nums) {
            maxOr |= num;
        }

        Integer[][] memo = new Integer[n][maxOr + 1];

        return helper(nums, 0, 0, maxOr, memo);
    }

    private int helper(int[] nums, int idx, int currOr, int tarOr, Integer[][] memo) {
        if (idx == nums.length)
            return (currOr == tarOr) ? 1 : 0;

        if (memo[idx][currOr] != null)
            return memo[idx][currOr];

        int without = helper(nums, idx + 1, currOr, tarOr, memo);

        int with = helper(nums, idx + 1, currOr | nums[idx], tarOr, memo);

        return memo[idx][currOr] = with + without;
    }
}