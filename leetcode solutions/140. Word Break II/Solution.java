/**
 * 140. Word Break II
 * 
 * Intuition
 * 
 * Since there are mutiple solutions involved which can be solved idependently,
 * so we are choosing backtracking
 * we will have two ptrs, start will point to start of the substring and will be
 * used to traverse whole string, end will point to the end of substring
 * we will traverse each index, if the substring between start and end is part
 * of dict, we got our base solution and will try its extensions
 * when we reach the last index or end of string, add local res or curr string
 * to the global res
 * 
 * Approach
 * 
 * After exploration we will unchoose each base word or solution for further
 * computation using local res, we need to clear local res
 * 
 * Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * Output: ["cats and dog","cat sand dog"]
 * we will get "cat sand dog", from base word "cat" and its extensions in local
 * res
 * we need to clear local res for further computation
 * we will next pick base word "cats" and its extensions from which we will get
 * "cats and dog"
 * 
 * Complexity
 * 
 * Time complexity: O(2^n), we are generating 2^n subsets of word for each
 * possible or valid sentence
 * 
 * Space complexity: O(2^n), each base word can generate 2^n subsets of valid
 * words
 * 
 */
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {

        Set<String> wordSet = new HashSet(wordDict);
        List<String> res = new ArrayList();
        helper(s, wordSet, new StringBuilder(), res, 0);
        return res;
    }

    private void helper(String s, Set<String> wordSet, StringBuilder currString,
            List<String> res, int start) {
        int n = s.length();
        if (start == n)
            res.add(currString.toString().trim());

        for (int end = start + 1; end <= n; end++) {
            String word = s.substring(start, end);
            if (wordSet.contains(word)) {
                int currLength = currString.length();
                // choose
                currString.append(word + " ");
                // explore
                helper(s, wordSet, currString, res, end);
                // unchoose
                currString.setLength(currLength);
            }
        }
    }
}