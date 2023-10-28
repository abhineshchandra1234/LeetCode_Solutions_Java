/**
 * 1220. Count Vowels Permutation
 * 
 * Intuition
 * 
 * we will solve this problem using dp
 * A string can end with "a, e, i, o, u". We need to find total no of such
 * strings of length n.
 * dp[2][a] = dp[1][e] + dp[1][i] + dp[1][u]
 * a comes after "e, i, u". we can append a at end of string ending with "e, i,
 * u" of length 1 to create a new string ending with a of length 2
 * since we need only prev state for each vowels, so only two variables are used
 * to calculate the result.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int countVowelPermutation(int n) {

        long aCnt = 1, eCnt = 1, iCnt = 1, oCnt = 1, uCnt = 1;
        int mod = (int) 1e9 + 7;
        for (int i = 0; i < n - 1; i++) {
            long aCntNew = (eCnt + iCnt + uCnt) % mod;
            long eCntNew = (aCnt + iCnt) % mod;
            long iCntNew = (eCnt + oCnt) % mod;
            long oCntNew = iCnt;
            long uCntNew = (iCnt + oCnt) % mod;

            aCnt = aCntNew;
            eCnt = eCntNew;
            iCnt = iCntNew;
            oCnt = oCntNew;
            uCnt = uCntNew;
        }

        long res = (aCnt + eCnt + iCnt + oCnt + uCnt) % mod;
        return (int) res;
    }
}