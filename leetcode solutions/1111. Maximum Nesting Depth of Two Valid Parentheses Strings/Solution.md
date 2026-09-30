# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we will divide brackets in two groups
- both groups will have half the brackets
- when we have open bracket increase the depth, if the depth is even we add it to group 0
- when we have close bracket, if the depth is odd add it to group 1 then decrease the depth

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
    public int[] maxDepthAfterSplit(String seq) {

        int[] res = new int[seq.length()];
        int d = 0;

        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                d++;
                res[i] = d % 2 == 0 ? 0 : 1;
            } else {
                res[i] = d % 2 == 0 ? 0 : 1;
                d--;
            }
        }
        return res;
    }
}
```