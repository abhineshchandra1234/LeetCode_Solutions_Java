/**
 * 2264. Largest 3-Same-Digit Number in String
 * 
 * Intuition
 * 
 * credits lancertech6
 * since the window size is fixed and is of small length 3 we can solve it by
 * simple comparison, no need to use sliding window
 * we will parse the num array compare i, i+1, i+2 and update res with max char
 * by converting it to no
 * then we will use a stringbuilder to build our res using the max no
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
    public String largestGoodInteger(String num) {

        int res = -1;
        for (int i = 0; i + 2 < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2))
                res = Math.max(res, num.charAt(i) - '0');
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 3; i++)
            builder.append(res + "");
        return res == -1 ? "" : builder.toString();
    }
}