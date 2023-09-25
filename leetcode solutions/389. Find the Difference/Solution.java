/**
 * 389. Find the Difference
 * 
 * Intuition
 * 
 * credits spestushko
 * As it is visible in the question we can find the ans by taking the diff of
 * total sum of two strings but how to do in single loop
 * we can do it using one var
 * Store last char of t in the var
 * then add each char of t in the var and subtract each char of s from var
 * Finally return the var
 * Another approach is to use the xor which will cancel out the same chars and
 * you will be left with your res.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity:
 * 
 * O(n)
 * 
 * Space complexity:
 * 
 * O(1)
 * 
 */
class Solution {
    public char findTheDifference(String s, String t) {

        int charCode = t.charAt(s.length());

        for (int i = 0; i < s.length(); i++) {
            charCode -= (int) s.charAt(i);
            charCode += (int) t.charAt(i);
        }
        return (char) charCode;
    }
}