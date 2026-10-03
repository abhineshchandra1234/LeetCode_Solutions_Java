# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we will first traverse from left to right
- we will count open and close brackets
- then if both the count are equal, we will add their sum to res
- if close count is more than open, that is invalid, we cannot get any open bracket for it later
- we will reset open and close count
- then we will traverse from right to left
- each steps will be same
- if open is greater than close, that is invalid, we cannot get any close bracket for it later
- Finally return result

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity: `O(n)`
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: `O(1)`
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();

        int open = 0, close = 0, res = 0;

        //left to right
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(')
                open++;
            else
                close++;

            if (open == close)
                res = Math.max(res, open + close);
            else if (close > open) {
                open = 0;
                close = 0;
            }
        }

        //right
        open = 0;
        close = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '(')
                open++;
            else
                close++;

            if (open == close)
                res = Math.max(res, open + close);
            else if (open > close) {
                open = 0;
                close = 0;
            }
        }

        return res;
    }
}
```