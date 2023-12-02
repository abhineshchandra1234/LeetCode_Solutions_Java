/**
 * 1160. Find Words That Can Be Formed by Characters
 * 
 * Intuition
 * 
 * credits lancertech6
 * we could have solved this problem using set, but chars are repetative
 * logic to construct word from chars, chars characters must be equal or greater
 * then words chars
 * so we solve this by comparing the freq of words and chars
 * we will first construct freq array for chars
 * then we will build freq array for each word, we compare the freq of word and
 * chars for each char.
 * If the freq of word is more for any char return false, we dont need to
 * construct complete freq array.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity:
 * 
 * O(n), O(n∗k)O(n*k)O(n∗k) length of each word is fixed and negilible
 * 
 * Space complexity:
 * 
 * O(1)
 * 
 */
class Solution {
    public int countCharacters(String[] words, String chars) {

        int[] counts = new int[26];

        // freq array for chars
        for (int i = 0; i < chars.length(); i++)
            counts[chars.charAt(i) - 'a']++;

        int res = 0;
        for (String s : words)
            if (canForm(s, counts))
                res += s.length();

        return res;
    }

    // build freq array for words and also compare
    boolean canForm(String word, int[] counts) {
        int[] wordCnt = new int[26];
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            wordCnt[i]++;
            if (wordCnt[i] > counts[i])
                return false;
        }
        return true;
    }
}