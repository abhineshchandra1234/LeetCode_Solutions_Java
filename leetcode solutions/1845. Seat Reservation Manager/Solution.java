/**
 * 1845. Seat Reservation Manager
 * 
 * Intuition
 * 
 * credits suraj008
 * It is evident we can solve this using min heap
 * we can optimize it further by introducing count variable
 * In the initial state all seats are available we can simply increase the count
 * by 1, and return it
 * the above operation will be valid if no unreserve has taken place or all
 * seats are in intial state
 * this way we do not need to add all seats to min heap at start
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(nlogn)
 * 
 * Space complexity: O(n)
 * 
 */
class SeatManager {

    PriorityQueue<Integer> pq;
    int count;

    public SeatManager(int n) {
        count = 0;
        pq = new PriorityQueue();
    }

    public int reserve() {
        if (pq.size() == 0)
            return ++count;
        return pq.poll();
    }

    public void unreserve(int seatNumber) {
        pq.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */