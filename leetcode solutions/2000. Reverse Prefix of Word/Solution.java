/**
 * 2000. Reverse Prefix of Word
 * 
 * Intuition
 * 
 * we will solve this question using two-pointers
 * we will find the first index of the char using simple traversal and reverse
 * the substring before it using two-pointers approach
 * the we will append the reversed string and left string into a new string ie
 * res and return it.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public String reversePrefix(String word, char ch) {

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                word = reverseString(word.substring(0, i + 1)) + word.substring(i + 1);
                break;
            }
        }
        return word;
    }

    private String reverseString(String word) {
        char[] c = word.toCharArray();
        int left = 0, right = c.length - 1;

        while (left < right) {
            char temp = c[left];
            c[left] = c[right];
            c[right] = temp;
            left++;
            right--;
        }

        return new String(c);
    }
}