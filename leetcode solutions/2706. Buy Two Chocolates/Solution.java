/**
 * 2706. Buy Two Chocolates
 * 
 * Intuition
 * 
 * As evident in the question just find two mins.
 * then find left by taking diff of money & two mins sum
 * if the left is greater or equal to 0 return left otherwise money
 * we can use sorting, heap or other techniques but this is the most efficient
 * one.
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
    public int buyChoco(int[] prices, int money) {

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int p : prices) {
            if (p < min1) {
                min2 = min1;
                min1 = p;
            } else if (p < min2)
                min2 = p;
        }

        int left = money - (min1 + min2);
        return left >= 0 ? left : money;
    }
}