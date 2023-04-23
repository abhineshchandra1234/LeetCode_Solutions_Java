/**
 * 1416. Restore The Array
 * 
 * Intuition
 * for s = "1317", k = 2000
 * we can have [1] & "317" passed to helper func
 * we can have [13] & "17" passed to helper func
 * [131] & "7" passed to helper func
 * Similarliry we can have [3] & "17" passed to helper function
 * So we are recursively solving this and states can repeat so we will use dp
 * dp[i] means number of the possible arrays that can be printed as s from index
 * i.
 * 
 * Approach
 * we will use helper function and pass string, k, index 0 and dp.
 * if index reaches s.length() means that index is computed and a way is found.
 * like - 1317, 317, 17, 7.
 * No doesnt have leading 0 so it is a invalid state
 * Already computed return result.
 * check if the no is valid from curr index by comparing with k and call dfs for
 * next index.
 * like "1317" is valid 13171 is not valid as it is > 2000
 * 
 * Complexity
 * Time complexity:
 * O(n*log10(k))
 * 
 * For every index max number length will be log10k ie 9
 * 
 * Space complexity:
 * 
 * O(n)
 */
class Solution {
    public int numberOfArrays(String s, int k) {

        Integer[] dp = new Integer[s.length()];
        return dfs(s, k, 0, dp);
    }

    int dfs(String s, long k, int i, Integer[] dp) {

        if (i == s.length())
            return 1;
        if (s.charAt(i) == '0')
            return 0;
        if (dp[i] != null)
            return dp[i];
        int ans = 0, mod = (int) 1e9 + 7;
        long num = 0;
        for (int j = i; j < s.length(); j++) {
            num = num * 10 + s.charAt(j) - '0';
            if (num > k)
                break;
            ans += dfs(s, k, j + 1, dp);
            ans %= mod;
        }
        return dp[i] = ans;
    }
}