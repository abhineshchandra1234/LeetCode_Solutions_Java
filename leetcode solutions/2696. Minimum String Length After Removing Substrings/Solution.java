/**
 * 2696. Minimum String Length After Removing Substrings
 * 
 * Intuition
 * we can solve this problem through stack
 * Iterate through the chars, if the curr char is 'B' and top char is 'A', pop
 * the stack
 * If the curr char is 'D' and top char is 'C', pop the stack
 * return the stack length at the end
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {

    public int minLength(String s) {

        Stack<Character> st = new Stack();

        for (char c : s.toCharArray()) {
            if (st.isEmpty()) {
                st.push(c);
                continue;
            }
            if (c == 'B' && st.peek() == 'A') {
                st.pop();
            } else if (c == 'D' && st.peek() == 'C') {
                st.pop();
            } else {
                st.push(c);
            }
        }
        return st.size();
    }
}