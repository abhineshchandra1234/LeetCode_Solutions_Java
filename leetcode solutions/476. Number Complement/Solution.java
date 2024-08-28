/**
 * 476. Number Complement
 * 
 * Intuition
 * we are given an integer num, we need to return its complement
 * 
 * Approach
 * the brute force approach is, we first convert int to binary string
 * then traverse string and add its opposite to stringbuilder
 * Finally convert stringbuilder to base 2 int and return it
 * A more optimized approach is to use a mask of same binary string length whose
 * all bits are 1
 * then use xor operation to flip the bits and finally return the res
 * 
 * Complexity
 * Time complexity: O(1)
 * Space complexity: O(1)
 */
class Solution {

    public int findComplement(int num) {

        int length = Integer.toBinaryString(num).length();

        int mask = (1 << length) - 1;

        return num ^ mask;
    }
}