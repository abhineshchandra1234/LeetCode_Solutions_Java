// 3838. Weighted Word Mapping

/**
 * Intuition
 * we will solve this problem through simulation
 * we will traverse words
 * for each word we will traverse chars and add its value to sum
 * then we will take modulo of sum and then convert sum to char, and append that
 * char to res
 * Finally return the res
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans = new StringBuilder(words.length);
        for (String word : words) {
            int s = 0;
            for (int i = 0; i < word.length(); i++)
                s += weights[word.charAt(i) - 'a'];
            ans.append((char) ('z' - (s % 26)));
        }
        return ans.toString();
    }
}