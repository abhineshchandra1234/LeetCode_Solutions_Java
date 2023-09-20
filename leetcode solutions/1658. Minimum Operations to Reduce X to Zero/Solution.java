/**
 * 1658. Minimum Operations to Reduce X to Zero
 * 
 * Intuition
 * 
 * credits GoAheadShaun
 * we can rephrase this question, we need to discard elements at the end, so
 * there must be some element in the middle which we need to save.
 * If we maximize the length of middle elements to save we can minimize the
 * extreme elements to discard.
 * Extreme elements total would be x, middle element total will be sum-x
 * x + (sum-x) = sum of whole array
 * to minimize x we need to maximize (sum-x)
 * 
 * Approach
 * 
 * we will use sliding window to solve this, as the window total becomes equal
 * to (sum-x) we got one possible soln and would update the maxLength
 * finally result will be totalLength - maxLength
 * 
 * Input: nums = [1,1,4,2,3], x = 5
 * Output: 2
 * l=0, r=2
 * sum - x = 6
 * ml = 5-3 = 2
 * Input: nums = [3,2,20,1,1,3], x = 10
 * Output: 5
 * l=2, r=2
 * sum - x = 20
 * ml = 6-1 = 5
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int minOperations(int[] nums, int x) {

        int sum = 0;
        for (int num : nums)
            sum += num;

        int maxLength = -1, currSum = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            currSum += nums[r];
            while (l <= r && currSum > sum - x)
                currSum -= nums[l++];
            if (currSum == sum - x)
                maxLength = Math.max(maxLength, r - l + 1);
        }

        return maxLength == -1 ? -1 : nums.length - maxLength;
    }
}