/**
 * 1232. Check If It Is a Straight Line
 * 
 * Intuition
 * credits logan138
 * If we have three points p1, p2 & p3.
 * if slope of (p1 & p2 == p2 & p3), then they are in straight line.
 * two points will always will be in straight line.
 * slope definition
 * we will find slope of each point with common points p1, p2. To make sure
 * every point is in straight line.
 * slope cond (y-y1) * (x2-x1) == (x-x1) * (y2-y1)
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {

        for (int i = 2; i < coordinates.length; i++) {
            if (!onLine(coordinates[i], coordinates[0], coordinates[1]))
                return false;
        }
        return true;
    }

    private boolean onLine(int[] p1, int[] p2, int[] p3) {
        int x = p1[0], y = p1[1], x1 = p2[0], y1 = p2[1], x2 = p3[0], y2 = p3[1];
        return (y - y1) * (x2 - x1) == (x - x1) * (y2 - y1);
    }
}