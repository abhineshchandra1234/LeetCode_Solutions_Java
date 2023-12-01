/**
 * 1662. Check If Two String Arrays are Equivalent
 * 
 * Intuition
 * 
 * credits o_inari
 * we can easily solve this problem using StringBuilder but that will require
 * O(n) space
 * we will use two ptrs(word and char) to solve this problem
 * we will compare curr word and curr char
 * if the curr char ptrs has reached the end of the word, we will reset char ptr
 * to 0 and increase word ptr
 * we will compare this till either of the word ptrs are exhausted
 * At last return true if word ptrs reached end of thier respective array
 * otherwise return false.
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
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        // word ptrs
        int w1 = 0, w2 = 0;
        // char ptrs
        int c1 = 0, c2 = 0;

        while (w1 < word1.length && w2 < word2.length) {

            // compare char ptrs
            if (word1[w1].charAt(c1++) != word2[w2].charAt(c2++))
                return false;

            // first char ptr limit
            if (c1 == word1[w1].length()) {
                w1++;
                c1 = 0;
            }

            // second char ptr limit
            if (c2 == word2[w2].length()) {
                w2++;
                c2 = 0;
            }
        }

        // compare word ptrs with words length
        return w1 == word1.length && w2 == word2.length;
    }
}