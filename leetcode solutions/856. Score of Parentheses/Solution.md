# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- if the curr char is open bracket, we will increase depth
- if the curr char is close bracket, we will decrease depth
- then if the prev char is open bracket, we will add `2^depth` to res
- Finally we will return the res

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
    public int scoreOfParentheses(String s) {
        int res = 0;
        int d = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                d++;
            else {
                d--;
                if (s.charAt(i - 1) == '(')
                    res += (1 << d);
            }
        }
        return res;
    }
}
```