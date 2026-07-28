// 3517. Smallest Palindromic Rearrangement I

/**
 * Intuition
 * we will first sort half of the given string
 * Then we will copy first half characters to other half in the mirror way or
 * palindromic way
 * Approach
 * 
 * Complexity
 * Time complexity: O(nlogn)
 * Space complexity: O(1)
 */

class Solution {
    public String smallestPalindrome(String s) {

        int n = s.length();
        int mid = n / 2;
        char[] chars = s.toCharArray();
        Arrays.sort(chars, 0, mid);
        for (int i = 0; i < mid; i++) {
            chars[n - 1 - i] = chars[i];
        }
        return new String(chars);
    }
}