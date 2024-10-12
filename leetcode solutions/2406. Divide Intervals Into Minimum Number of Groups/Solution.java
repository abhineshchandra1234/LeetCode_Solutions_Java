/**
 * 2406. Divide Intervals Into Minimum Number of Groups
 * 
 * Intuition
 * we will solve this problem by finding max intersections of intervals that
 * will be our no of groups
 * we will separate start and end times, sort it
 * if start time is greater and equal to end time increase the group
 * if end time is greater, one of the intersection ends, decrease the groups
 * Max groups is our ans
 * Approach
 * 
 * Complexity
 * Time complexity: O(nlogn)
 * Space complexity: O(n)
 */
class Solution {
    public int minGroups(int[][] intervals) {

        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int i = 0, j = 0, res = 0;
        while (i < n) {
            if (start[i] <= end[j])
                i++;
            else
                j++;
            res = Math.max(res, i - j);
        }

        return res;
    }
}