// 3754. Concatenate Non-Zero Digits and Multiply by Sum I

/**
 * Intuition
 * we will solve this problem by simulation and by traversing from right to left
 * we will fetch last digit by taking modulo with 10
 * then we will add this digit to sum
 * if the digit is more than 0, we will add it to x
 * later we will remove the last digit by taking a divide by 10
 * At last we will return x*sum
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public long sumAndMultiply(int n) {
        long x = 0, sum = 0, pow10 = 1;
        while (n > 0) {
            int d = n % 10;
            sum += d;
            if (d > 0) {
                x += d * pow10;
                pow10 *= 10;
            }
            n /= 10;
        }
        return x * sum;
    }
}