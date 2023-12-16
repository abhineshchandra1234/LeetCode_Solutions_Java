/**
 * 242. Valid Anagram
 * 
 * Intuition
 * 
 * First we will check strings are of equal length if not return false
 * we will solve this using hash table, it will contain freq of each char
 * we will increase freq for s chars and decrease freq for t chars
 * if at the end freq of all chars is 0 return true else false
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
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
            return false;

        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for (int no : freq)
            if (no != 0)
                return false;

        return true;
    }
}