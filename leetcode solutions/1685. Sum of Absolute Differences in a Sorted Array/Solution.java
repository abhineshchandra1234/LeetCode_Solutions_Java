/**
 * 1685. Sum of Absolute Differences in a Sorted Array
 * 
 * Intuition
 * Approach 1 (Math)
 * 
 * we need do find
 * 
 * |nums[i]-nums[0]| + |nums[i]-nums[1]| + ... + |nums[i]- nums[i]|
 * + |nums[i] - nums[i+1]...
 * 
 * nums[i]- nums[i] is 0
 * total sum = left part + 0 + right part
 * we can find total sum start traversing from 0. Find left sum and right sum,
 * for each index
 * using left sum and right sum we can compute left part and right using nums[i]
 * count
 * int leftTotal = leftCount * nums[i] - leftSum;
 * int rightTotal = rightSum - rightCount * nums[i];
 * left sum will be initially 0 then nums[i] will be added to it at last.
 * right sum will be computed at start by subtracting left sum and nums[i] from
 * total sum.
 * 
 * Approach 2 (prefix sum)
 * 
 * we can first calculate prefix sum
 * using prefix sum we can find left sum and right sum while traversing, rest of
 * the part remain same.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity:
 * 
 * O(n)
 * 
 * Space complexity:
 * 
 * O(1)
 * 
 */
class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {

        int n = nums.length;
        int totalSum = 0;

        for (int num : nums)
            totalSum += num;

        int leftSum = 0;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - nums[i];

            int leftCount = i;
            int rightCount = n - 1 - i;

            int leftTotal = leftCount * nums[i] - leftSum;
            int rightTotal = rightSum - rightCount * nums[i];

            ans[i] = leftTotal + rightTotal;
            leftSum += nums[i];
        }

        return ans;
    }
}