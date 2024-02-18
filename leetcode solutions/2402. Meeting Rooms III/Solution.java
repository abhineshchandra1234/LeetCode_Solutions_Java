/**
 * 2402. Meeting Rooms III
 * 
 * Intuition
 * 
 * we will solve this problem using priorityqueue
 * We will sort the meetings according to start time so that meetings which
 * comes first gets room first
 * we will maintain an engaged min priorityqueue which will contain room and end
 * time of assigned meeting
 * engaged will store rooms with least end time, if end time is same then with
 * least room
 * we will maintain an unused min priorityqueue which will store rooms
 * we will first add all rooms to unused intially.
 * Then we will traverse meetings
 * First we will check if any engaged rooms has its meeting ending before curr
 * meeting then we will release all those rooms from engaged
 * Then we will assign new meeting to least unused room as problem demands, and
 * add that room to engaged, we will also increase count of the room
 * If no room is available, then we will remove room with least time from
 * engaged, extend its end time with curr end time and add it to engaged
 * Increase the room count
 * This means we are starting curr meeting after least meeting ends
 * Finally traverse count and find the room with max count or meetings
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(nlogn), sorting meetings according to start time, adding
 * rooms to priorityqueue
 * 
 * Space complexity: O(n), storing max meetings for each room, storing rooms
 * into priorityqueue
 * 
 */
class Solution {
    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int[] count = new int[n];
        PriorityQueue<int[]> engaged = new PriorityQueue<>(
                (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        PriorityQueue<Integer> unused = new PriorityQueue<>();

        for (int i = 0; i < n; i++)
            unused.add(i);

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            // cond 3, when curr meeting ends release the room
            while (!engaged.isEmpty() && engaged.peek()[1] <= start) {
                int room = engaged.poll()[0];
                unused.add(room);
            }
            // cond 1, assign meeting to lowest unused room
            // add room to engaged
            if (unused.size() > 0) {
                int room = unused.poll();
                count[room]++;
                engaged.add(new int[] { room, end });
            }
            // cond 2, no available rooms,
            // schedule new meeting after least one
            // update end time of least one to accomodate new meeting
            else {
                int[] curr = engaged.poll();
                int room = curr[0], currEnd = curr[1];
                count[room]++;
                int newEnd = currEnd + end - start;
                engaged.add(new int[] { room, newEnd });
            }
        }

        int maxRoomId = 0;
        for (int i = 1; i < n; i++)
            if (count[i] > count[maxRoomId])
                maxRoomId = i;

        return maxRoomId;
    }
}