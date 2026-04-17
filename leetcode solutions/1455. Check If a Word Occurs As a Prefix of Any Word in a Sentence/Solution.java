/**
 * 1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence
 * 
 * Intuition
 * we can solve this problem by splitting the string into an array
 * then comparing array strings with searchWord using substring and return the
 * ans
 * also add a check if sentence length is greater or equal to search word
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {

    public int isPrefixOfWord(String sentence, String searchWord) {

        String[] arr = sentence.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() >= searchWord.length() && arr[i].substring(0, searchWord.length()).equals(searchWord))
                return i + 1;
        }

        return -1;
    }
}