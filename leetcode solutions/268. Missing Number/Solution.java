/**
 * 268. Missing Number
 * 
 * Intuition
 * 
 * Approach 1
 * credits mo10
 * We can use xor operation to solve this
 * In a complete array there would value for every index(nums[i]==i) from 0 to n
 * Approach 2
 * we will take the total sum for n nos and diff will be our res
 * if diff is 0 missing is 0 as one no is mandatory missing
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */

// Code 1
class Solution {
    public int missingNumber(int[] nums) {

        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++)
            xor = xor ^ i ^ nums[i];

        return xor ^ i;
    }
}

// Code 2
class Solution {
    public int missingNumber(int[] nums) {

        int n = nums.length;
        int expectedTotal = (n * (n + 1)) / 2;

        int total = 0;
        for (int num : nums)
            total += num;

        return expectedTotal - total;
    }
}