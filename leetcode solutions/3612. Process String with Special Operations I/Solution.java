// 3612. Process String with Special Operations I

/**
 * Intuition
 * we will solve this problem through simulation
 * we will convert string to char array and traverse it
 * if current char is * and string is not empty delete last char
 * if curr char is # append whole string to itself
 * if curr char is % reverse the whole res string
 * else append curr char to the res string
 * Finally return the res string
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

class Solution {
    public String processStr(String s) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                if (res.length() > 0)
                    res.deleteCharAt(res.length() - 1);
            } else if (c == '#')
                res.append(res.toString());
            else if (c == '%')
                res.reverse();
            else
                res.append(c);
        }
        return res.toString();
    }
}