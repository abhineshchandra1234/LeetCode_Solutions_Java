/**
 * 2462. Total Cost to Hire K Workers
 * 
 * Intuition
 * 
 * we will use two min heaps to solve this
 * first min heap will store candidates from the left and second min heap will
 * store candidates from right.
 * At each k iterations we will add candidates to heaps till they do not
 * collide.
 * We will use two ptrs to add elements to heaps.
 * One ptr will point to start and other ptr will point to end initially.
 * We will compare top elements of both heaps, pop the least one and add it to
 * the result.
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(nlogn), n is time to push candidates to heap and logn is the time to
 * arrange them inside the heap.
 * 
 * Space complexity:
 * 
 * O(n)
 * 
 */
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {

        PriorityQueue<Integer> pq1 = new PriorityQueue();
        PriorityQueue<Integer> pq2 = new PriorityQueue();
        long ans = 0;
        int cnt = 0, i = 0, j = costs.length - 1;

        while (cnt++ < k) {
            while (pq1.size() < candidates && i <= j)
                pq1.add(costs[i++]);
            while (pq2.size() < candidates && j >= i)
                pq2.add(costs[j--]);

            int a = (pq1.size() > 0) ? pq1.peek() : Integer.MAX_VALUE;
            int b = (pq2.size() > 0) ? pq2.peek() : Integer.MAX_VALUE;

            if (a <= b) {
                ans += a;
                pq1.poll();
            } else {
                ans += b;
                pq2.poll();
            }
        }
        return ans;
    }
}