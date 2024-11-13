/**
 * 539. Minimum Time Difference
 * 
 * Intuition
 * Given
 * timePoints string array which contains time points in "HH:MM" format
 * Return
 * minimum minutes difference between any two time points
 * 
 * 
 * Approach
 * we can solve this problem through sorting
 * convert every time point to its minute equivalent
 * then sort this minute equivalents
 * then traverse through minute equivalents and update the res for adjacent time
 * points
 * At last update res with first and last time points, and return the res
 * first can be 00:00 and last can be 23:59, res will be update with (total time
 * - last) + first.
 * ie their distance from initial or total time
 * 
 * 
 * Complexity
 * Time complexity: O(nlogn), sorting
 * Space complexity: O(n), storing minutes equivalent
 */
class Solution {

    public int findMinDifference(List<String> timePoints) {

        int n = timePoints.size();
        int[] mins = new int[n];

        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(timePoints.get(i).substring(0, 2));
            int m = Integer.parseInt(timePoints.get(i).substring(3));

            mins[i] = h * 60 + m;
        }

        Arrays.sort(mins);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {

            res = Math.min(res, mins[i + 1] - mins[i]);
        }

        res = Math.min(res, (24 * 60) - mins[n - 1] + mins[0]);

        return res;
    }
}