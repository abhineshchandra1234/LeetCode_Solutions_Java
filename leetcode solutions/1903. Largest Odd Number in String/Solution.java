/**
 * 1903. Largest Odd Number in String
 * 
 * Intuition
 * 
 * credits votrubac
 * we can solve this problem through sliding window but there this is a simpler
 * approach
 * Suppose if we start traversing from front we need to find the rightmost odd
 * integer to get the biggest odd integer if it exist
 * then we need to convert the string to a no and update res with max
 * Further we can optimize it by traversing from back, if we encounter an odd no
 * that will be part of largest odd no and we will return it
 * If we dont encounter any odd no we will return an empty string.
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
    public String largestOddNumber(String num) {

        for (int i = num.length() - 1; i >= 0; i--)
            if (num.charAt(i) % 2 != 0)
                return num.substring(0, i + 1);
        return "";
    }
}