// 1979. Find Greatest Common Divisor of Array

/**
 * Intuition
 * we will find the largest no and the smallest no
 * we will find their gcd and return it
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 * 
 */

class Solution {
    public int findGCD(int[] nums) {
        int mx = Integer.MIN_VALUE;
        int mn = Integer.MAX_VALUE;

        for (int num : nums) {
            mx = Math.max(mx, num);
            mn = Math.min(mn, num);
        }

        return gcd(mx, mn);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}