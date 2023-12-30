/**
 * 1897. Redistribute Characters to Make All Strings Equal
 * 
 * Intuition
 * 
 * credits lancertech6
 * the approach is simple we need to find freq of each chars and check if can we
 * can distribute it equally in all words
 * Few more checks can be done before above for faster computation
 * If there is a single word return true
 * Count total chars and check if it can be re-distributed equally.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n∗k), n words with k avg length
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public boolean makeEqual(String[] words) {

        if (words.length == 1)
            return true;

        int totalCharCount = 0;
        for (String s : words)
            totalCharCount += s.length();

        if (totalCharCount % words.length != 0)
            return false;

        int[] map = new int[26];
        for (String s : words)
            for (char c : s.toCharArray())
                map[c - 'a']++;

        for (int i : map)
            if (i % words.length != 0)
                return false;

        return true;
    }
}