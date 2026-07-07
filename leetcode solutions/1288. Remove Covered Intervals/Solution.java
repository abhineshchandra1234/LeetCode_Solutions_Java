// 1288. Remove Covered Intervals

/**
 * Intuition
 * we will first sort the array using start time, if start time is equal, we
 * will sort it based on end time
 * Then we will simply check if curr end time is less than or equal to last end
 * time, if it is it means it is covered and we will continue
 * if not update last end time with curr end time and increase the count
 * Finally return the count
 * Approach
 * 
 * Complexity
 * Time complexity: O(nlogn)
 * Space complexity: O(1)
 */

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });

        int lastEnd = intervals[0][1];
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (lastEnd >= intervals[i][1])
                continue;
            lastEnd = intervals[i][1];
            count++;
        }

        return count;
    }
}