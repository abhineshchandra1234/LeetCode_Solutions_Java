/**
 * 1582. Special Positions in a Binary Matrix
 * 
 * Intuition
 * 
 * As it is evident in the question we will first check which row and col
 * contain 1
 * then again we will traverse the matrix, if we found 1 and its row and col
 * contain only 0s or no other 1. then we got one suitable ans.
 * the question is how to store 1 pos, for that we will use two arrays one of
 * size row and another of size col.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(m∗n)
 * 
 * Space complexity: O(m+n)
 * 
 */
class Solution {
    public int numSpecial(int[][] mat) {

        int m = mat.length, n = mat[0].length, res = 0, row[] = new int[m], col[] = new int[n];

        // count no of 1s in each row and col
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (mat[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }

        // count special positions
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1)
                    res++;

        return res;
    }
}