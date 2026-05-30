// 3121. Count the Number of Special Characters II

/**
 * Intuition
 * we will store last occurance of small char and first occurance of large char
 * in a hashtable
 * then we will compare both if former is less than later, then increase the
 * count
 * Finally return the count
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lastS = new int[26];
        int[] firstC = new int[26];

        Arrays.fill(lastS, -1);
        Arrays.fill(firstC, -1);

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isLowerCase(ch))
                lastS[ch - 'a'] = i;
            else if (firstC[ch - 'A'] == -1)
                firstC[ch - 'A'] = i;
        }

        int count = 0;
        for (int i = 0; i < 26; i++)
            if (lastS[i] != -1 && firstC[i] != -1 && lastS[i] < firstC[i])
                count++;

        return count;
    }
}