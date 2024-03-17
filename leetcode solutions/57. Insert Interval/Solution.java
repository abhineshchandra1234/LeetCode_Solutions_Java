/**
 * 57. Insert Interval
 * 
 * Intuition
 * 
 * we will solve this problem using linear search
 * given
 * intervals are sorted based on start time
 * expected
 * insert new interval by shifting or overlapping elements while maintaing
 * sorted state
 * non - overlapping conditions
 * curr comes before new interval, ie end time of curr is smaller than start
 * time of new interval
 * simply add curr to res and move to next interval
 * curr comes after new interval, ie start time of curr is greater than end time
 * of new interval
 * add new interval to res, to shift other intervals make curr as new interval
 * and continue the process
 * overlapping condition
 * Above two condtions fails then curr is overlapping with new interval
 * update start time of new interval with min of start time of curr
 * update end time of new interval with max of end time of curr
 * and continue the process
 * 
 * At last add remaining new interval to res and return it.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n), traversing intervals once
 * 
 * Space complexity: O(1), using res as storage
 * 
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> res = new ArrayList();

        for (int[] i : intervals) {
            // curr before newInterval
            if (i[1] < newInterval[0])
                res.add(i);
            // curr after newInterval
            else if (i[0] > newInterval[1]) {
                res.add(newInterval);
                newInterval = i;
            }
            // curr overlapping newInterval
            else {
                newInterval[0] = Math.min(i[0], newInterval[0]);
                newInterval[1] = Math.max(i[1], newInterval[1]);
            }
        }
        res.add(newInterval);
        int[][] ans = new int[res.size()][];
        for (int i = 0; i < ans.length; i++)
            ans[i] = res.get(i);
        return ans;
    }
}