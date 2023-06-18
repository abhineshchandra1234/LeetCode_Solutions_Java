/**
 * 2466. Count Ways To Build Good Strings
 * 
 * Intuition
 * For each index we have choice we can either enter 0 or 1 for zero and one
 * times.
 * like - low = 2, high = 3, zero = 1, one = 2
 * 0| 1,1| 0| 0| 1,1
 * Since there is a choice involved we will use dp
 * We are entering choices for high length, so we will take dp of length high+1.
 * like - low = 2, high = 3, zero = 1, one = 2
 * for index 3
 * 0 _ _
 * no of string combinations dp[i-zero]=dp[3-1]=dp[2]
 * 1 _ _
 * no of string combinations dp[i-one]=dp[3-1]=dp[2];
 * _ _ or dp[2] reprsents all the good string combinations, we are reusing it
 * here.
 * if we append 0 or 1 to _ _ string combinations will remain same.
 * _ _ can exist at any index 0, 1, 2 but its count will be same.
 * 
 * Complexity
 * Time complexity: O(high)
 * Space complexity: O(high)
 */
class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {

        int dp[] = new int[high + 1], res = 0, mod = (int) 1e9 + 7;
        dp[0] = 1;
        for (int i = 1; i <= high; i++) {
            // if we can add 0 string then add
            if (i >= zero) {
                dp[i] = (dp[i] + dp[i - zero]) % mod;
            }
            // if we can add 1's string i.e i >= len of 1's string
            if (i >= one) {
                dp[i] = (dp[i] + dp[i - one]) % mod;
            }
            // if i is in between low and high add
            if (i >= low) {
                res = (res + dp[i]) % mod;
            }
        }
        return res;
    }
}