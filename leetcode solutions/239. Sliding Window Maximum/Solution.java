/**
 * 239. Sliding Window Maximum
 * 
 * Intuition
 * 
 * credits flyingpenguin
 * the sliding window will start on left and move towards right till the end, we
 * need to return maximum of each window.
 * No of unique sliding window is n - k + 1
 * we will discard the indices out of the window
 * we will also start discarding indices from end of deque less than curr index.
 * then we will add the curr index.
 * this way deque will contain index greater than curr index if any and curr
 * index.
 * Then we will add top index from deque to res.
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(k)
 * 
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] r = new int[n - k + 1];
        int ri = 0;

        Deque<Integer> q = new LinkedList();
        for (int i = 0; i < nums.length; i++) {

            while (!q.isEmpty() && q.peek() < i - k + 1)
                q.poll();

            while (!q.isEmpty() && nums[q.peekLast()] < nums[i])
                q.pollLast();

            q.add(i);
            if (i >= k - 1)
                r[ri++] = nums[q.peek()];
        }
        return r;
    }
}