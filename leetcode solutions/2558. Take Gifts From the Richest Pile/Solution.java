/**
 * 2558. Take Gifts From the Richest Pile
 * 
 * Intuition
 * we can solve this problem through max heap
 * first add all nos to heap
 * then pop the max no, and leave behind the sqrt of the no
 * we need to do this k times and only if no is greater or equal to 1
 * Approach
 * 
 * Complexity
 * Time complexity: O(nlogn)
 * Space complexity: O(n)
 */
class Solution {

    public long pickGifts(int[] gifts, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int gift : gifts)
            maxHeap.add(gift);

        for (int i = 0; i < k && maxHeap.peek() >= 1; i++) {
            int x = maxHeap.poll();
            maxHeap.add((int) Math.sqrt(x));
        }

        long sum = 0;
        for (int val : maxHeap)
            sum += val;

        return sum;
    }
}