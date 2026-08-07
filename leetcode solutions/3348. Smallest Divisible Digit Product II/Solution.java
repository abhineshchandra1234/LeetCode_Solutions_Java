// 3348. Smallest Divisible Digit Product II

/**
 * Intuition
 * we will first check if t has only prime factors as 2,3,5,7. if it has other
 * prime factors of two digits it is not valid according to our question and
 * return -1
 * then we will find remaining factors for all the indices
 * remaining factor of next index will be equal to remaining factor of curr
 * index divided by gcd of curr remaining factor and curr digit
 * if remaining factor of nth place is 1, means the input itself is sufficient
 * and we will return it
 * then we will solve from index of zero or otherwise n as we need zero free no
 * then we will traverse from right to left of nums
 * we will increase the last digit and check further required and the required
 * number
 * if the required number length is equal to free slots, we will return the nums
 * substring from 0 to i plus the increased digit and the required no
 * we can have scenario in which num is very less than t, then we will use
 * freeSlotsFiller function to check the next bigger digit no
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

class Solution {

    // smallest zero-free number of length at least "length" divisible by "required"
    private String freeSlotsFiller(long required, int length) {
        StringBuilder str = new StringBuilder();

        for (int digit = 9; digit >= 2; digit--) {
            while (required % digit == 0) {
                str.append((char) (digit + '0'));
                required /= digit;
            }
        }

        while (str.length() < length) { // pad with 1s
            str.append('1');
        }

        str.reverse();
        return str.toString();
    }

    public String smallestNumber(String num, long t) {
        int n = num.length();

        // Check primes 2,3,5,7
        long temp = t;
        for (int primeFact : new int[] { 2, 3, 5, 7 }) {
            while (temp % primeFact == 0) {
                temp /= primeFact;
            }
        }

        if (temp != 1) { // it means there are other primes apart from 2, 3, 5, 7
            return "-1";
        }

        // Precompute remainingFactor[i] = if we take i digits of num in my result, what
        // factor remaining for t
        long[] remainingFactor = new long[n + 1];
        remainingFactor[0] = t;
        // "123045"
        for (int i = 0; i < n; i++) {
            int digit = num.charAt(i) - '0';

            if (digit == 0) {
                break;
            }

            remainingFactor[i + 1] = remainingFactor[i] / gcd(remainingFactor[i], digit);
        }

        if (remainingFactor[n] == 1) { // the input itself is sufficient for t
            return num;
        }

        int zeroPos = num.indexOf('0');
        int zeroIdx = n - 1;
        if (zeroPos != -1) {
            zeroIdx = zeroPos;
        }

        for (int i = zeroIdx; i >= 0; i--) {
            long required = remainingFactor[i];
            int freeSlots = n - 1 - i; // free slots to the right of i

            for (int digit = (num.charAt(i) - '0') + 1; digit <= 9; digit++) {
                long furtherRequired = required / gcd(required, digit);
                String requiredNumber = freeSlotsFiller(furtherRequired, freeSlots);

                if (requiredNumber.length() == freeSlots) {
                    return num.substring(0, i) + (char) (digit + '0') + requiredNumber;
                }
            }
        }

        return freeSlotsFiller(t, n + 1); // num = "11", t = 2^15
    }

    // greatest common divisor
    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}