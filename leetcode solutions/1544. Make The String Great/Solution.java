/**
 * 1544. Make The String Great
 * 
 * Intuition
 * 
 * It is evident in the question we can solve this problem through stack, by
 * poping the lowercase char when uppercase char is seen or vice-versa
 * But how to check if the top of stack is lowercase char or vice-versa of curr
 * char
 * Ascii value difference between uppercase and lowercase char is 32. ie a -> 97
 * & A -> 65 -> |97 - 65| -> 32
 * we will take abs diff of curr char and stack top if it is 32 we will pop the
 * top.
 * Math.abs(sGood.peek() - c) == 32, it will handle both scenarios curr char is
 * lowercase and stack top is uppercase or vice-versa
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
    public String makeGood(String s) {

        Stack<Character> sGood = new Stack();

        for (char c : s.toCharArray()) {
            if (!sGood.isEmpty() && Math.abs(sGood.peek() - c) == 32)
                sGood.pop();
            else
                sGood.push(c);
        }

        StringBuilder st = new StringBuilder();
        while (!sGood.isEmpty()) {
            st.append(sGood.pop());
        }

        return st.reverse().toString();
    }
}