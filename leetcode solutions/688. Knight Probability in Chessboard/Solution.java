/**
 * 688. Knight Probability in Chessboard
 * 
 * Intuition
 * 
 * credits kevincongcc
 * we will use dp to solve this problem. It will be a bottom up approach.
 * if we add 1 or 2 to x or y coordinates we will get all the positions of the
 * knight.
 * for first level position probability is 1/8, second level 1/64, third level
 * 1/64*8.
 * knight will repeat a lot of coordinates (x,y)
 * so dp will have three states x,y and moves.
 * It will recursively move to the last level and finally return the result to
 * dp[0][0][k]
 * we have done memoization at each step
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(n*n*k*8), n*n*k for dp,*8 for 8 dirs
 * 
 * Space complexity:
 * 
 * O(n*n*k), dp size
 * 
 */
class Solution {

    private int[][] dirs = new int[][] { { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 }, { 2, 1 }, { 1, 2 }, { -1, 2 },
            { -2, 1 } };
    private Double[][][] dp;

    public double knightProbability(int n, int k, int row, int column) {
        dp = new Double[n][n][k + 1];
        return find(n, k, row, column);
    }

    public double find(int n, int k, int r, int c) {
        if (r < 0 || r >= n || c < 0 || c >= n)
            return 0;
        if (k == 0)
            return 1;
        if (dp[r][c][k] != null)
            return dp[r][c][k];
        double rate = 0;
        for (int[] dir : dirs)
            rate += find(n, k - 1, r + dir[0], c + dir[1]) / 8.0;
        dp[r][c][k] = rate;
        return rate;
    }
}