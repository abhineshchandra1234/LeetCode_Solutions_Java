/**
 * 150. Evaluate Reverse Polish Notation
 * 
 * Intuition
 * 
 * As evident in the question we will solve this problem with the stack
 * If the string is no we will push it in the stack, if it is a operator we will
 * pop top two elements, perform operation and again push the result to stack
 * 
 * Approach
 * 
 * Be careful of order in case of divison and subtraction as order is important
 * we can use two vars to store popped nos
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public int evalRPN(String[] tokens) {

        int a, b;
        Stack<Integer> S = new Stack();
        for (String s : tokens) {
            if (s.equals("+"))
                S.add(S.pop() + S.pop());
            else if (s.equals("/")) {
                b = S.pop();
                a = S.pop();
                S.add(a / b);
            } else if (s.equals("*"))
                S.add(S.pop() * S.pop());
            else if (s.equals("-")) {
                b = S.pop();
                a = S.pop();
                S.add(a - b);
            } else
                S.add(Integer.valueOf(s));
        }
        return S.pop();
    }
}