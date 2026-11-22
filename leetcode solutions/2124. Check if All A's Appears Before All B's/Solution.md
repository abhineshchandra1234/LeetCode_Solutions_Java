# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we will just check if string does not contain substring ba bcs b should be after a
- if above condition is true return true 

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
    public boolean checkString(String s) {
        return !s.contains("ba");
    }
}
```