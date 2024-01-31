/**
 * 739. Daily Temperatures
 * 
 * Intuition
 * 
 * A monotonic stack is a stack whose elements are monotonically increasing or
 * decreasing.
 * Generally we add idx of no instead of no
 * we will traverse no from back
 * Till the stack is not empty and peek no is less or equal to curr no pop it
 * No we have stack peek greater than curr no, we will update res for curr index
 * res[i] = s.peek() - i;
 * Finally add current index to stack
 * At last return the res
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
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack();

        for (int i = n - 1; i >= 0; i--) {

            while (!s.isEmpty() && temperatures[s.peek()] <= temperatures[i])
                s.pop();

            if (!s.isEmpty())
                res[i] = s.peek() - i;

            s.push(i);
        }
        return res;
    }
}