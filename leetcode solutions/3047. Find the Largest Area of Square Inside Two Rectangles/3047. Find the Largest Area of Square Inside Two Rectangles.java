// 3047. Find the Largest Area of Square Inside Two Rectangles

/**
 * Intuition
 * we will check all possible pair of rectangle for their intersection
 * width will be difference of top right x and bottom left x coordinates of the
 * intersection
 * topRightX will be min of top right x coordinates of both rectangles
 * bottomLeftX will be max of bottom left x coordinates of both rectangles
 * similarly we will find height of the intersection
 * now for max square in the intersection, we need min of width and height
 * we will compare side with maxSide and update it
 * finally we will return maxSide square
 * you can better understand it by visualisation, by drawing two rectangles in a
 * graph
 * Approach
 * 
 * Complexity
 * Time complexity: O(n^2), we are checking intersection of all possible
 * rectangle pairs
 * Space complexity: O(1)
 */

class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {

        int n = bottomLeft.length;
        int maxSide = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // width
                int topRightX = Math.min(topRight[i][0], topRight[j][0]);
                int bottomLeftX = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int width = topRightX - bottomLeftX;

                // height
                int topRightY = Math.min(topRight[i][1], topRight[j][1]);
                int bottomLeftY = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                int height = topRightY - bottomLeftY;

                int side = Math.min(width, height);
                maxSide = Math.max(maxSide, side);
            }
        }

        return 1L * maxSide * maxSide;
    }
}