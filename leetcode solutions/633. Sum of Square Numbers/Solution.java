/**
 * 633. Sum of Square Numbers
 * 
 * Intuition
 * 
 * Given a no c, we need to determine whether there two nos exist
 * such that a^2 + b^2 = c
 * It is evident from the question a & b will be less than sqrt(c)
 * we will solve this problem using two ptrs
 * one ptr will point to 0, other will point to sqrt(c)
 * we will find their product, if the product is equal to c return true
 * if the prod is less increase l, if the prod is more decrease r
 * At last return false, means no suitable a & b found.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(sqrt(c))
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public boolean judgeSquareSum(int c) {

        long l = 0, r = (int) Math.sqrt(c);
        while (l <= r) {
            long prod = l * l + r * r;
            if (prod == c)
                return true;
            else if (prod > c)
                r--;
            else
                l++;
        }
        return false;
    }
}