/**
 * 402. Remove K Digits
 * 
 * Intuition
 * 
 * From the question it is evident that we need to remove peeks from the
 * significant places to return a smaller no
 * we can do this by running a loop n no of times for each peak and remove it
 * which will take alot of time and processing
 * we can use monotonic stack, discard k peaks and store rest of the nos in
 * stack and use this stack to return the result.
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
    public String removeKdigits(String num, int k) {

        int n = num.length();
        // all chars will be removed
        if (n == k)
            return "0";
        Stack<Character> s = new Stack();
        s.add(num.charAt(0));

        // remove peaks
        for (int i = 1; i < n; i++) {
            char c = num.charAt(i);
            while (!s.isEmpty() && k > 0 && s.peek() > c) {
                k--;
                s.pop();
            }
            s.push(c);

            // removing prefix 0s
            if (s.size() == 1 && c == '0')
                s.pop();
        }

        // remove remaining chars
        while (k > 0 && !s.isEmpty()) {
            k--;
            s.pop();
        }

        // no res to build
        if (s.isEmpty())
            return "0";

        // building res
        StringBuilder st = new StringBuilder();
        while (!s.isEmpty())
            st.append(s.pop());

        return st.reverse().toString();
    }
}