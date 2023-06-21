/**
 * 2448. Minimum Cost to Make Array Equal
 * 
 * Intuition
 * 
 * for Input: nums = [1,3,5,2], cost = [2,3,1,14]
 * we will sort the nums first
 * nums = [1,2,3,5], cost=[2,14,3,1]
 * min - 1, max - 5
 * Cost to convert all elements to min or max is very high.
 * mid - 2, 3
 * You will find cost to convert all elements to mid is low.
 * So we use mid or median to find our result.
 * Note - we need min and max values, so it is not necessary to sort the array.
 * 
 * cost of 2 - 2+3+3 = 8
 * cost of 3 - 4+14+2 = 20
 * cost of 1 - 14+6+4 = 24
 * cost of 5 - 8+42+6 = 56
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(nlogn), we are doing binary search O(logn)
 * 
 * finding cost each time O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public long minCost(int[] nums, int[] cost) {

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for (int num : nums) {
            left = Math.min(num, left);
            right = Math.max(num, right);
        }
        long ans = 0L;
        while (left < right) {
            int mid = left + (right - left) / 2;
            long y1 = findCost(nums, cost, mid);
            long y2 = findCost(nums, cost, mid + 1);
            ans = Math.min(y1, y2);
            if (y1 < y2)
                right = mid;
            else
                left = mid + 1;
        }
        return ans;
    }

    private long findCost(int[] nums, int[] cost, long x) {
        long res = 0L;
        for (int i = 0; i < nums.length; i++)
            res += Math.abs(nums[i] - x) * cost[i];
        return res;
    }
}