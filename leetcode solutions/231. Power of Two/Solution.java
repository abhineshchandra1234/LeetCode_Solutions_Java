/**
 * 231. Power of Two
 * 
 * Intuition
 * 
 * credits linfq
 * negative or zero cannot be a power of two
 * power of two(n) just contain 1 bit
 * n-1 flips the rightmost 1 bit and rest low bits
 * n & n-1==0, 1000 & 111 ==0, 8 & 7 ==0
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(1), airthmatic operation
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1) == 0;
    }
}