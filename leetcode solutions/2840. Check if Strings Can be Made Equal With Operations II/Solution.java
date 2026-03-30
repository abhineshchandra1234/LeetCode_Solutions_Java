// 2840. Check if Strings Can be Made Equal With Operations II

/**
 * Intuition
 * this problem is similar to "2839. Check if Strings Can be Made Equal With
 * Operations I"
 * In this we checking for n chars instead 4 chars like in the other question
 * All the logic will remain same as the other question
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public boolean checkStrings(String s1, String s2) {
        int[] even = new int[26];
        int[] odd = new int[26];

        int n = s1.length();

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) { // even indices
                even[s1.charAt(i) - 'a']++;
                even[s2.charAt(i) - 'a']--;
            } else { // odd indices
                odd[s1.charAt(i) - 'a']++;
                odd[s2.charAt(i) - 'a']--;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (even[i] != 0 || odd[i] != 0) {
                return false;
            }
        }

        return true;
    }
}