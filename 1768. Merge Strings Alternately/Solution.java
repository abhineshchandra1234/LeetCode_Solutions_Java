/**
 * 1768. Merge Strings Alternately
 * 
 * Intuition
 * We will solve this using single pointer
 * We will increase ptr from 0 till it is less than word1 or word2 length.
 * Inside we will check if ptr is less than word1 length then add word1 char in
 * res. Same we will do for word2.
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {
    public String mergeAlternately(String word1, String word2) {

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < word1.length() || i < word2.length(); i++) {
            if (i < word1.length())
                res.append(word1.charAt(i));
            if (i < word2.length())
                res.append(word2.charAt(i));
        }
        return res.toString();
    }
}