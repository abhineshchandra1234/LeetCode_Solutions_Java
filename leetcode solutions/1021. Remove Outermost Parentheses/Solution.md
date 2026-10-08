# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we will use count variable to keep track of parentheses pairs
- if count is not equal to zero for open parentheses means it is a inner bracket we can add it to res
- similarly if count is not equal to zero for close parentheses, means it is a inner bracket we can add it to res
- Finally return res as an string

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
    public String removeOuterParentheses(String s) {
        int count = 0;

        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (count != 0)
                    sb.append(ch);
                count++;
            } else {
                count--;
                if (count != 0)
                    sb.append(ch);
            }
        }

        return sb.toString();
    }
}
```