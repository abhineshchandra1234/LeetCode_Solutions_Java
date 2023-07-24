/**
 * 50. Pow(x, n)
 * 
 * Intuition
 * 
 * If the n is 0 return 1
 * If the n is -ve convert n to +ve and divide x by 1.
 * then we can do usual calculation
 * Run a loop till power is not equal to 0
 * if the n%2==1, multiply x to res and reduce n by 1
 * now n is even
 * then multiply x with itself and reduce n by n/2
 * 
 * Complexity
 * 
 * Time complexity: O(log n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public double myPow(double x, int n) {
        long nn = n;
        if (nn == 0)
            return 1;
        if (nn < 0) {
            nn = -nn;
            x = 1 / x;
        }
        double res = 1;
        while (nn > 0) {
            if (nn % 2 == 1) {
                res *= x;
                nn -= 1;
            }
            x *= x;
            nn /= 2;
        }
        return res;
    }
}