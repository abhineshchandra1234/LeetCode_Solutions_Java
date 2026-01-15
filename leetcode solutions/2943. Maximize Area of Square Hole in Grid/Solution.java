// 2943. Maximize Area of Square Hole in Grid
/**
 * Intuition
 * sort the arrays, so that we get consecutive rows and cols to remove to get
 * max area
 * find max consecutive h bars to remove
 * find max consecutive v bars to remove
 * side will be minimum of max consecutive h bars and v bars found above, bcs we
 * want to form square not rectangle
 * return the max area by squaring side
 * Approach
 * 
 * Complexity
 * Time complexity: O(nlogn), sorting
 * Space complexity: O(1)
 */

class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {

        // sort the arrays, so that we get consecutive
        // rows and cols to remove to get max area
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int maxConsHBars = 1;
        int maxConsVBars = 1;

        // find max consecutive h bars to remove
        int currConsHBars = 1;
        for (int i = 1; i < hBars.length; i++) {
            if (hBars[i] - hBars[i - 1] == 1)
                currConsHBars++;
            else
                currConsHBars = 1;

            maxConsHBars = Math.max(maxConsHBars, currConsHBars);
        }

        // find max consecutive v bars to remove
        int currConsVBars = 1;
        for (int i = 1; i < vBars.length; i++) {
            if (vBars[i] - vBars[i - 1] == 1)
                currConsVBars++;
            else
                currConsVBars = 1;

            maxConsVBars = Math.max(maxConsVBars, currConsVBars);
        }

        // side will be minimum of max consecutive h bars and v bars
        // found above, bcs we want to form square not rectangle
        int side = Math.min(maxConsHBars, maxConsVBars) + 1;

        // return the max area
        return side * side;
    }
}