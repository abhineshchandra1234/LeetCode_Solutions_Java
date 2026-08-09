// 3345. Smallest Divisible Digit Product I

/**
 * Intuition
 * we will increase curr no by 1 max 10 times
 * in this we will get either a product divisible by t or 0 which will be
 * divisible by all t
 * Approach
 * 
 * Complexity
 * Time complexity: O(10logn), we are checking at most 10 nos and finding their
 * products
 * Space complexity: O(1)
 */

class Solution {
    public int smallestNumber(int n, int t) {
        while (!check(n, t)) {
            n++;
        }
        return n;
    }

    private boolean check(int num, int t) {
        int prod = 1;
        while (num > 0) {
            prod *= num % 10;
            num /= 10;
            if (prod == 0)
                break;
        }
        return prod % t == 0;
    }
}