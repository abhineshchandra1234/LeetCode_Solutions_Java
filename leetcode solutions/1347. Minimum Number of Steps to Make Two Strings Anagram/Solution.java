/**
 * 1347. Minimum Number of Steps to Make Two Strings Anagram
 * 
 * Intuition
 * 
 * We will find freq of chars in both strings, and add diff to res
 * To optimize computation t will increase freq and s will decrease freq, it can
 * be other way around too as we need to make both strings anagram
 * we will consider positive diff only as chars will be converted
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
    public int minSteps(String s, String t) {

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']--;
            count[t.charAt(i) - 'a']++;
        }

        int res = 0;
        for (int step : count) {
            if (step > 0)
                res += step;
        }
        return res;
    }
}