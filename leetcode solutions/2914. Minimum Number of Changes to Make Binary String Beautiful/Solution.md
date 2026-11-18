# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we will divide the string into pairs of 2
- and check if any changes are required in the pair
- we will take sum of changes and return it

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity: `O(n)`
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: `O(1)`
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```cpp []
class Solution {

public:
    int minChanges(string s) {

        int changes = 0;

        for (int i = 0; i < s.length(); i += 2)
            if (s[i] != s[i + 1])
                changes++;

        return changes;
    }
};
```
```java []
class Solution {
    public int minChanges(String s) {
        int changes = 0;

        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != s.charAt(i + 1))
                changes++;
        }

        return changes;
    }
}
```