# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- if we have an open bracket we will increase count and move to next index
- if curr char is closing bracket, we will check if we have a open bracket, if it is we will decrease count
- if we do not have opening bracket we need to insert opening bracket, increase res by 1
- if `i+1` is closing bracket, that is a valid scenario increase `i by 2`
- if `i+1` is opening bracket, we need to insert a closing bracket, increase res by 1 and move to next index
- At last return res plus `count *2`, count is no of open brackets left and for each one we need two close bracket

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
    public int minInsertions(String s) {
        int n = s.length();
        int res = 0;
        int count = 0;
        int i = 0;

        while (i < n) {
            if (s.charAt(i) == '(') {
                count++;
                i++;
            } else {
                if (count > 0) {
                    count--;
                }
                //insert '('
                else {
                    res++;
                }
                //found '))'
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    i += 2;
                }
                //insert ')'
                else {
                    res++;
                    i++;
                }
            }
        }

        return res + count * 2;
    }
}
```