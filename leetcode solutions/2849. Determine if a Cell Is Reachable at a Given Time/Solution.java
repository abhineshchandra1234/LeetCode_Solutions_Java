/**
 * 2849. Determine if a Cell Is Reachable at a Given Time
 * 
 * Intuition
 * 
 * credits aryan
 * if both points are same and time is 1. It is impossible to move out and
 * return to same point, as it will require atleast 2 time.
 * so we return false
 * we can move diagonal in square matrix which is equal to Math.min(width,
 * height)
 * Rest distance we need to move straight which will be difference of width &
 * hieght whichever is greater which is equal to Math.abs(width - height)
 * you will notice that Math.min(width, height) + Math.abs(width - height) will
 * be equal to either width or height whichever is greater so we can replace it
 * with Math.max(width,height)
 * Math.max(width,height) is the min time which must be equal to or less than
 * the required time to reach destination
 * Shortest distance will be diagonal. So we cover max diagonal distance to
 * reach at same level then cover rest distance straight.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(1), airthmatic operation
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int width = Math.abs(sx - fx);
        int height = Math.abs(sy - fy);
        if (width == 0 && height == 0 && t == 1)
            return false;
        return t >= Math.min(width, height) + Math.abs(width - height);
    }
}