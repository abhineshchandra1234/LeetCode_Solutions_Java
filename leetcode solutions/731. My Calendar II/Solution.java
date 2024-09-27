/**
 * 731. My Calendar II
 * 
 * Intuition
 * we need to implement MyCalendarTwo calendar object
 * if the event can be added using method book without causing triple booking
 * return true else false
 * triple booking means three events have some common intersection
 * our goal is to prevent triple bookings, double bookings are allowed
 * as soon as triple booking occurs we need to return false
 * condition for two overlapping bookings max(s1, s2) < min (e1, e2)
 * condition for overlapped part [max(s1, s2), min(e1, e2)]
 * we will maintain two lists, one for bookings and another for overlapped part
 * of double bookings
 * overlapped part will be common in all 3 events
 * we will run a loop to check each event with already existing bookings, for
 * overlap or double booking and update overlapped list
 * we will run another loop to check each event with already existing double or
 * overlapped bookings, for triple bookings or another overlap
 * if there is another overlap return false or return true at the end
 * This problem is very similar to My Calendar I
 * 
 * Approach
 * 
 * Complexity
 * Time complexity: O(n), in book function we are checking double and triple
 * overlapping
 * Space complexity: O(n), we are maintaining booking and double booking list
 */

class MyCalendarTwo {

    List<int[]> bookings;
    List<int[]> overlappedBookings;

    public MyCalendarTwo() {
        bookings = new ArrayList();
        overlappedBookings = new ArrayList();
    }

    private boolean doubleBooking(int s1, int e1, int s2, int e2) {
        return Math.max(s1, s2) < Math.min(e1, e2);
    }

    private int[] overlapped(int s1, int e1, int s2, int e2) {
        return new int[] { Math.max(s1, s2), Math.min(e1, e2) };
    }

    boolean book(int start, int end) {

        // triple booking
        for (int[] booking : overlappedBookings) {
            if (doubleBooking(booking[0], booking[1], start, end))
                return false;
        }

        // double booking
        for (int[] booking : bookings) {
            if (doubleBooking(booking[0], booking[1], start, end)) {
                overlappedBookings.add(overlapped(booking[0], booking[1], start, end));
            }
        }

        bookings.add(new int[] { start, end });

        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */