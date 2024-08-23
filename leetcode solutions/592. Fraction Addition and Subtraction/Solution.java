/**
 * 592. Fraction Addition and Subtraction
 * 
 * Intuition
 * we are given the expression string +-numerator/denominator
 * we need to return a string in the fraction format
 * 
 * Approach
 * we can solve this problem through simulation
 * when we add or subtract two fractions, following formula is used to find new
 * fraction
 * numerator = n1 * d2 + n2 * d1
 * denominator = d1 * d2
 * Thats it our problem is solved
 * we will traverse string build numerator and denominator for each divide sign
 * calculate new fraction using above formula
 * When we get the final fraction we will reduce it using gcd or hcf
 * we can use regex but it is difficult to understand and difficult to come up
 * with expression during interview
 * 
 * Complexity
 * Time complexity: O(n), traverse string
 * Space complexity: O(1), find gcd, airthmatic expression
 */
class Solution {

    public String fractionAddition(String expression) {

        int n = expression.length();
        int num = 0;
        int deno = 1;

        int i = 0;

        while (i < n) {

            int currNum = 0;
            int currDeno = 0;
            boolean isNegative = false;

            // check for sign
            if (expression.charAt(i) == '-' || expression.charAt(i) == '+') {

                if (expression.charAt(i) == '-')
                    isNegative = true;
                i++;
            }

            // build numerator
            while (Character.isDigit(expression.charAt(i))) {
                int val = expression.charAt(i) - '0';
                currNum = currNum * 10 + val;
                i++;
            }

            if (isNegative)
                currNum *= -1;

            // skip divisor
            i++;

            // build denominator
            while (i < n && Character.isDigit(expression.charAt(i))) {
                int val = expression.charAt(i) - '0';
                currDeno = currDeno * 10 + val;
                i++;
            }

            // merge fraction
            num = num * currDeno + deno * currNum;
            deno = deno * currDeno;
        }

        int gcd = Math.abs(findGcd(num, deno));
        num /= gcd;
        deno /= gcd;

        return num + "/" + deno;
    }

    private int findGcd(int a, int b) {
        if (a == 0)
            return b;
        return findGcd(b % a, a);

    }
}