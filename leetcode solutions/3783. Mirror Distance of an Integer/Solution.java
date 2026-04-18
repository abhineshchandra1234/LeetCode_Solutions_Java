// 3783. Mirror Distance of an Integer

/**
 * Intuition
 * we will return absolute difference between no and its reverse
 * Approach
 * 
 * Complexity
 * Time complexity: O(logn)
 * Space complexity: O(1)
 */

class Solution {
    public int mirrorDistance(int n) {
        return Math.abs(n - reverse(n));
    }

    private int reverse(int n) {
        int res = 0;
        while (n > 0) {
            res = res * 10 + (n % 10);
            n /= 10;
        }
        return res;
    }
}