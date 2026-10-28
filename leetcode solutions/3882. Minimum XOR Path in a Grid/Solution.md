# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we will create a 2d grid of bitset
- if it is top row or first col we will continue
- bitset size is 1024, which will contain all possible nos till 1024
- there can be multiple path each with its own xor value
- xor value with curr and min or max xor value can be diffrent
- so we will take xor of curr with all the xor values
- we will have a bitset combined having up and left bitset values
- we will create res bitset by combining curr and combined bitset
- then we will traverse bitset of last cell, whichever min xor value present will be our answer

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
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        BitSet[][] dp = new BitSet[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new BitSet(1024);
            }
        }

        dp[0][0].set(grid[0][0]);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;

                BitSet up = new BitSet(1024);
                BitSet left = new BitSet(1024);

                if (i > 0) {
                    up = (BitSet) dp[i - 1][j].clone();
                }
                if (j > 0)
                    left = (BitSet) dp[i][j - 1].clone();

                BitSet combined = (BitSet) up.clone();
                combined.or(left);

                for (int xorVal = 0; xorVal < 1024; xorVal++) {
                    if (combined.get(xorVal)) {
                        int resXorVal = xorVal ^ grid[i][j];
                        dp[i][j].set(resXorVal);
                    }
                }
            }
        }

        for (int xorVal = 0; xorVal < 1024; xorVal++) {
            if (dp[m - 1][n - 1].get(xorVal)) {
                return xorVal;
            }
        }

        return -1;
    }
}
```