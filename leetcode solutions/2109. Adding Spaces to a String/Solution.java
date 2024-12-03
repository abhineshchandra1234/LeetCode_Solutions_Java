/**
 * 2109. Adding Spaces to a String
 * 
 * Intuition
 * spaces are sorted in ascending order, so we can use two ptrs to solve this
 * first ptr will traverse string, sec ptr will traverse space index
 * when both index are same add space to the res
 * keep appending every char to result
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {

    public String addSpaces(String s, int[] spaces) {
        StringBuilder res = new StringBuilder();
        int sp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (sp < spaces.length && i == spaces[sp]) {
                res.append(' ');
                sp++;
            }
            res.append(s.charAt(i));
        }
        return res.toString();
    }
}