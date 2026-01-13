// 3453. Separate Squares I

/***
 * Intuition
 * we need to shift midY manually between low and high range and see if bottom
 * and above area are equal, so we apply binary search on midY
 * For each midY we will calculate bottom area for all squares, if it is greater
 * than total, we need to move midY down otherwise move midY above
 * we need not calculate above area as we are using total
 * the moment high and low comes within the range of 1e-5, return the answer
 * Approach
 * 
 * Complexity
 * Time complexity: O(n*logn), doing binary search on midY, and calculating
 * bottom area for all squares each time
 * Space complexity: O(1)
 */

class Solution {
    public double separateSquares(int[][] squares) {

        double low = Double.MAX_VALUE;
        double high = -Double.MAX_VALUE;
        double total = 0.0;

        // calculate total & low & high margins
        for (int[] square : squares) {
            double y = square[1];
            double l = square[2];

            total += l * l;
            low = Math.min(low, y);
            high = Math.max(high, y + l);
        }

        double resY = 0.0;

        // apply binary search for midY
        while (high - low > 1e-5) {
            double midY = low + (high - low) / 2.0;
            resY = midY;
            if (check(squares, midY, total)) {
                // bottom area is more than half, shift down
                high = midY;
            } else {
                low = midY;
            }
        }

        return resY;
    }

    private boolean check(int[][] squares, double midY, double total) {
        double bottomArea = 0.0;

        // calculate bottom area for all squares for curr midY
        for (int[] square : squares) {
            double y = square[1];
            double l = square[2];

            double bottomY = y;
            double topY = y + l;

            if (midY >= topY) {
                // full square below
                bottomArea += l * l;
            } else if (midY > bottomY) {
                // partial square below
                bottomArea += (midY - bottomY) * l;
            }
        }

        // is bottom area more than above
        return bottomArea >= total / 2.0;
    }
}