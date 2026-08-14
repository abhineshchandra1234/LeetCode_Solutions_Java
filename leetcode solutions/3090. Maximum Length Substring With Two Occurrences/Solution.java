// 3090. Maximum Length Substring With Two Occurrences

/**
 * Intuition
 * It is similar to 2958. Length of Longest Subarray With at Most K Frequency
 * we will solve this problem using sliding window
 * we will expand the window towards right and updating each char frequency
 * if the curr char freq is more than 2, we will shrink the window from left
 * till above condition prevails and update each char frequency
 * Now we have a valid window, we will update res with max of res and current
 * window length
 * Finally return res
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int[] freq = new int[26];
        int i = 0, j = 0, res = 0;

        while (j < n) {
            int ch = s.charAt(j) - 'a';
            freq[ch]++;
            while (freq[ch] > 2) {
                int ch2 = s.charAt(i) - 'a';
                freq[ch2]--;
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }

        return res;
    }
}