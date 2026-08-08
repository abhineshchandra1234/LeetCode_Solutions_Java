// 3302. Find the Lexicographically Smallest Valid Sequence

/**
 * Intuition
 * we will first calculate rghtMatchLength for each index
 * It tells us how many chars of word1 and word2 matches starting from curr idx
 * Then we would traverse both the arrays from start using 2 ptrs
 * if the curr chars matches of both array add curr index to res
 * if it does not we will check if the remaining chars of word2 is present in
 * word1 and we have changing power ie 1 time
 * Then we will add curr idx to res, it symbolizes that we have changed curr
 * char of word1 and convert changing power to false
 * At last we will check if j is equal to m, means we got all chars of word2 in
 * word1, then we will return the res else return an empty list
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] rghtMatchLength = new int[n];
        int rghtMatched = 0;
        int i = n - 1;
        int j = m - 1;

        while (i >= 0) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                rghtMatched++;
                j--;
            }
            rghtMatchLength[i] = rghtMatched;
            i--;
        }

        int[] seq = new int[m];
        int idx = 0;
        boolean changePower = true;
        i = 0;
        j = 0;
        while (i < n && j < m) {
            if (word1.charAt(i) == word2.charAt(j)) {
                seq[idx++] = i;
                j++;
            } else if (changePower == true && i + 1 < n && rghtMatchLength[i + 1] >= m - j - 1) {
                seq[idx++] = i;
                j++;
                changePower = false;
            }
            i++;
        }
        return j == m ? seq : new int[0];
    }
}