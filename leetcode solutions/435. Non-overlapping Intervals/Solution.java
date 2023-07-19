/**
 * 435. Non-overlapping Intervals
 * 
 * Intuition
 * 
 * credits d562
 * First we will sort the intervals based on the start time
 * then we will traverse interval and check if there is an overlap
 * if there is an overlap, discard the event with larger end time and increase
 * the count
 * If the question has asked to remove max overlapping intervals, discard the
 * event with smaller end time.
 * If there is no overlap, consider the curr end time.
 * 
 * Complexity
 * 
 * Time complexity: O(nlogn), sorting
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int prevEnd = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (prevEnd > intervals[i][0]) {
                count++;
                prevEnd = Math.min(intervals[i][1], prevEnd);
            } else {
                prevEnd = intervals[i][1];
            }
        }
        return count;
    }
}