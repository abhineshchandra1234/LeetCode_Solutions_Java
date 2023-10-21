/**
 * 1425. Constrained Subsequence Sum
 * 
 * Intuition
 * 
 * credits lee215
 * we can best understand this problem using dp
 * Each dp[i] represents max sum till that index including curr element
 * dp[i] = nums[i] + Math.max(dp[i-1]+dp[i-2]+..+dp[i-k])
 * that's it we have solved our problem
 * to further optimize it we will use queue to keep track of max and sliding
 * window, so that j-i>=k
 * radhe radhe :)
 * 
 * Approach
 * 
 * Input: nums = [10,2,-10,5,20], k = 2
 * Output: 37
 * 10-> "" -> 10
 * 2 -> 10 -> 10 + 2 -> 12
 * -10 -> 10, 12 -> -10 + 12 -> 2
 * 5-> 12, 2 -> 12 + 5 -> 17
 * 20 -> 2, 17 -> 20 + 17 -> 37
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(n), we are traversing each element once
 * 
 * Space complexity:
 * 
 * O(k), max size of queue
 * 
 */
class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {

        int res = nums[0];
        Deque<Integer> q = new LinkedList();
        for (int i = 0; i < nums.length; i++) {
            // create dp and update max
            nums[i] += !q.isEmpty() ? q.peek() : 0;
            res = Math.max(res, nums[i]);
            // update queue or sliding window
            while (!q.isEmpty() && nums[i] > q.peekLast())
                q.pollLast();
            if (nums[i] > 0)
                q.add(nums[i]);
            if (i >= k && !q.isEmpty() && q.peek() == nums[i - k])
                q.poll();
        }
        return res;
    }
}