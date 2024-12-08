/**
 * 2054. Two Best Non-Overlapping Events
 * 
 * Intuition
 * we can solve this problem through min heap
 * we will first sort the events array based on start time, so that we can
 * compare them easily
 * then we will traverse events
 * for the current event, we will check which all events are valid and give max
 * value
 * min heap will store end time and value for each event
 * events in heap are valid if its end time doesnt collide with curr start time
 * we will find the local max first, then use the overall max to get the res
 * later we will add end time and value of curr event to heap
 * Note - we need to consider single max value too
 * Here - [[1,3,2],[4,5,2],[1,5,5]], [1,5,5] is overlapping with all events,
 * doesnt form any pair
 * if we do not consider single max value, and go for pair, it value of 5 will
 * be ignored
 * Approach
 * 
 * Complexity
 * Time complexity: O(n*logn)
 * Space complexity: O(n)
 */
class Solution {
    public int maxTwoEvents(int[][] events) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int res = 0, temp = 0;
        for (int[] event : events) {
            while (!pq.isEmpty() && pq.peek()[0] < event[0]) {
                temp = Math.max(temp, pq.peek()[1]);
                pq.poll();
            }
            res = Math.max(res, temp + event[2]);
            pq.add(new int[] { event[1], event[2] });
        }

        return res;
    }
}