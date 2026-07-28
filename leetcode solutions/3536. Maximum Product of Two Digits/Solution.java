// 3536. Maximum Product of Two Digits

/**
 * Intuition
 * we will traverse digits of n using n%10
 * then we will check if it is more than first, if it is replace second with
 * first and first with curr digit
 * then we will check if it is more than second, if it is replace second with
 * curr digit
 * finally return product of first and second as ans
 * Approach
 * 
 * Complexity
 * Time complexity: O(logn)
 * Space complexity: O(1)
 */

class Solution {
    public int maxProduct(int n) {
        int first = 0, second = 0;

        while (n > 0) {
            int x = n % 10;
            if (x > first) {
                second = first;
                first = x;
            } else if (x > second) {
                second = x;
            }
            n /= 10;
        }
        return first * second;
    }
}