// 28. Find the Index of the First Occurrence in a String

/**
 * Intuition
 * we will traverse through haystack length - needle length
 * Then for each index, create a substring of size needle
 * Then check if this substring is equal to needle
 * If strings are equal return i, else continue the check with next index
 * Finally return -1, if no index is found
 * Approach
 * 
 * Complexity
 * Time complexity: O(n*m), n haystack length, m needle length
 * Space complexity: O(m), generating substring of size needle
 */

class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length())
            return -1;

        for (int i = 0; i <= haystack.length() - needle.length(); i++)
            if (haystack.substring(i, i + needle.length()).equals(needle))
                return i;

        return -1;
    }
}