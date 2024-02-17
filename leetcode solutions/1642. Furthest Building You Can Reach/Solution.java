/**
 * 1642. Furthest Building You Can Reach
 * 
 * Intuition
 * 
 * credits lee215
 * we will solve this problem through greedy approach
 * we will traverse buildings and store highest differences of size k and sum of
 * rest of the differences, if that difference exceeds bricks return curr index
 * If we have traversed all buildings, then we have reached the farthest
 * building, return buildings-1.
 * 
 * Approach
 * 
 * min heap with constraint behaves as max heap
 * we will store highest differences in min heap of size k
 * Once the heap size exceeds we will pop the least difference and subtract from
 * bricks
 * If the bricks count is less than 0, means we do not have more bricks or
 * ladders to move to next building return curr idx.
 * if we have traversed all buildings means we have reached farthest building
 * return buildings-1
 * 
 * Complexity
 * 
 * Time complexity: O(nlogk), for every difference added we are rearranging k
 * elements, k is no of ladders
 * 
 * Space complexity: O(k), storing k differences
 * 
 */
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int i = 0; i < n - 1; i++) {
            int d = heights[i + 1] - heights[i];
            if (d > 0)
                pq.add(d);
            if (pq.size() > ladders)
                bricks -= pq.poll();
            if (bricks < 0)
                return i;
        }
        return n - 1;
    }
}