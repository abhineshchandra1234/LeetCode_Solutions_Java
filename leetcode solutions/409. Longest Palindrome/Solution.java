/**
 * 409. Longest Palindrome
 * 
 * Intuition
 * 
 * we will solve this problem through greedy approach
 * a palindrome consist of pair of nos and max 1 char in between
 * we will use set to calculate no of pairs of chars
 * if the set is empty means, all chars exist in pair res is pair*2
 * if the set is non-empty means there are some unique chars out of which one
 * can be part of palindrome so res is pair*2+1
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public int longestPalindrome(String s) {

        HashSet<Character> set = new HashSet();
        int pair = 0;
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                pair++;
            } else
                set.add(c);
        }
        if (!set.isEmpty())
            return pair * 2 + 1;
        return pair * 2;
    }
}
