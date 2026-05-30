// 3120. Count the Number of Special Characters I

/**
 * Intuition
 * we will first add all chars to set
 * then we will traverse a to z lowercase and check if set contains that
 * lowercase and uppercase
 * if it is increase res
 * At last return res
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> s = new HashSet();
        for (char c : word.toCharArray())
            s.add(c);
        int ans = 0;
        for (char c = 'a'; c <= 'z'; c++)
            if (s.contains(c) && s.contains((char) (c - 'a' + 'A')))
                ans++;
        return ans;
    }
}