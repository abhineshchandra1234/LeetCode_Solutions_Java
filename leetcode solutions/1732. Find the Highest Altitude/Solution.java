/**
 * 1732. Find the Highest Altitude
 * 
 * Intuition
 * 
 * We will use prefix_sum to calculate curr_alt, and using curr_alt we will
 * update max_alt.
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int largestAltitude(int[] gain) {

        int max_alt = 0, curr_alt = 0;
        for (int i : gain) {
            curr_alt += i;
            max_alt = Math.max(max_alt, curr_alt);
        }
        return max_alt;
    }
}