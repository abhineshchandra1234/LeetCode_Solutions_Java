/**
 * 205. Isomorphic Strings
 * 
 * Intuition
 * 
 * As evident in the question we need to map chars of both strings
 * if we map it directly it will involve alot of computation
 * Instead we can asign unique value to each char and it will work the same
 * 
 * Approach
 * 
 * ascii size is 256, and we can use array of same size to minimize computation
 * 
 * Input: s = "egg", t = "add"
 * Output: true
 * unique value -> index + 1
 * e -> 1, a -> 1
 * g -> 2, d -> 2
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {

        int[] ms = new int[256];
        int[] mt = new int[256];

        for (int i = 0; i < s.length(); i++) {
            if (ms[s.charAt(i)] != mt[t.charAt(i)])
                return false;
            ms[s.charAt(i)] = i + 1;
            mt[t.charAt(i)] = i + 1;
        }

        return true;
    }
}