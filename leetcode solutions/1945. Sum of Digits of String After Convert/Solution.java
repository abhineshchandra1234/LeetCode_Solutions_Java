/**
 * 1945. Sum of Digits of String After Convert
 * 
 * Intuition
 * we are given a string s and an integer k
 * we need to return an integer after above operations
 * 
 * Approach
 * using brute force we can use stringbuilder to solve this problem, by
 * traversing each chars k times
 * 
 * but time and space complexity will be O(n)
 * 
 * we can further optimize it, instead of each digit, we can directly add value
 * of the no for each digit in res
 * 
 * After that we need to do the same operation k-1 times to get the final res
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {

    public int getLucky(String s, int k) {

        int curr = 0;
        for (char c : s.toCharArray()) {

            int v = c - 'a' + 1;
            while (v > 0) {
                curr += v % 10;
                v /= 10;
            }
        }

        for (int i = 0; i < k - 1; i++) {
            int temp = 0;
            while (curr > 0) {
                temp += curr % 10;
                curr /= 10;
            }
            curr = temp;
        }

        return curr;
    }
}