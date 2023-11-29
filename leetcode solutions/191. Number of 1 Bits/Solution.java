/**
 * 191. Number of 1 Bits
 * 
 * Intuition
 * 
 * credits fabrizio3
 * As it is evident in the question we will do and operation with 1 then shift
 * the no to the right by 1 to calculate no of 1s.
 * we use unsigned operation >>> for bit shifting as >> is used for signed
 * integer
 * Java uses signed int, means out of 32 bits, 16 bits represents positive nos
 * and rest 16 bits represents negative nos
 * Once max limit Integer.MAX_VALUE is reached it will again start from -1. ie
 * Integer.MAX_VALUE+1 is equal to -1.
 * So we use cond while (n != 0) as Integer.MAX_VALUE+1 will not enter loop if
 * cond is n>0
 * A signed integer is a 32-bit datum that encodes an integer in the range
 * [-2147483648 to 2147483647]. An unsigned integer is a 32-bit datum that
 * encodes a nonnegative integer in the range [0 to 4294967295].
 * So java can take Integer.MAX_VALUE+1 or unsigned value but it will return
 * negative value for it.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity:
 * 
 * O(1), airthmatic operation
 * 
 * Space complexity:
 * 
 * O(1)
 * 
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {

        int ones = 0;
        while (n != 0) {
            ones = ones + (n & 1);
            n = n >>> 1;
        }
        return ones;
    }
}