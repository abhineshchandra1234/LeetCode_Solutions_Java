// 3658. GCD of Odd and Even Sums

/**
 * Intuition
 * sum of first n odd no is n^2
 * sum of first n even nos is n*n+1
 * we will return gcd of both the sums
 * Approach
 * 
 * Complexity
 * Time complexity: O(logn)
 * Space complexity: O(logn)
 */

class Solution {
    public int gcdOfOddEvenSums(int n) {
        return gcd(n * n, n * (n + 1));
    }

    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}