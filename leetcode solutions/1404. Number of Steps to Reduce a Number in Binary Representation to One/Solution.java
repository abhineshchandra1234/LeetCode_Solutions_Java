/**
 * 1404. Number of Steps to Reduce a Number in Binary Representation to One
 * 
 * Intuition
 * 
 * odd nos will have 1 at the end, even nos will have 0 at the end
 * to divide the binary no by 2, we need to remove one its 2 power by right
 * shifting it, or slashing last digit
 * to multiply binary no by 2, we need to add 2 power by left shifting it
 * we will try to simulate the steps required to reduce the nos
 * If the last digit is 1, means no is odd and require 2 steps. First to convert
 * it to even, then to divide that no by 2
 * If the last digit is 0, means no is even and require 1 step. Just divide the
 * no by 2.
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
    public int numSteps(String s) {

        int res = 0;
        int carry = 0;

        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) - '0' + carry == 1) {
                carry = 1;
                res += 2;
            } else
                res += 1;
        }

        return res + carry;
    }
}