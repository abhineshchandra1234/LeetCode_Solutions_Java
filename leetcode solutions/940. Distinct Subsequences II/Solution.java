// 940. Distinct Subsequences II

/**
 * Intuition
 * if we generate all substring it will take 2^1000 times, which will give us
 * tle
 * no of substring for a given string of size n is equal to 2* ans(n-1)
 * duplicates can arise if the curr char has occured earlier
 * duplicates will be equal to ans of (index - 1), where index is the last seen
 * index
 * thats it, we need to subtract empty substring
 * so our final ans will be total - duplicates - 1
 * we will return this res
 * we an solve this using recursion plus memoization
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

class Solution {
    int m = (int) (1e9 + 7);
    int[] dp = new int[2001];
    int[] prev;

    public int distinctSubseqII(String s) {
        int n = s.length();
        Arrays.fill(dp, -1);
        prev = new int[n + 1];
        int[] lastSeen = new int[26];

        for (int i = 1; i <= n; i++) {
            int idx = s.charAt(i - 1) - 'a';
            prev[i] = lastSeen[idx];
            lastSeen[idx] = i;
        }
        // -1 for empty string
        return (solve(n) - 1 + m) % m;
    }

    private int solve(int n) {
        if (n == 0)
            return 1;
        if (dp[n] != -1)
            return dp[n];

        int total = (int) (2L * solve(n - 1) % m);
        if (prev[n] != 0) {
            int dups = solve(prev[n] - 1);
            total = (total - dups + m) % m;
        }

        return dp[n] = total;
    }
}