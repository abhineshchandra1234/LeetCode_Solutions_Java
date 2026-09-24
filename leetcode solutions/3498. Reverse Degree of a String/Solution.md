# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we will find the value of each char by subtracting it from `a`
- then we will find its reverse value by subtracting the value from 26
- then we will multiply this value to curr index and add it to res
- Finally return the res

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
    public int reverseDegree(String s) {
        int res = 0;
        for (int i = 1; i <= s.length(); i++) {
            res += (26 - (s.charAt(i - 1) - 'a')) * i;
        }
        return res;
    }
}
```