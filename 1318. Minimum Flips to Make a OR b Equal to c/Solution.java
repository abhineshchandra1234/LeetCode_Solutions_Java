/**
 * 1318. Minimum Flips to Make a OR b Equal to c
 * 
 * Intuition
 * credits mzchen
 * Step 1: a | b is what we have while c is what we want. An XOR operation finds
 * all different bits, i.e. (a | b) ^ c sets the bits where flip(s) is needed.
 * Then we count the set bits.
 * Step 2: There is only one case when two flips are needed: a bit is 0 in c but
 * is 1 in both a and b. An AND operation finds all common 1 bits, i.e. a & b &
 * ((a | b) ^ c) sets the common 1 bits in a, b and the must-flip bits found in
 * Step 1.
 * a | b | a ^ b
 * ----|-----|------
 * 0 | 0 | 0
 * 0 | 1 | 1
 * 1 | 0 | 1
 * 1 | 1 | 0
 * In case of common bits a=1, b=1, (a | b) ^ c)=1. So & operation help to count
 * the extra flip.
 * 
 * Complexity
 * Time complexity:
 * O(L), no of bits
 * 
 * Space complexity: O(1)
 */
class Solution {
    public int minFlips(int a, int b, int c) {

        return Integer.bitCount(c ^= (a | b)) + Integer.bitCount(a & b & c);
    }
}