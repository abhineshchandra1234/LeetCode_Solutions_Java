// 2615. Sum of Distances

/**
 * Intuition
 * we will solve this problem through brute force
 * any no nums[i] will be equal to left computation of freq * i - sum and right
 * computation of sum - freq * i
 * we will store freq in iCount and sum of indices in iSum
 * Then we will simply traverse nums from left side to end and update res[i]
 * Then we will traverse nums from right side to end and update res[i]
 * In between traversal we can clear maps and use them
 * Finally return res
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] res = new long[n];

        Map<Integer, Long> iSum = new HashMap();
        Map<Integer, Long> iCount = new HashMap();

        for (int i = 0; i < n; i++) {
            long freq = iCount.getOrDefault(nums[i], 0L);
            long sum = iSum.getOrDefault(nums[i], 0L);

            res[i] += freq * i - sum;

            iCount.put(nums[i], freq + 1);
            iSum.put(nums[i], sum + i);
        }

        iSum.clear();
        iCount.clear();

        for (int i = n - 1; i >= 0; i--) {
            long freq = iCount.getOrDefault(nums[i], 0L);
            long sum = iSum.getOrDefault(nums[i], 0L);

            res[i] += sum - freq * i;

            iCount.put(nums[i], freq + 1);
            iSum.put(nums[i], sum + i);
        }

        return res;
    }
}