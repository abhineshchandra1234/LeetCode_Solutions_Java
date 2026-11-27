# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- copies array will store count of how many other items has a size divisible by its size
- we will find the min price to initialize the dp base case
- `t[0][b] = b / minPrice`, with 0 items considered, the budget can buy as many copies of cheapest items possible
- take - buy the curr item adding 1 to the count, and use the remaining budget for previous items
- skip - Ignore the curr item and keep the res from previous row
- t[n][budget], tells the max no of sale items achievable within the budget

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity: `O(n^2)`
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: `O(n)`
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        int[] copies = new int[n];
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, items[i][1]);

            int copy = 0;
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;

                if (items[j][0] % items[i][0] == 0)
                    copy++;
            }
            copies[i] = copy;
        }

        int[][] t = new int[n + 1][budget + 1];

        for (int b = 0; b <= budget; b++) {
            t[0][b] = b / minPrice;
        }

        for (int i = 1; i <= n; i++) {
            for (int b = 0; b <= budget; b++) {
                int price = items[i - 1][1];
                int take = 0;

                if (price <= b)
                    take = 1 + copies[i - 1] + t[i - 1][b - price];

                int skip = t[i - 1][b];
                t[i][b] = Math.max(take, skip);
            }
        }
        return t[n][budget];
    }
}
```