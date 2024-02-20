/**
 * 91. Decode Ways
 * 
 * Intuition
 * 
 * credits yfcheng
 * we will solve this problem with dp
 * String of size 0 will have 1 way to decode it dp[0] = 1
 * dp[1] means ways to decode string of size 1
 * then we will take one or two combinations along the way and store it in res
 * dp[n] will contain the end res.
 * dp[i] += dp[i-1], for single digit
 * dp[i] += dp[i-2], for double digit
 * 
 * Approach
 * 
 * //we can decode digit by taking one or two digits,
 * 2 2 6 -> "BBF" -> one possible way
 * 2 26 -> "BZ" -> one possible way
 * 22 6 -> "VF" -> one possible way
 * Input: s = "226"
 * Output: 3
 * dp[1] = '2' = 1
 * //if we separate 2 ways to decode rest ie '2'
 * //if we separate 22 ways to decode rest ie ''
 * dp[2] = '2' '2' = 1, '22' = 1, 1 + 1 = 2
 * //if we separate 6 ways to decode rest ie 22
 * //if we separate 26 ways to decode rest ie 2
 * dp[3] = '22' '6' = 2, '2' '26' = 1, 2 + 1 = 3
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public int numDecodings(String s) {

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int sec = Integer.valueOf(s.substring(i - 2, i));

            if (first >= 1 && first <= 9)
                dp[i] += dp[i - 1];
            if (sec >= 10 && sec <= 26)
                dp[i] += dp[i - 2];
        }
        return dp[n];
    }
}