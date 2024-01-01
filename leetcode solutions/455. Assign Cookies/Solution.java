/**
 * 455. Assign Cookies
 * 
 * Intuition
 * 
 * we will solve this problem using greedy approach
 * we will first sort both the arrays then use two ptrs to traverse them
 * if the cookie is big enough for child content then we will move to next child
 * else not
 * we will move to next cookie regardless of child is satisfied or not
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(nlogn), sorting
 * 
 * Space complexity: O(logn), sorting
 * 
 */
class Solution {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            // if child is satisfied move to next
            if (s[j] >= g[i])
                i++;
            // move to next cookie regardless of child is satisfied or not.
            j++;
        }
        return i;
    }
}