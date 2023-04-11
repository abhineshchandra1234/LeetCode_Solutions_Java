/**
 * 2390. Removing Stars From a String
 * 
 * Intuition
 * We will use StringBuilder to solve this
 * If we encounter '*' we will delete last char of StringBuilder else will add
 * char to StringBuilder
 * Finally return the result by converting it to string
 * 
 * Approach
 * Initialize the StringBuilder
 * Traverse the chars of string, if the char is "*" then delete last char of
 * StringBuilder else add the char to the StringBuilder
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

// StringBuilder Code
class Solution {
    public String removeStars(String s) {

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*')
                sb.deleteCharAt(sb.length() - 1);
            else
                sb.append(c);
        }
        return sb.toString();
    }
}

// Stack Code
class Solution {
    public String removeStars(String s) {

        Stack<Character> st = new Stack();
        for (char c : s.toCharArray()) {
            if (c == '*')
                st.pop();
            else
                st.push(c);
        }
        if (st.isEmpty())
            return "";

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}