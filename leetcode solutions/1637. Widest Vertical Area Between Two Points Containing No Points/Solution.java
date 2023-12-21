/**
 * 1637. Widest Vertical Area Between Two Points Containing No Points
 * 
 * Intuition
 * 
 * As evident in the question we can solve it by simply sorting x-coordinate
 * Then updating max width value with distance between two x-coordinates
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(nlogn), sorting
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {

        Arrays.sort(points, ((a, b) -> a[0] - b[0]));
        int max = 0;
        for (int i = 1; i < points.length; i++)
            max = Math.max(max, points[i][0] - points[i - 1][0]);
        return max;
    }
}