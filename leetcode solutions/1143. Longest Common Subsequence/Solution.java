/**
 * 1143. Longest Common Subsequence
 * 
 * Intuition
 * 
 * credit votrubac
 * we will use bottom-up dp to solve this problem
 * we will use dp to track LCS sizes for different combinations of i & j
 * if a[i]==b[j], LCS for i & j would be 1 + LCS of i-1 & j-1
 * else we take the largest LCS if we skip a char from one of the string
 * Math.max(m[i][j + 1], m[i + 1][j])
 * 
 * Approach
 * 
 * you can better understand this by dry running dp table
 * 
 * Complexity
 * 
 * Time complexity: O(n∗m), n & m are string sizes, we are trying
 * every combination of chars to find LCS
 * 
 * Space complexity: O(n∗m), we are storing res for every
 * combinations of chars
 * 
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int n1 = text1.length(), n2 = text2.length();
        int[][] m = new int[n1 + 1][n2 + 1];

        for (int i = 0; i < n1; i++)
            for (int j = 0; j < n2; j++)
                m[i + 1][j + 1] = (text1.charAt(i) == text2.charAt(j)) ? m[i][j] + 1
                        : Math.max(m[i][j + 1], m[i + 1][j]);

        return m[n1][n2];
    }
}

/**
 * Memory Optimized Solution
 * 
 * we are just using two rows, so we will store just these two rows
 * (i % 2) ^ 1 is used to alternate between these two rows and update them using
 * the other one
 * 
 * Complexity
 * 
 * Time complexity: O(n∗m), n & m are string sizes, we are trying
 * every combination of chars to find LCS
 * 
 * Space complexity: O(max(n,m)), we are storing res for
 * every combinations of chars
 * 
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int n1 = text1.length(), n2 = text2.length();
        int max = Math.max(n1, n2);
        int[][] m = new int[2][max + 1];

        for (int i = 0; i < n1; i++)
            for (int j = 0; j < n2; j++)
                m[(i % 2) ^ 1][j + 1] = (text1.charAt(i) == text2.charAt(j)) ? m[i % 2][j] + 1
                        : Math.max(m[i % 2][j + 1], m[(i % 2) ^ 1][j]);

        return m[n1 % 2][n2];
    }
}