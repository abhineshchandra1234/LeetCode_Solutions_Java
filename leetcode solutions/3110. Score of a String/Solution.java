/**
 * 3110. Score of a String
 * 
 * Intuition
 * 
 * we will simply traverse the string and store absolute sum of adjacent chars
 * in res.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int scoreOfString(String s) {

        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++)
            sum += Math.abs(s.charAt(i) - s.charAt(i + 1));
        return sum;
    }
}