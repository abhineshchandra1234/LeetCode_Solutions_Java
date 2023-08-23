/**
 * 767. Reorganize String
 * 
 * Intuition
 * 
 * credits fangbiyi
 * we will first use an array to store char freq
 * then we will find letter with max freq
 * then we will check the failing condition
 * (maxCount > (s.length() + 1) / 2)
 * here we have increased string length by 1, to calculate odd length string
 * correctly.
 * If above cond fails we have a valid string and we need to just return the
 * ans.
 * So we will first fill ans array at odd index with letter having max freq.
 * Rest chars order doesnt matter and we will fill them at any available index.
 * 
 * Approach
 * 
 * if (index >= s.length())
 * It can happen we started filling other chars from middle of string, in this
 * way, we will reach end of the string and will have front positions in the ans
 * array empty with chars left to fill.
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(n), length of string
 * 
 * Space complexity:
 * 
 * O(k), unique chars in string
 * 
 */
class Solution {
    public String reorganizeString(String s) {

        // freq of chars
        int[] charCounts = new int[26];
        for (char c : s.toCharArray())
            charCounts[c - 'a']++;

        // max freq letter
        int maxCount = 0, letter = 0;
        for (int i = 0; i < charCounts.length; i++) {
            if (charCounts[i] > maxCount) {
                maxCount = charCounts[i];
                letter = i;
            }
        }

        // failing condition
        if (maxCount > (s.length() + 1) / 2)
            return "";

        char[] ans = new char[s.length()];
        int index = 0;

        // place the most freq letter
        while (charCounts[letter] != 0) {
            ans[index] = (char) (letter + 'a');
            index += 2;
            charCounts[letter]--;
        }

        // place rest of the letters in any order
        for (int i = 0; i < charCounts.length; i++) {
            while (charCounts[i] > 0) {
                if (index >= s.length())
                    index = 1;
                ans[index] = (char) (i + 'a');
                index += 2;
                charCounts[i]--;
            }
        }

        return String.valueOf(ans);
    }
}