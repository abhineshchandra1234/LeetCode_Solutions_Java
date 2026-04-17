/**
 * 2337. Move Pieces to Obtain a String
 * 
 * Intuition
 * we can solve this problem through two ptrs
 * first ptr will point to start
 * sec ptr will point to target
 * there are many corner cases we need to cover
 * we will skip empty spaces in start and target
 * if one of the ptr is exhausted, we want other ptr to be exhausted too
 * now we will compare chars at both the indices
 * if chars are not equal return false
 * if both ptrs are pointing to L, but start ptr has less value return false, as
 * start ptr cannot move to right
 * if both ptrs are pointing to R, but start ptr has more value return false, as
 * start ptr cannot move to left
 * if above all conditions satisfy, both ptrs are poiting to correct chars, and
 * they can move within bounds
 * move start and end ptr to next
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {

    public boolean canChange(String start, String target) {

        int n = start.length();
        int i = 0, j = 0;

        while (i < n || j < n) {

            // skip spaces
            while (i < n && start.charAt(i) == '_') {
                i++;
            }

            while (j < n && target.charAt(j) == '_') {
                j++;
            }

            // if one of them exhausts, both of them should exhausts
            if (i == n || j == n) {
                return i == n && j == n;
            }

            if ((start.charAt(i) != target.charAt(j)) ||
                    (start.charAt(i) == 'L' && i < j) ||
                    (start.charAt(i) == 'R' && i > j)) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}