/**
 * 2373. Largest Local Values in a Matrix
 * 
 * Intuition
 * 
 * we can solve this problem using simulation
 * we need to find max of every 3*3 grid cell
 * For every cell we need to traverse 9 cells in its grid so total traversal is
 * 9 *(n-2)*(n-2)
 * For every cell position we will traverse till i+3 row and j+3 col
 * 
 * Approach
 *
 * 
 * Complexity
 * 
 * Time complexity: O(n^2)
 * 
 * Space complexity: O(1)
 * 
 */

 //Pseudo code
for(int i=0; i<n-3; i++) {
    for(int j=0; j<n-3; j++) {
        int k = i +3;
        int l = j+3;
        int g = i;
        int h = j;
        int max = Integer.MAX_VALUE;
        for(int g=i; g<k; g++) {
          for(int h=j; h<k; h++) {
              max = Math.max(max, grid[g][h]);
          }
        }
        res.add(max);
    }
  }


// Actual Code
 class Solution {
    public int[][] largestLocal(int[][] grid) {

        int n = grid.length;
        int[][] res = new int[n - 2][n - 2];

        for (int i = 0; i < n - 2; i++)
            for (int j = 0; j < n - 2; j++)
                for (int ii = i; ii < i + 3; ii++)
                    for (int jj = j; jj < j + 3; jj++)
                        res[i][j] = Math.max(res[i][j], grid[ii][jj]);

        return res;
    }
}