/**
 * 1266. Minimum Time Visiting All Points
 * 
 * Intuition
 * 
 * credits rock
 * time to travel between two points is max of abs diff of x and y coordinates
 * of the points
 * You can travel diagonally or horizontally or vertically the distance will be
 * max of abs diff of x and y coordinates
 * 
 * Approach
 * 
 * //diagonal
 * (2,2) -> (3,3)
 * we can reach faster if we travel diagonally
 * max diff is 1, which is equal to the fastest time
 * 
 * //vertically
 * (2,2) -> (2,3)
 * we can reach faster if we travel vertically
 * again max diff is 1 which is equal to the fastest time
 * 
 * //horizontally
 * (1,2) -> (2,2)
 * we can reach faster if we travel horizontally
 * max diff is 1 which is equal to the fastest time
 * 
 * //note
 * //no matter how you travel fastest time will
 * //be max of abs diff of coordinates.
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {

        int ans = 0;
        for (int i = 1; i < points.length; i++) {
            int[] curr = points[i], prev = points[i - 1];
            ans += Math.max(Math.abs(curr[0] - prev[0]), Math.abs(curr[1] - prev[1]));
        }
        return ans;
    }
}

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {

        int ans = 0;

        for (int i = 1; i < points.length; i++) {
            ans += Math.max(
                    Math.abs(points[i][0] - points[i - 1][0]),
                    Math.abs(points[i][1] - points[i - 1][1]));
        }

        return ans;
    }
}