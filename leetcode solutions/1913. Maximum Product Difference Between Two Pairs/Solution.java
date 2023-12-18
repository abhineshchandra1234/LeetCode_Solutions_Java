/**
 * 1913. Maximum Product Difference Between Two Pairs
 * 
 * Intuition
 * 
 * we need to maximize product difference for this we need to find diff between
 * max and min product pair
 * max and min product pair will consist of 2 max & 2 min nos respectively.
 * 2 max can be found out by comparing no with first max and updating first max
 * and second max, then comparing with second max and updating second max
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
    public int maxProductDifference(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int no : nums) {
            // Update max values
            if (no > max1) {
                max2 = max1;
                max1 = no;
            } else if (no > max2)
                max2 = no;

            // Update min values
            if (no < min1) {
                min2 = min1;
                min1 = no;
            } else if (no < min2)
                min2 = no;
        }

        return (max1 * max2) - (min1 * min2);
    }
}
