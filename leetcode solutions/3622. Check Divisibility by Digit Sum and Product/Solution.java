// 3622. Check Divisibility by Digit Sum and Product

/**
 * Intuition
 * we will fetch last digit by taking mod with 10
 * we will remove last digit by dividing by 10
 * we will calculate digit sum and digit product using last digit
 * then at last we will check if original no mod sum of digit sum and digit
 * product is zero return true else false
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public boolean checkDivisibility(int n) {
        int dgSum = 0;
        int dgProd = 1;
        int org = n;

        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            dgSum += digit;
            dgProd *= digit;
        }

        return org % (dgSum + dgProd) == 0;
    }
}