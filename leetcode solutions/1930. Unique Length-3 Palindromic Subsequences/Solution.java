/**
 * 1930. Unique Length-3 Palindromic Subsequences
 * 
 * Intuition
 * 
 * credits votrubac
 * ans is not complicated
 * res will sum of palindromes that each unique chars in the string makes
 * calculate palindrome for each char
 * We will calculate first and last index of the char
 * we will then calculate unique chars between first and last index and that
 * will be no of plaindromes
 * 
 * Approach
 * 
 * Input: s = "bbcbaba"
 * Output: 4
 * a -> first -> 4, last -> 6, unique -> b -> aba
 * b -> first -> 0, last -> 5, unique -> a,b,c -> bab, bbb, bcb
 * c -> first -> 2, last -> NA
 * res = a + b + c -> 1 + 3 + 0 -> 4
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(n), we traverse string once to calculate first & last index
 * 
 * Space complexity:
 * 
 * O(1), we used fixed space of size 26
 * 
 */
class Solution {
    public int countPalindromicSubsequence(String s) {

        int first[] = new int[26], last[] = new int[26], res = 0;
        Arrays.fill(first, Integer.MAX_VALUE);

        for (int i = 0; i < s.length(); i++) {
            // first index
            first[s.charAt(i) - 'a'] = Math.min(first[s.charAt(i) - 'a'], i);
            // last index
            last[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < 26; i++) {
            // unique chars count
            if (first[i] < last[i])
                res += s.substring(first[i] + 1, last[i]).chars().distinct().count();
        }

        return res;
    }
}