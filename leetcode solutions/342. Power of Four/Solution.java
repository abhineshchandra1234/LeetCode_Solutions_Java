/**
 * 342. Power of Four
 * 
 * Intuition
 * 
 * a = b^c
 * log(a) base b = c * log(b) base b
 * log(a) base b / log(b) base b = c
 * log(a) base b / 1 = c
 * therefore c = log(a) base b
 * 
 * ---
 * 
 * log(a) base b = log(a) base e / log(b) base e, where e is 2.718
 * java uses base e for log function
 * 
 * radhe radhe :)
 * 
 * Approach
 * 
 * n == 4^x
 * log(n) base 4 = x * log(4) base 4
 * log(n) base 4 = x * 1
 * log(n) base 4 / 1 = x
 * 
 * log(n) base 4 % 1 == 0
 * log(n) base 4 should be completely divisible by 1 to get x as natural no
 * 
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
class Solution {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (Math.log(n) / Math.log(4)) % 1 == 0;
    }
}