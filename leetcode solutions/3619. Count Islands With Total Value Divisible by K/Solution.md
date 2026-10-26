# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we will traverse grid
- when we encounter a positive cell, we will apply dfs to it
- Inside dfs we will assign sum the curr cell value
- Then we will make the cell as 0, ie visited
- then we will apply dfs in all 4 dirs and add their sums to curr sum
- Finally return sum

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity: `O(m*n)`
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: `O(1)`
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
class Solution {
    int m, n;
    int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int countIslands(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    long sum = dfs(i, j, grid);
                    if (sum % k == 0)
                        count++;
                }
            }
        }

        return count;
    }

    private long dfs(int i, int j, int[][] grid) {
        long sum = grid[i][j];
        grid[i][j] = 0;

        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];

            if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] > 0)
                sum += dfs(r, c, grid);
        }
        return sum;
    }
}
```