/**
 * 58. Length of Last Word
 * 
 * Intuition
 * 
 * Brute Force
 * Split the string according to spaces and store them in array
 * Finally return length of last element of array
 * Optimized Approach
 * using a single ptr to move to first non-empty char from end
 * Then use the same ptr to calculate length of last word, it would do so by
 * again moving till first empty char
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
    public int lengthOfLastWord(String s) {

        int len = 0, tail = s.length() - 1;

        // move to non-empty char from end
        while (tail >= 0 && s.charAt(tail) == ' ')
            tail--;

        // count len of last word
        while (tail >= 0 && s.charAt(tail) != ' ') {
            len++;
            tail--;
        }

        return len;
    }
}