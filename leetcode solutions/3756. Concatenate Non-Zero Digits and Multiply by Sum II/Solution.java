// 3756. Concatenate Non-Zero Digits and Multiply by Sum II

/**
 * Intuition
 * this problem is very similar to 3754. Concatenate Non-Zero Digits and
 * Multiply by Sum I
 * since there are multiple queries here and repeated results, so we are going
 * to use alot data structures to solve it
 * we will traverse queries and find x and sum
 * x will be equal to nos upto r - nos upto l-1*pow(10), pow 10 will be equal to
 * sub string length
 * sum will be equal to digit sum upto r - digit sum upto l-1
 * Finally we will calculate res for curr query by multiplying x and sum
 * s = "10203004" s[1..3] = "020" x = 2 sum = 2 Therefore, the answer is 2 * 2 =
 * 4.
 * x = 12 - 10 -> 2
 * s = 3 - 1 -> 2
 * res = x * s -> 2*2 -> 4
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

class Solution {
    static final long MOD = (long) (1e9 + 7);

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        int[] nonZeroCount = new int[n]; // non-zero digits count in s[0..i]
        long[] numberUpTo = new long[n]; // number formed from non-zero digits in s[0..i]
        long[] digitSumUpTo = new long[n]; // digit sum of s[0..i]
        long[] pow10 = new long[n + 1]; // 10^i

        pow10[0] = 1;
        for (int i = 1; i <= n; i++)
            pow10[i] = (pow10[i - 1] * 10) % MOD;

        nonZeroCount[0] = (s.charAt(0) != '0') ? 1 : 0;
        numberUpTo[0] = s.charAt(0) - '0';
        digitSumUpTo[0] = s.charAt(0) - '0';

        for (int i = 1; i < n; i++) {
            int digit = s.charAt(i) - '0';
            nonZeroCount[i] = nonZeroCount[i - 1] + (digit != 0 ? 1 : 0);
        }

        for (int i = 1; i < n; i++) {
            int digit = s.charAt(i) - '0';
            if (digit != 0)
                numberUpTo[i] = (numberUpTo[i - 1] * 10 + digit) % MOD;
            else
                numberUpTo[i] = numberUpTo[i - 1];
        }

        for (int i = 1; i < n; i++) {
            digitSumUpTo[i] = digitSumUpTo[i - 1] + (s.charAt(i) - '0');
        }

        int q = queries.length;
        int[] result = new int[q];

        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int startCount = (l == 0) ? 0 : nonZeroCount[l - 1];
            long numBefore = (l == 0) ? 0 : numberUpTo[l - 1];

            int endCount = nonZeroCount[r];
            int subStrLen = endCount - startCount;

            if (subStrLen == 0) {
                result[i] = 0;
                continue;
            }

            long x = (numberUpTo[r] - (numBefore * pow10[subStrLen] % MOD) + MOD) % MOD;
            long sum = digitSumUpTo[r] - ((l == 0) ? 0 : digitSumUpTo[l - 1]);

            result[i] = (int) ((x * sum) % MOD);
        }

        return result;
    }
}