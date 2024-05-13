/**
 * 861. Score After Flipping Matrix
 * 
 * Intuition
 * 
 * There are two approaches to solve this problem, first is by modifying the
 * grid, second is by simulating grid modification, we are solving using second
 * approach
 * To maximize the sum, there are two steps
 * If the first bit of the row is 0 we need to flip it to maximize the no
 * If the no of 1's in any column is less than 0's, we need to flip it to
 * maximize the no
 * 
 * Approach
 * 
 * to find value at any place we mutiply 1 with 2^m-1 or 1 left shift m-1
 * Since first bit of every row will be 1, we will find its total value and add
 * in res, this also completes our first step
 * res += (1 << (m - 1)) * n;
 * For second step we are visiting each column and finding total nos of 1
 * To find total ones, we are comparing curr no with MSB of that row, if they
 * are same, we need to increase 1's count. If they are different 1's count will
 * remain unchanged
 * Finally we will add max of 1's or 0's in res, as 1's will be filpped if it is
 * less
 * res += Math.max(curr, n - curr) * (1 << (m - 1 - j));
 * Now we have sum of first bit from first step and sum of rest of the bits from
 * second step, we would return the res
 * 
 * Complexity
 * 
 * Time complexity: O(m∗n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int matrixScore(int[][] grid) {

        int n = grid.length, m = grid[0].length;

        int res = 0;

        res += (1 << (m - 1)) * n;

        for (int j = 1; j < m; j++) {
            int curr = 0;
            for (int i = 0; i < n; i++) {
                if (grid[i][j] == grid[i][0])
                    curr++;
            }
            res += Math.max(curr, n - curr) * (1 << (m - 1 - j));
        }

        return res;
    }
}