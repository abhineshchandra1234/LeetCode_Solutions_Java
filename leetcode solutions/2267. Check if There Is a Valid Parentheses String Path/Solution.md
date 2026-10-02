# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we will solve this problem using recursion
- its base cond are
- if curr box has open bracket we will add 1 to the open count else -1 is added
- if curr box has some value we will return true if it is one otherwise false
- if curr box is the last and open count is 0, means we have one valid path return true
- we will call recursion on below and right box
- Finally we will return false if above all conditions fails

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity: `O(n^2)`
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: `O(n^2)`
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
class Solution {
    int m, n;
    int[][][] t;

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        if ((m + n - 1) % 2 == 1)
            return false;

        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(')
            return false;

        t = new int[m][n][201];
        for (int[][] row : t) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }

        return solve(0, 0, 0, grid);
    }

    public boolean solve(int i, int j, int openC, char[][] grid) {
        openC += (grid[i][j] == '(') ? 1 : -1;

        if (openC < 0)
            return false;

        if (t[i][j][openC] != -1)
            return t[i][j][openC] == 1;

        if (i == m - 1 && j == n - 1) {
            t[i][j][openC] = (openC == 0) ? 1 : 0;
            return openC == 0;
        }

        if (i + 1 < m) {
            if (solve(i + 1, j, openC, grid)) {
                t[i][j][openC] = 1;
                return true;
            }
        }

        if (j + 1 < n) {
            if (solve(i, j + 1, openC, grid)) {
                t[i][j][openC] = 1;
                return true;
            }
        }

        t[i][j][openC] = 0;
        return false;
    }
}
```