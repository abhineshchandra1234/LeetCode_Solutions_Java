// 190. Reverse Bits

/**
 * Intuition
 * we will left shift res, so that 0 appears in the end and new bit can be added
 * we will fetched last bit from n and add it to res using or operation
 * Then we will right shift n by 1, means last bit has been processed
 * Finally return res
 * Approach
 * 
 * Complexity
 * Time complexity: O(1)
 * Space complexity: O(1)
 */

class Solution {
    public int reverseBits(int n) {

        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= n & 1;
            n >>= 1;
        }

        return res;
    }
}