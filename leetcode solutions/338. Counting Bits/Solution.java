/**
 * 338. Counting Bits
 * 
 * Intuition
 * 
 * even no will have same no of bits as its half.
 * Like 2 & 4 have 1 bit
 * odd nos will have same no of bits as its half + 1.
 * Like 3 & 5 have 2 bits
 * we will traverse the list and find no of bits in n/2 and if the no is odd add
 * one more bit.
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int[] countBits(int n) {

        int[] res = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            res[i] = res[i / 2] + i % 2;
        }

        return res;
    }
}