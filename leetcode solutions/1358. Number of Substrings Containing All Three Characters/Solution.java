// 1358. Number of Substrings Containing All Three Characters

/**
 * Intuition
 * we will solve this problem using sliding window
 * a valid window will have freq count of all chars greater than 0
 * once we got a valid window, rest of chars in array n-j will also form valid
 * windows
 * we will add this count to res
 * we will decrease or shrink the window after we have a valid window
 * Finally return the res
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int res = 0;
        int[] m = new int[3];

        int i = 0, j = 0;
        while (j < n) {
            char c = s.charAt(j);
            m[c - 'a']++;

            while (m[0] > 0 && m[1] > 0 && m[2] > 0) {
                res += n - j;
                m[s.charAt(i) - 'a']--;
                i++;
            }
            j++;
        }

        return res;
    }
}