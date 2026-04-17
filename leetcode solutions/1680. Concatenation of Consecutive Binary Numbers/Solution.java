// 1680. Concatenation of Consecutive Binary Numbers

/**
 * Intuition
 * we need to right shift res according to new no length and add new number
 * new no length will increase for every power of 2
 * ie (i & (i - 1)) == 0, curr no is a power of 2
 * lastly return res
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public int concatenatedBinary(int n) {
        long res = 0;
        int mod = (int) 1e9 + 7;
        int digits = 0;

        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0)
                digits++;
            res = ((res << digits) % mod + i) % mod;
        }

        return (int) res;
    }
}