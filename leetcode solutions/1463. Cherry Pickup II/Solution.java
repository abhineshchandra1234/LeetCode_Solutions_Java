/**
 * 1463. Cherry Pickup II
 * 
 * Intuition
 * 
 * we will solve this problem using bottom-up approach
 * we will build our solution from last to first row
 * both robots can reach the last row at any position from 0 to m
 * front[m][m], will represent cherry count for path from next row to last,
 * curr[m][m], represent cherry count for curr row to last for different
 * positions of robot
 * so we will initialize front[m][m], with the last row of grid
 * If thier position are same then curr grid cell will be added once
 * If their position are different both thier positions of grid will be added.
 * we will run a loop from n-2 to 0 to update curr[m][m]
 * we will update ans, with one of 9 positions of robot of grid and front
 * Then we will update maxi with max of ans
 * Then we will assign maxi to curr[m][m], which represents max among 9
 * positions for m,m positions of robots.
 * Then we will assign curr to front
 * At last return front res for 0,m-1, which is the initial position of robot.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n∗m∗m), O(n*m*m*9),
 * outer loop run for n∗m∗m, inner loop run for 9 times
 * 
 * Space complexity: O(m∗m), we are using dp array to store maximum
 * cherry for different position of robots
 * 
 */
class Solution {
    public int cherryPickup(int[][] grid) {

        int n = grid.length, m = grid[0].length;

        // store res front, curr rows
        int[][] front = new int[m][m];
        int[][] curr = new int[m][m];

        // initialize front row with last row of grid
        for (int j1 = 0; j1 < m; j1++)
            for (int j2 = 0; j2 < m; j2++)
                if (j1 == j2)
                    front[j1][j2] = grid[n - 1][j1];
                else
                    front[j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];

        // outer nested loops to traverse grid array and update dp arrays with it
        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {

                    int maxi = Integer.MIN_VALUE;

                    // inner nested loops to try out 9 options
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int ans;

                            if (j1 == j2)
                                ans = grid[i][j1];
                            else
                                ans = grid[i][j1] + grid[i][j2];

                            if ((j1 + di < 0 || j1 + di >= m) || (j2 + dj < 0 || j2 + dj >= m))
                                ans += (int) Math.pow(-10, 9);
                            else
                                ans += front[j1 + di][j2 + dj];

                            // update maxi with maximum result
                            maxi = Math.max(maxi, ans);
                        }
                    }
                    // store result in curr array
                    curr[j1][j2] = maxi;
                }
            }
            // update front with curr for next row
            for (int a = 0; a < m; a++) {
                front[a] = curr[a].clone();
            }
        }
        return front[0][m - 1];
    }
}