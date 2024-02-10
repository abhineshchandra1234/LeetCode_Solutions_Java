/**
 * 647. Palindromic Substrings
 * 
 * Intuition
 * 
 * credits shawngao
 * we will extend palindrome for each char for odd and even length strings,
 * considering curr char as mid
 * For every change in string length we will increase the palindrome count
 * 
 * Approach
 * 
 * Input: s = "aaa"
 * Output: 6
 * palindromes for different chars
 * 0th char -> a, aa
 * 1th char -> a, aaa, aa
 * 2th char -> a
 * 
 * Complexity
 * 
 * Time complexity: O(n^2), we are extending palindrome for each chars
 * in right and left direction
 * 
 * Space complexity: O(1), we are increasing count for every increase in
 * window
 * 
 */
class Solution {

    int count = 0;

    public int countSubstrings(String s) {
        // i is the mid point
        for (int i = 0; i < s.length(); i++) {
            // odd length
            extendPalindrome(s, i, i);
            // even length
            extendPalindrome(s, i, i + 1);
        }
        return count;
    }

    private void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}