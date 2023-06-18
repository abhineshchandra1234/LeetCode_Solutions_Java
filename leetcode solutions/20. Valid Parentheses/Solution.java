/**
 * 
 * 20. Valid Parentheses
 * 
 * Intuition
 * We will use stack to solve this problem
 * We will traverse through the string, if char is open bracket push it to the
 * stack, if char is close bracket and top of the stack is his respective open
 * bracket, pop the open bracket from the stack
 * At last return true if stack is empty
 * 
 * Approach
 * We will initialize the stack
 * We will traverse through string, if the char belongs to open bracket push it
 * to stack
 * If the charcter is close bracket and the stack is empty or top of the stack
 * doesnt contain respective open bracket, return false, else pop the stack,
 * this means we have finished computation for one of the bracket pair.
 * At last return true if stack is empty.
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

class Solution {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[')
                st.push(c);
            else {
                if (st.isEmpty() || (st.peek() == '(' && c != ')') || (st.peek() == '{' && c != '}')
                        || (st.peek() == '[' && c != ']'))
                    return false;
                st.pop();
            }
        }
        return st.isEmpty();
    }
}