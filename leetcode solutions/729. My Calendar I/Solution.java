/**
 * 729. My Calendar I
 * 
 * Intuition
 * we need to initialize MyCalender object
 * we need to return true, if event can be added to calendar else false.
 * through brute force for each event we can check conflict with all other
 * existing events
 * if there a conflict will return false, else will add it and return true
 * It will take O(n^2) time
 * we can optimize it, by sorting the start times of all events
 * using treemap we can get prev key or event by using floor key function
 * against start
 * we can also get next key or event by using ceiling key function against start
 * so for curr start and end, if prev key endtime is less than or equal to start
 * or null and next start_time is greater than or equal to end or null
 * means there is no conflict, add event to calender ie treemap and return true,
 * else return false at end
 * 
 * 
 * Approach
 * 
 * 
 * Complexity
 * Time complexity: O(nlogn), searching floor and ceiling value for each event
 * start time
 * Space complexity: O(n), storing each event
 */

class MyCalendar {

    TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap();
    }

    public boolean book(int start, int end) {

        Integer prev = map.floorKey(start), next = map.ceilingKey(start);

        if ((prev == null || map.get(prev) <= start) && (next == null || next >= end)) {
            map.put(start, end);
            return true;
        }

        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */