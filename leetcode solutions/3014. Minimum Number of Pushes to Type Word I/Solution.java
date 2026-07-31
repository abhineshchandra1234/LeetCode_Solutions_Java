// 3014. Minimum Number of Pushes to Type Word I

/**
 * Intuition
 * different levels will be ((index / 8) + 1)
 * first level will be assigned to chars with most frequency
 * so will first find the frequency of each char
 * then we will sort them, most frequent char will be at the end
 * then we will assign level to most frequent chars first to have less clicks
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];

        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        Arrays.sort(freq);

        int ans = 0;
        int index = 0;

        for (int i = 25; i >= 0; i--) {
            ans += freq[i] * ((index / 8) + 1);
            index++;
        }

        return ans;
    }
}