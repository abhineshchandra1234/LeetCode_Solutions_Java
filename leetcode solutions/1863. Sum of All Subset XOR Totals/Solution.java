/**
 * 1863. Sum of All Subset XOR Totals
 * 
 * Intuition
 * 
 * we can solve this problem using backtracking
 * we will use recursion, and for each index we will have two local XORs by
 * picking or skipping curr no
 * we will return sum of these XORs to previous index.
 * Finally return total sum as res
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(2^n), total no of subsets is 2^n ie for each index we can
 * pick no or drop it
 * 
 * Space complexity: O(n), recursion length as we are including all index
 * 
 */
class Solution {
    public int subsetXORSum(int[] nums) {

        return helper(nums, 0, 0);
    }

    private int helper(int[] nums, int index, int currXor) {

        if (index == nums.length)
            return currXor;

        int with = helper(nums, index + 1, currXor ^ nums[index]);
        int without = helper(nums, index + 1, currXor);

        return with + without;
    }
}