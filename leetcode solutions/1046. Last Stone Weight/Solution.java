/**
 * 1046. Last Stone Weight
 * 
 * Intuition
 * We will use maxHeap to solve this
 * Add all elems to heap
 * Pop two elements from heap till size is greater than 1, do operation and push
 * elem back to heap.
 * 
 * Approach
 * At last 0 & 1 will be left on which doing operation will result in 1 in the
 * heap.
 * 
 * Complexity
 * Time complexity: O(nlogn)
 * Space complexity: O(n)
 */
class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i : stones)
            maxHeap.add(i);

        while (maxHeap.size() > 1)
            maxHeap.add(maxHeap.poll() - maxHeap.poll());

        return maxHeap.peek();
    }
}