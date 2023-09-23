/**
 * 1048. Longest String Chain
 * 
 * Intuition
 * 
 * credits lee215
 * We will solve this problem using dp
 * First sort the array
 * For every word delete one char one by one and see if it previously exist, if
 * it does increase chain count.
 * The logic is for every word dp contains count like how many words exist with
 * the same order.
 * Unique word will have count of 1
 * 
 * Approach
 * 
 * Input: words = ["a","b","ba","bca","bda","bdca"]
 * Output: 4
 * a -> prev -> "" -> best -> 1
 * b -> prev -> "" -> best -> 1
 * ba -> prev -> "a", "b" -> best -> 2
 * bca -> prev -> "ba" -> best -> 3
 * bda -> prev -> "ba" -> best -> 3
 * bdca -> prev -> "bca", "bda" -> best -> 4
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(n*s*s) -> n -> for loop , s -> inner loop for word, s -> string
 * concatenation
 * 
 * Space complexity:
 * 
 * O(n*s) -> we are concatenating string of s length n times
 * 
 */
class Solution {
    public int longestStrChain(String[] words) {

        Map<String, Integer> dp = new HashMap();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int res = 0;
        for (String word : words) {
            int best = 0;
            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best, dp.getOrDefault(prev, 0) + 1);
            }
            dp.put(word, best);
            res = Math.max(res, best);
        }
        return res;
    }
}