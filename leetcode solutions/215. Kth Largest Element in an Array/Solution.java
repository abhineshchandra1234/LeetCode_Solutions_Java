/**
 * 215. Kth Largest Element in an Array
 * 
 * Intuition
 * 
 * we will use min heap of size k which will behave as max heap
 * Then we will return the top element
 * 
 * Complexity
 * 
 * Time complexity: O(n*logk)
 * 
 * Space complexity: O(k)
 * 
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int n : nums) {
            minHeap.add(n);
            if (minHeap.size() > k)
                minHeap.poll();
        }

        return minHeap.peek();
    }
}