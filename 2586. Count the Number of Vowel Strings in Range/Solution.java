/**
 * 2586. Count the Number of Vowel Strings in Range
 * 
 * approach-
 * we will traverse words in between left and right ptrs
 * and check if its first & last char is vowel.
 * If it is we will increase the count variable.
 * 
 * Time - O(n)
 * Space - O(1)
 */
class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        
        int count =0;
        for(int i=left;i<=right;i++) {
            char[] a = words[i].toCharArray();
            int n = a.length-1;
            if((a[0]=='a'||a[0]=='e'||a[0]=='i'||a[0]=='o'||a[0]=='u') && 
              (a[n]=='a'||a[n]=='e'||a[n]=='i'||a[n]=='o'||a[n]=='u')) {
                count++;
            }
        }
        return count;
    }
}