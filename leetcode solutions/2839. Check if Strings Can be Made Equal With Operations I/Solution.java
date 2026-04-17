// 2839. Check if Strings Can be Made Equal With Operations I

/**
 * Intuition
 * we have taken two arrays even and odd
 * we can swap even index no at even places and odd index no at odd places
 * For s1 we will increase char count of even array and s2 will decrease char
 * count of even array, similarly we will do for odd arrays for both strings
 * At last we will check if both the arrays cells are not equal to 0, then
 * return false
 * Otherwise return true at the end
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public boolean canBeEqual(String s1, String s2) {

        int[] even = new int[26];
        int[] odd = new int[26];

        int n = s1.length();

        for (int i = 0; i < 4; i++) {
            if (i % 2 == 0) {
                even[s1.charAt(i) - 'a']++;
                even[s2.charAt(i) - 'a']--;
            } else {
                odd[s1.charAt(i) - 'a']++;
                odd[s2.charAt(i) - 'a']--;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (even[i] != 0 || odd[i] != 0)
                return false;
        }

        return true;
    }
}