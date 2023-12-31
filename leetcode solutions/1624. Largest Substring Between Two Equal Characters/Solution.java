/**
 * 1624. Largest Substring Between Two Equal Characters
 * 
 * Intuition
 * 
 * we will solve it using first index
 * We will store first idx of each char, if we encounter the same char again we
 * will update res with largest substring length
 * here we store idx using map, we can also use array
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1), map length can be max 26
 * 
 */
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {

        Map<Character, Integer> firstIdx = new HashMap();
        int ans = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (firstIdx.containsKey(c))
                ans = Math.max(ans, i - firstIdx.get(c) - 1);
            else
                firstIdx.put(c, i);
        }

        return ans;
    }
}