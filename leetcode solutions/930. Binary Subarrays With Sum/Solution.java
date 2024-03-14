/**
 * 930. Binary Subarrays With Sum
 * 
 * Intuition
 * 
 * Brute Force
 * Find all sub-arrays, then take thier sum, if thier sum is equal to goal, add
 * them to count.
 * Optimal approach
 * As evident in the question we will solve this problem using sliding window
 * Expand window - We will increase the window by adding the no to currSum
 * Shrink window - We will keep decreasing window till currSum is greater than
 * goal
 * Here it would be one more condition as we can have succeding zero which will
 * have no impact on sum, but will increase sub array count
 * So we will keep shrinking window and keep a count of zeroPrefix, to determine
 * sub array count later
 * Computation - If the currSum is equal to goal we will add 1 to res
 * we also need to add zeroPrefix count as those many sub-arrays will have same
 * sum
 * res += 1 + zeroPrefix;
 * 
 * Input: nums = [1,0,1,0,1], goal = 2
 * 
 * Output: 4
 * 
 * when start = 0, end= 4, res = 2
 * 
 * then zeroPrefix cond arrives
 * 
 * 10 count is together added to res as 2, res = 2 + 2 -> 4
 * 
 * removing 1 sum is 2 [0,1,0,1]
 * 
 * removing 0 sum is again 2 [1,0,1]
 * 
 * Approach
 * 
 * we have stopped the loop at start<end, as we want non-empty subarray
 * if we allow start<=end && currSum>goal, 1 will be added to res for empty
 * subarray
 * start<end && currSum>goal is already handling start==end && currSum==goal, we
 * would have single digit equal to goal after removing second last digit
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {

    public int numSubarraysWithSum(int[] nums, int goal) {

        int i = 0, zeroPrefix = 0, res = 0, currSum = 0;

        for (int j = 0; j < nums.length; j++) {

            currSum += nums[j];

            while (i < j && (nums[i] == 0 || currSum > goal)) {

                // reset zeroPrefix counter

                if (nums[i] == 1)

                    zeroPrefix = 0;

                else

                    zeroPrefix++;

                currSum -= nums[i++];

            }

            // for 1000, 1 + 3

            // sum remains const till next 1

            if (currSum == goal)

                res += 1 + zeroPrefix;

        }

        return res;

    }

}