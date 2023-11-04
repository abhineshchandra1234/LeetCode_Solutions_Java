/**
 * 1503. Last Moment Before All Ants Fall Out of a Plank
 * 
 * Intuition
 * 
 * credits lee215
 * When two ants intersect at any positions they take each other position and
 * direction and continue moving.
 * So we can assume they are moving in same dirs without the need to swap.
 * left directed ants will take left[i] time to fall off
 * right directed ants will take n-right[i] time to fall off
 * we need min time at which all ants falls off, it will be max of leftmost and
 * rightmost ant time to fall off.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {

        int res = 0;
        // left
        for (int i : left)
            res = Math.max(res, i);
        // right
        for (int i : right)
            res = Math.max(res, n - i);
        return res;
    }
}