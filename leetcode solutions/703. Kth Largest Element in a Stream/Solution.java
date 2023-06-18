/**
 * 703. Kth Largest Element in a Stream
 * 
 * Intuition
 * We know min heap behaves like a max heap when there is constraint k.
 * we will use min heap of size k and return top most element which will
 * represent kth largest.
 * 
 * Approach
 * use add method to add elements to heap initially, to keep the size as k.
 * 
 * Complexity
 * Time complexity:
 * KthLargest - O(nlogk)
 * 
 * add - O(logk)
 * 
 * Space complexity: O(k)
 */
class KthLargest {

    private final PriorityQueue<Integer> minHeap;
    private final int k;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;
        for (int i : nums)
            add(i);
    }

    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k)
            minHeap.poll();

        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */