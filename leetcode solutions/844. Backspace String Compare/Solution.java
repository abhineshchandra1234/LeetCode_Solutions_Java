/**
 * 844. Backspace String Compare
 * 
 * Intuition
 * 
 * credits karthickm
 * we can solve this problem using stack using O(n) space, dont want to use
 * two-pointers messy code
 * We will solve it using a helper function
 * helper function will format strings and return the final string with all the
 * backspace chars removed
 * We will format both strings using this helper function and return true if
 * they are equal else return false
 * radhe radhe :)
 * 
 * Approach
 * 
 * helper function will use a String Builder
 * it will use the count of backspace, if its count is greater than 0 then it
 * will skip the char otherwise it will add it to res string.
 * it is using the same logic as visible in the question
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public boolean backspaceCompare(String s, String t) {

        return getString(s).equals(getString(t));
    }

    private String getString(String str) {
        int n = str.length(), count = 0;
        StringBuilder res = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (ch == '#')
                count++;
            else {
                if (count > 0)
                    count--;
                else
                    res.append(ch);
            }
        }
        return res.toString();
    }
}