/**
 * 1464. Maximum Product of Two Elements in an Array
 * 
 * Intuition
 * 
 * As evident in the question, we will find the biggest and second biggest from
 * single traversal of the array
 * We will return its product at the end
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
    public int maxProduct(int[] nums) {

        int mx1 = Integer.MIN_VALUE, mx2 = mx1;
        for (int n : nums) {
            if (n > mx1) {
                mx2 = mx1;
                mx1 = n;
            } else if (n > mx2)
                mx2 = n;
        }

        return (mx1 - 1) * (mx2 - 1);
    }
}