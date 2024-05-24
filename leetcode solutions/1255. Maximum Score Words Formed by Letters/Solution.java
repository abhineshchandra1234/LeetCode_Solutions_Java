/**
 * 1255. Maximum Score Words Formed by Letters
 * 
 * Intuition
 * 
 * we can solve this problem through backtracking, as there are multiple
 * solutions involved ie we need to generate a set of valid words
 * we will keep track of freq of letters using an array count
 * we will keep a local res, and a global max
 * we will traverse each word, if it is a valid word, we got our base solution
 * and will try its extension
 * res which contain base solution and extension solution scores sum is compared
 * with max to update it
 * to check if the word is valid, we will traverse its chars and reduce feq in
 * count, if any char freq is negative, that word is not valid
 * Lastly we will unchoose the base solution by increasing the freq of its chars
 * in the count array.
 * Lastly return max as res.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(2^n), generating a valid set of words
 * 
 * Space complexity: O(n), recursive stack length for each index
 * 
 */
class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {

        int[] count = new int[26];

        for (char ch : letters)
            count[ch - 'a']++;
        int res = helper(words, count, score, 0);
        return res;
    }

    private int helper(String[] words, int[] count, int[] score, int index) {
        int max = 0;

        for (int i = index; i < words.length; i++) {
            int res = 0;
            boolean isValid = true;
            for (char ch : words[i].toCharArray()) {
                int idx = ch - 'a';
                count[idx]--;
                res += score[idx];
                if (count[idx] < 0)
                    isValid = false;
            }

            if (isValid) {
                res += helper(words, count, score, i + 1);
                max = Math.max(max, res);
            }

            for (char ch : words[i].toCharArray()) {
                int idx = ch - 'a';
                count[idx]++;
            }
        }
        return max;
    }
}