/**
 * 1942. The Number of the Smallest Unoccupied Chair
 * 
 * Intuition
 * we will first sort friends based on their arrival time
 * we will have two priorityqueue empty and taken
 * empty will contain chair index that is free
 * taken will contain departure time and chair index
 * we will again traverse friends
 * we will first check which chairs got free, by popping them from taken and
 * adding them to empty
 * we will get the min seat no from empty
 * if the current friend is target, we will return the seat no else will add the
 * chair in taken
 * Approach
 * 
 * Complexity
 * Time complexity: O(nlogn)
 * Space complexity: O(n)
 */
class Solution {
    public int smallestChair(int[][] times, int targetFriend) {

        int n = times.length;
        Integer[] order = new Integer[n];

        for (int i = 0; i < n; i++)
            order[i] = i;

        Arrays.sort(order, (a, b) -> (times[a][0] - times[b][0]));

        PriorityQueue<Integer> emptySeats = new PriorityQueue();
        PriorityQueue<int[]> takenSeats = new PriorityQueue<>((a, b) -> (a[0] - b[0]));

        for (int i = 0; i < n; i++)
            emptySeats.add(i);

        for (int i : order) {
            int arrival = times[i][0], leave = times[i][1];

            while (!takenSeats.isEmpty() && takenSeats.peek()[0] <= arrival)
                emptySeats.add(takenSeats.poll()[1]);

            int seat = emptySeats.poll();

            if (i == targetFriend)
                return seat;

            takenSeats.add(new int[] { leave, seat });
        }

        return -1;
    }
}