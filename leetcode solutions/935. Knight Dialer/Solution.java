/**
 * 935. Knight Dialer
 * 
 * Intuition
 * Approach 1 (Top-down approach)
 * 
 * credits sriramgopal03
 * a knight may move two squares vertically and one square horizontally, or two
 * squares horizontally and one square vertically (with both forming the shape
 * of an L).
 * a knight can move in 4 directions up, bottom, left, right and thier 2 sides
 * so total valid paths are 4*2= 8, it can reach 8 diff places using just 1
 * jump.
 * our res will be the sum of all these paths
 * we will solve this using recursion and memoization by traversing pad
 * 
 * Approach
 * Complexity
 * 
 * Time complexity:
 * 
 * O(n), dp states will n(states)*k(pad size), since pad size is fixed
 * 
 * Space complexity:
 * 
 * O(n), dp space
 * 
 */
class Solution {

    int max = (int) 1e9 + 7;

    public int knightDialer(int n) {
        Long M[][][] = new Long[n + 1][4][3];
        long s = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                s = (s + paths(M, i, j, n)) % max;
            }
        }
        return (int) s;
    }

    private long paths(Long[][][] M, int i, int j, int n) {
        if (i < 0 || j < 0 || i >= 4 || j >= 3 || (i == 3 && j != 1))
            return 0;
        if (n == 1)
            return 1;
        if (M[n][i][j] != null)
            return M[n][i][j];
        M[n][i][j] = paths(M, i + 2, j + 1, n - 1) % max + // down-right
                paths(M, i + 2, j - 1, n - 1) % max + // down-left
                paths(M, i - 2, j + 1, n - 1) % max + // up-right
                paths(M, i - 2, j - 1, n - 1) % max + // up-left
                paths(M, i - 1, j + 2, n - 1) % max + // right-top
                paths(M, i + 1, j + 2, n - 1) % max + // right-down
                paths(M, i - 1, j - 2, n - 1) % max + // left-up
                paths(M, i + 1, j - 2, n - 1) % max; // left+down
        return M[n][i][j];
    }
}