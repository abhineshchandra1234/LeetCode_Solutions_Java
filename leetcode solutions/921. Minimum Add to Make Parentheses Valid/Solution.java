/**
 * 921. Minimum Add to Make Parentheses Valid
 * 
 * Intuition
 * we will calculate the open brackets
 * when we encounter the close bracket, if there is any open bracket close it
 * otherwise increase bracket needed count
 * At last return open bracket count plus needed bracket count
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {

    public int minAddToMakeValid(String s) {

        int openBracket = 0;
        int neededBracket = 0;

        for (char c : s.toCharArray()) {

            if (c == '(')
                openBracket++;
            else {
                if (openBracket > 0)
                    openBracket--;
                else
                    neededBracket++;
            }
        }

        return neededBracket + openBracket;
    }
}