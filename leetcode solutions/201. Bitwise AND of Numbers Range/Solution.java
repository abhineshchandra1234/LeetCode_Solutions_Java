/**
 * 201. Bitwise AND of Numbers Range
 * 
 * Intuition
 * 
 * credits yash0695
 * bitwise and of two numbers always produces a no less than or equal to the
 * smaller no
 * 12 & 11 = 8
 * 8 & 7 = 0
 * we skipped 10, 9
 * if we have done and operation between 10, 9 and 8, answer would have been 8
 * or less than 8
 * so we start the and operation from range end and keep computing till we reach
 * the start
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
    public int rangeBitwiseAnd(int left, int right) {

        while (right > left) {
            right = right & right - 1;
        }
        return left & right;
    }
}