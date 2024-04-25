/**
 * 2370. Longest Ideal Subsequence
 * 
 * Intuition
 * 
 * credits lee215
 * we will solve this problem through dynamic programming
 * dp[c] will represent longest ideal subsequence length ending with c
 * dp[c] can be part of c-k to c+k subsequence
 * so dp[c] = max(dp[c-k], dp[c-k+1], dp[c+1]..dp[c+k]) + 1
 * return max(dp[c]) as res
 * 
 * Approach
 * 
 * Input: s = "acfgbd", k = 2
 * Output: 4
 * for a there is no LIS for b,c , dp[0] = 1
 * for c there is valid LIS for a as 1, dp[2] = 2
 * for f d,e,g,h doest have LIS, dp[5] = 1
 * for g there is valid LIS for f, dp[6] = 2
 * for b among a,c LIS for c is max, dp[1] = 3
 * for d among a,b,c LIS for b is max, dp[3] = 4
 * 
 * To handle corner cases we have taken array of size 128 + 25 = 153
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int longestIdealString(String s, int k) {

        int[] dp = new int[153];
        int res = 0;

        for (char c : s.toCharArray()) {
            int i = c;
            for (int j = i - k; j <= i + k; j++)
                dp[i] = Math.max(dp[i], dp[j]);
            res = Math.max(res, ++dp[i]);
        }

        return res;
    }
}