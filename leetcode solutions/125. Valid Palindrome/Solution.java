// 125. Valid Palindrome

/**
 * Intuition
 * we will first traverse string, if the curr char is letter or number we will
 * add it in stringbuilder
 * then we will traverse stringbuilder using two ptrs, if the curr char at the
 * ptrs are not equal, return false
 * return true at the end, meaning all chars are equal
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public boolean isPalindrome(String s) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z')
                sb.append(c);
            else if (c >= 'A' && c <= 'Z') {
                c = (char) (c - 'A' + 'a');
                sb.append(c);
            } else if (c >= '0' && c <= '9')
                sb.append(c);
        }

        int start = 0;
        int end = sb.length() - 1;
        while (start < end) {
            if (sb.charAt(start) != sb.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}