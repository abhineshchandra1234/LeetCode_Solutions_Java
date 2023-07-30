/**
 * 664. Strange Printer
 * 
 * Intuition
 * 
 * the questions says the printer can print a sequence of chars
 * it can also print any chars from x to y random positions.
 * we will solve this problem using dp, top-down approach
 * we will divide the problem into smaller sub-problems
 * Note - the printer will run 1 time for single char and 2 time for 2 chars,
 * and that will be the size of subproblems
 * Input: s = "aba"
 * Output: 2
 * divisions are 'a' & 'ba'
 * 'a' -> run printer 1 time
 * 'ba' -> run printer 2 time, it will first print 'bb' then print 'a' on top of
 * 'b'.
 * now we will merge this two answers, the merged string has same first and last
 * char
 * we can print it at one go
 * ans = 1 + 2 - 1 = 2
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(n^3), to visit all dp states i,j. For each state we are making k divisions
 * 
 * Space complexity:
 * 
 * O(n^2), dp space
 * 
 */
class Solution {
    public int strangePrinter(String s) {

        int n = s.length();
        Integer[][] dp = new Integer[n][n];

        return solve(0, n - 1, s, dp);
    }

    public int solve(int i, int j, String s, Integer[][] dp) {

        if (i == j)
            return 1;
        if (dp[i][j] != null)
            return dp[i][j];
        int minTurns = Integer.MAX_VALUE;
        for (int k = i; k < j; k++)
            minTurns = Math.min(minTurns, solve(i, k, s, dp) + solve(k + 1, j, s, dp));
        dp[i][j] = (s.charAt(i) == s.charAt(j)) ? minTurns - 1 : minTurns;
        return dp[i][j];
    }
}