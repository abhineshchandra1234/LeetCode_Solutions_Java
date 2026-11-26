# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- first 10 stones are picked then 1 less stone is picked from prev in each turn
- so we will calculate total turns
- if the turn is odd, means its bob turn and alice won, as there are no more stones left
- if the turn is even, means its alice turn and bob won

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity: `O(1)`
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: `O(1)`
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
class Solution {
    public boolean canAliceWin(int n) {
        int take = 10;
        int steps = 0;

        while (n >= take) {
            n -= take;
            take--;
            steps++;
        }

        return steps % 2 == 1;
    }
}
```