/**
 * 316. Remove Duplicate Letters
 * 
 * Intuition
 * 
 * credits hi-malik
 * we will solve this problem using stack, chars with least value will be at the
 * bottom and chars will high value will be at the top of the stack
 * we will also use a boolean array seen to avoid repetation of chars
 * 
 * Approach
 * 
 * we will traverse whole string and add chars to stack one by one
 * we will mark char as seen once it is added to the stack
 * while adding curr char to stack if the peek char has higher value we will pop
 * it and mark it as not seen.
 * Finally we will be left with res in reverse in the stack
 * we will use integer value of char to store it in stack as we are using
 * boolean seen array which is using index to mark char as seen.
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public String removeDuplicateLetters(String s) {

        // track the lastIndex of char
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++)
            lastIndex[s.charAt(i) - 'a'] = i;

        // seen chars
        boolean[] seen = new boolean[26];

        Stack<Integer> st = new Stack();

        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            // ignore seen char as we need to pick one char only
            if (seen[curr])
                continue;
            // pop the char in stack if it is greater and has more occurance
            while (!st.isEmpty() && st.peek() > curr && i < lastIndex[st.peek()])
                seen[st.pop()] = false;
            // add curr to stack and mark as seen
            st.push(curr);
            seen[curr] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty())
            sb.append((char) (st.pop() + 'a'));
        return sb.reverse().toString();
    }
}