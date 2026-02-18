// 693. Binary Number with Alternating Bits

/**
 * Intuition
 * First convert n to binary string
 * Then just check if alternating chars are equal, if they are return false
 * At last return true
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public boolean hasAlternatingBits(int n) {
        String b = Integer.toBinaryString(n);

        for (int i = 0; i < b.length() - 1; i++) {
            if (b.charAt(i) == b.charAt(i + 1))
                return false;
        }
        return true;
    }
}