# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we will calculate the open brackets
- when we encounter the close bracket, if there is any open bracket close it
- otherwise increase bracket needed count
- At last return open bracket count plus needed bracket count

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

    public int minAddToMakeValid(String s) {

        int openBracket = 0;
        int neededBracket = 0;

        for (char c : s.toCharArray()) {

            if (c == '(')
                openBracket++;
            else {
                if (openBracket > 0)
                    openBracket--;
                else
                    neededBracket++;
            }
        }

        return neededBracket + openBracket;
    }
}
```