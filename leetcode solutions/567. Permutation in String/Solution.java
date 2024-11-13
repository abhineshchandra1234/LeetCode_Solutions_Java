/**
 * 567. Permutation in String
 * 
 * Intuition
 * we can solve this problem through sliding window
 * for each window of size s1, we need to check if freq of 26 chars match or not
 * if it does, we got our ans return true
 * s1 chars freq will match ie 1, rest chars freq will be 0
 * Initially we will check for s1 length, if it does return true there itself
 * then we will check for rest of the length s2-s1
 * Approach
 * 
 * Complexity
 * Time complexity: O(n), sliding window
 * Space complexity: O(1), storing freq of 26 chars
 */
class Solution {

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length())
            return false;

        int[] s1map = new int[26];
        int[] s2map = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (s1map[i] == s2map[i])
                count++;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {

            int r = s2.charAt(i + s1.length()) - 'a', l = s2.charAt(i) - 'a';
            if (count == 26)
                return true;

            s2map[r]++;
            if (s2map[r] == s1map[r])
                count++;
            else if (s2map[r] == s1map[r] + 1) {
                // they were earlier equal, now we made it big
                count--;
            }

            s2map[l]--;
            if (s2map[l] == s1map[l])
                count++;
            else if (s2map[l] == s1map[l] - 1) {
                // they were earlier equal, now we made it small
                count--;
            }
        }

        return count == 26;
    }
}