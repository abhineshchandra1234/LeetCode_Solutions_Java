/**
 * 344. Reverse String
 * 
 * Intuition
 * 
 * we will solve this problem using two-ptrs
 * one ptr will point to start and other ptr will point to end of array
 * we will use temp to swap chars of both ptrs
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
    public void reverseString(char[] s) {

        int start = 0, end = s.length - 1;

        while (start <= end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}