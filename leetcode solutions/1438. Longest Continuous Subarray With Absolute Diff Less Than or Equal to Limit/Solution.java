/**
 * 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to
 * Limit
 * 
 * Intuition
 * 
 * given an integer array nums and integer limit
 * we need to return length of longest subarray, such that difference of any 2
 * elements is less than or equal to limit
 * To check the condition, we can simply take the difference of max and min no
 * of subarray to check its feasibilty
 * The brute force will take O(n^2) time, if we run a loop for each no
 * we will use sliding window and monotonic stack to solve this problem
 * we will traverse nums and maintain both stack
 * we will check if diff of max and min is beyond the limit using stacks, if it
 * is shrink the window
 * we will remove the leftmost no from stacks, and increase left ptr
 * Now we have a suitable window we will update max with the curr size.
 * Finally return max as res
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public int longestSubarray(int[] nums, int limit) {

        LinkedList<Integer> incr = new LinkedList();
        LinkedList<Integer> decr = new LinkedList();
        int max = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {

            int n = nums[r];

            while (incr.size() > 0 && n < incr.peekLast())
                incr.pollLast();
            incr.add(n);

            while (decr.size() > 0 && n > decr.peekLast())
                decr.pollLast();
            decr.add(n);

            while (decr.peekFirst() - incr.peekFirst() > limit) {
                if (decr.peekFirst() == nums[l])
                    decr.pollFirst();
                if (incr.peekFirst() == nums[l])
                    incr.pollFirst();
                l++;
            }

            int size = r - l + 1;
            max = Math.max(max, size);
        }

        return max;
    }
}