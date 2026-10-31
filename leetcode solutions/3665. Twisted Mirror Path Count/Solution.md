# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we are solving this problem through recursion
- if we are moving out of bounds, that will be invalid path so 0 will be returned as the path count
- if we have reached bottom right cell, means it is a valid path return 1 as the path count
- if the curr cell is not empty return the curr cell
- if the curr cell is 1 and we came from left, we will move down
- if the curr cell is 1 and we came from up, we will move right
- if the curr cell is 0, we will move to the right cell and down cell
- we take sum of above and left cell in this type of questions 

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity: `O(m*n)`
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: `O(m*n)`
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
class Solution {
    int left = 0;
    int up = 1;
    int mod = (int) (1e9 + 7);
    int m;
    int n;

    public int uniquePaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int[][][] t = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                t[i][j][0] = -1;
                t[i][j][1] = -1;
            }
        }

        return solve(grid, 0, 0, left, t);
    }

    private int solve(int[][] grid, int i, int j, int cameF, int[][][] t) {
        if (i >= m || j >= n)
            return 0;
        if (i == m - 1 && j == n - 1)
            return 1;
        if (t[i][j][cameF] != -1)
            return t[i][j][cameF];

        if (grid[i][j] == 1) {
            if (cameF == left)
                return t[i][j][cameF] = solve(grid, i + 1, j, up, t);
            else
                return t[i][j][cameF] = solve(grid, i, j + 1, left, t);
        }

        int count = 0;
        count = (count + solve(grid, i, j + 1, left, t)) % mod;
        count = (count + solve(grid, i + 1, j, up, t)) % mod;

        return t[i][j][cameF] = count;
    }
}
```