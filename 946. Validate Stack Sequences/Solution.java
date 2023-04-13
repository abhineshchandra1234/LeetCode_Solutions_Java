/**
 * 946. Validate Stack Sequences
 * 
 * Intuition
 * We will solve this using stack
 * We will use a ptr to traverse popped
 * We will traverse pushed and push each no to stack. We will add a cond to pop
 * the stack till peek and ptr are same.
 * Finally return true if stack is empty.
 * 
 * Approach
 * Initialize an empty stack
 * Intialize ptr at start index of popped
 * Traverse pushed, add no to stack. Add a cond to pop stack till peek and ptr
 * are same.
 * Update ptr
 * Finally return true if stack is empty.
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> s = new Stack();
        int ptr = 0;
        for (int no : pushed) {
            s.push(no);
            while (!s.isEmpty() && s.peek() == popped[ptr]) {
                s.pop();
                ptr++;
            }
        }
        return s.isEmpty();
    }
}