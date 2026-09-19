# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we need to find distance between nearest point and circle point
- if the distance is less than or equal to radius, return true ie they overlap otherwise they do not overlap
- if the rectangle is right of the circle nearest point will be x1
- if the rectangle is left of the circle nearest point will be x2
- if the rectangle is anywhere else means they overlap and we can take nearest point as circle center itself

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
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {

        int xi, yi;

        //horizontal distance
        if (x1 > xCenter)
            xi = x1;
        else if (x2 < xCenter)
            xi = x2;
        else
            xi = xCenter;

        //vertical distance
        if (y1 > yCenter)
            yi = y1;
        else if (y2 < yCenter)
            yi = y2;
        else
            yi = yCenter;

        //dis btw nearest point and circle center
        long dx = xi - xCenter;
        long dy = yi - yCenter;

        return dx * dx + dy * dy <= (long) radius * radius;
    }
}
```