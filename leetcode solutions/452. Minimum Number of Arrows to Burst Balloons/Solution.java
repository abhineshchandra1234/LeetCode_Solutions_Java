/**
 * 452. Minimum Number of Arrows to Burst Balloons
 * 
 * Intuition
 * 
 * Joshua924
 * we will place arrow at right most position to increase chance of overlapping
 * with other ballons and shoot as many ballons as possible
 * So we will sort points based on end position
 * 
 * Approach
 * 
 * if the arrow pos is greater than next start position, it comes in the range
 * as its end point will be equal to or greater than arrow pos as points is
 * sorted.
 * 
 * Complexity
 * 
 * Time complexity: O(nlogn), sorting
 * 
 * Space complexity: O(logn), sorting
 * 
 */
class Solution {
    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, (a, b) -> {
            if (a[1] < b[1])
                return -1;
            if (a[1] > b[1])
                return 1;
            return 0;
        });
        int arrPos = points[0][1];
        int arrCnt = 1;
        for (int i = 1; i < points.length; i++) {
            // in range
            if (arrPos >= points[i][0])
                continue;
            // out of range
            arrCnt++;
            arrPos = points[i][1];
        }
        return arrCnt;
    }
}