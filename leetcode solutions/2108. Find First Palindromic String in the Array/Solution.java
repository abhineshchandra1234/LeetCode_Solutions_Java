/**
 * 2108. Find First Palindromic String in the Array
 * 
 * Intuition
 * 
 * reverse
 * we can solve this by reversing each string and comparing it but it will take
 * extra O(m) space to store reversed string
 * two pointers
 * we will traverse each string and compare front and back chars using two-ptrs.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n∗m), for n strings of m avg length
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public String firstPalindrome(String[] words) {

        for (String s : words)
            if (isPalindrome(s))
                return s;
        return "";
    }

    private boolean isPalindrome(String s) {

        int start = 0, end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}