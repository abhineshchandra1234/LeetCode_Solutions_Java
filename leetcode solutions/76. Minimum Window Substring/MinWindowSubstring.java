/**
 * 76. Minimum Window Substring
 * 
 * Intuition
 * 
 * credits zjh08177
 * we will use hashmap alongwith two ptrs to solve substrings problems
 * First we will create freq map or hashmap for t chars
 * we will expand window each time by 1 step no matter what
 * If the curr char is part of t reduce left
 * if left is 0
 * we got a smaller window then we will update d and head
 * we will shrink window no matter what
 * if first char is part of t we will increase left as it is getting discarded
 * from window
 * we will increase the char freq in map, which signifies we need to cover this
 * char
 * Finally if d value is infinite we did not get a valid substring in s and
 * return empty string else return substring of s between h & h+d
 * 
 * Approach
 * 
 * Note - If conditions will always execute, it will move inside if, only when
 * the condition satisfy
 * begin is the left ptr of window
 * end is right ptr of window
 * left is the no of chars of t we need to cover
 * d is min window size
 * head is the start of min window
 * 
 * Complexity
 * 
 * Time complexity: O(n), sliding window is used to traverse s string of
 * length n
 * 
 * Space complexity: O(m), hashmap is used to store freq for string t
 * chars
 * 
 */
public class MinWindowSubstring {
    public String minWindow(String s, String t) {

        int[] map = new int[128];
        // create freq map
        for (char c : t.toCharArray())
            map[c]++;

        int left = t.length(), begin = 0, end = 0, d = Integer.MAX_VALUE, head = 0;

        // sliding window
        while (end < s.length()) {
            // expand window
            if (map[s.charAt(end++)]-- > 0)
                left--;
            // shrink window
            while (left == 0) {
                if (end - begin < d)
                    d = end - (head = begin);
                if (map[s.charAt(begin++)]++ == 0)
                    left++;
            }
        }

        return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = minWindow(s, t);
        System.out.println(result);
    }
}
