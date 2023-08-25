/**
 * 97. Interleaving String
 * 
 * Intuition
 * 
 * we will solve this through bfs using bottom-up approach
 * we will solve it using two pointers, for each strs
 * you will notice s3[k] is always point to s3[i+j] ie sum of curr indexes
 * if s1[i]==s3[i+j] we will call dfs(i+1,j) but we already have this state in
 * dp since we are solving from backwards, we will use dp[i+1][j]
 * if it is true assign true to curr dp[i][j]
 * if s2[j]==s3[i+j] and dp[i][j+1]
 * dp[i][j]= true
 * At last return result at dp[0][0]
 * 
 * Approach
 * 
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * i=5, j=5 , k=5+5=10
 * here s1[i] = s2[j] = s3[k] = ""
 * i=4, j=5, k=4+5=9
 * here s1[i] = s3[k] = 'c'
 * like this reach top-left corner for res
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(m*n), parsing two strings or dp states
 * 
 * Space complexity:
 * 
 * O(m*n), dp states
 * 
 * 
 */
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        if (n1 + n2 != n3)
            return false;

        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        dp[n1][n2] = true;

        for (int i = n1; i >= 0; i--) {
            for (int j = n2; j >= 0; j--) {
                if (i < n1 && s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j])
                    dp[i][j] = true;
                if (j < n2 && s2.charAt(j) == s3.charAt(i + j) && dp[i][j + 1])
                    dp[i][j] = true;
            }
        }
        return dp[0][0];
    }
}
