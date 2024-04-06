/**
 * 1249. Minimum Remove to Make Valid Parentheses
 * 
 * Intuition
 * 
 * we will use stack to solve this problem
 * we will traverse the string and add open bracket index to the stack
 * when we encounter close bracket we will pop the stack if it is not empty
 * we will add special char to the res array if stack is empty, we do not add
 * index of close bracket bcs we cannot distinguish it with index of open
 * bracket
 * the extra open brackets index is left in stack, we will pop it and add
 * special char in the given index in res array
 * Then finally we will return res array as string by converting all special
 * char to empty char.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public String minRemoveToMakeValid(String s) {

        int n = s.length();
        char[] sa = s.toCharArray();
        Stack<Integer> st = new Stack();

        // discard valid brackets
        // extra open bracket index will be left in the stack
        // add special char for extra close bracket
        for (int i = 0; i < n; i++) {
            char c = sa[i];
            if (c == '(')
                st.add(i);
            else if (c == ')') {
                if (!st.isEmpty())
                    st.pop();
                else
                    sa[i] = ' ';
            }
        }

        // add special char for extra open bracket
        while (!st.isEmpty())
            sa[st.pop()] = ' ';

        return new String(sa).replaceAll(" ", "");
    }
}