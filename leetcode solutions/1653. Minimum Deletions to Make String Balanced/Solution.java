/**
 * 1653. Minimum Deletions to Make String Balanced
 * 
 * Intuition
 * we are given string s, we need to return minimum no of deletion to make s
 * balanced
 * 
 * Approach
 * we can easily solve this problem through stack, through simulation
 * the deletion count will increase if top is b and curr is a, b will be popped
 * time and space will be O(n)
 * the next approach is using dynamic programming
 * we can delete curr a, so that prefix end with b, one valid condition
 * or we can delete entire b encountered so far, so that there is no b before a,
 * second valid condition
 * our goal is to have all b's after a's
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {

    public int minimumDeletions(String s) {

        int n = s.length();
        int b = 0;
        int d = 0;

        for (char c : s.toCharArray()) {

            if (c == 'b')
                b++;
            else
                d = Math.min(d + 1, b);
        }

        return d;
    }
}

class Solution {
    public int minimumDeletions(String s) {

        int n = s.length();
        int count = 0;
        Stack<Character> st = new Stack();

        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && c == 'a' && st.peek() == 'b') {
                st.pop();
                count++;
            } else
                st.push(c);
        }

        return count;
    }
}