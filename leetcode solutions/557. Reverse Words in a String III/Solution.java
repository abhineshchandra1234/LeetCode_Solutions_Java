/**
 * 557. Reverse Words in a String III
 * 
 * Intuition
 * 
 * credits cheehwatang
 * We can solve this problem using 2 approaches
 * Approach 1
 * Using two ptrs
 * First convert the string to char array
 * then using two ptrs reverse chars between space
 * update right ptr after you encounter space by i-1
 * update left ptr after chars are reversed by i+1
 * where i is the index of space
 * Approach 2
 * Split the words in the string and add it to an array
 * Then sequentially reverse each word and finally join them to return the
 * string
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */

// two-pointers

class Solution {
    public String reverseWords(String s) {

        char[] chars = s.toCharArray();

        for (int start = 0, end = 0; end <= chars.length; end++) {
            if (end == chars.length || chars[end] == ' ') {
                reverse(chars, start, end - 1);
                start = end + 1;
            }
        }

        return new String(chars);
    }

    private void reverse(char[] c, int start, int end) {
        while (start < end) {
            char temp = c[end];
            c[end] = c[start];
            c[start] = temp;
            start++;
            end--;
        }
    }
}

// split & reverse

class Solution {
    public String reverseWords(String s) {

        String[] words = s.split(" ");

        for (int i = 0; i < words.length; i++) {
            words[i] = new StringBuilder(words[i]).reverse().toString();
        }

        return String.join(" ", words);
    }
}