# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we can have a path from top left to bottom right, through first row and last col
- so we will run two loops for rows and cols, if the curr row is 0 or curr col is n-1, we will add dot else #
- Finally we will return the resultant string

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity: `O(m*n)`
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: `O(n)`
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
class Solution {
    public String[] createGrid(int m, int n) {
        String[] grid = new String[m];

        for (int i = 0; i < m; i++) {
            char[] row = new char[n];

            for (int j = 0; j < n; j++) {
                if (i == 0 || j == n - 1)
                    row[j] = '.';
                else
                    row[j] = '#';
            }

            grid[i] = new String(row);
        }

        return grid;
    }
}
```