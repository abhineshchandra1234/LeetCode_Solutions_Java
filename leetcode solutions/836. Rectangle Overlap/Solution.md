# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- if either of the rectangles is line, then according to question they cannot have intersecting areas
- if both rectangles are left, bottom, right and up with respect to each others, they cannot have intersecting areas
- So we will check these two conditions, if any of the condition is true, we return false

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
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // either rectangle is line
        if (rec1[0] == rec1[2] || rec1[1] == rec1[3]
                || rec2[0] == rec2[2] || rec2[1] == rec2[3]) {
            return false;
        }

        return !(rec1[2] <= rec2[0] || // left
                rec1[3] <= rec2[1] || // bottom
                rec1[0] >= rec2[2] || //right
                rec1[1] >= rec2[3]); // top
    }
}
```