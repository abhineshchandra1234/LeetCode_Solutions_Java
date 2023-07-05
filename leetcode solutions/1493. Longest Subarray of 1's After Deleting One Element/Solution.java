/**
 * 1493. Longest Subarray of 1's After Deleting One Element
 * 
 * Intuition
 * 
 * sliding window, dp, recursion, backtracking, trie sabka solution dega tera
 * faisal :P
 * credits lee215
 * From the problem we can see that it can be solved with sliding window with
 * max 1 zero.
 * 
 * Approach
 * 
 * we will have a var k that will store max no of zeros window can have
 * If right ptr of sliding window encounters any zeros it will reduce k. say
 * k=0, means no more zeros can be added in the window.
 * k<0, means we have more than 1 zero.
 * if k<0, and left ptr encounters a zero, it will try to shrink window till
 * window contains only one zero, by increasing its index.
 * Since left ptr is eliminating zeros, it will increase k, each time zero is
 * encountered to eliminate.
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int longestSubarray(int[] nums) {

        int i = 0, k = 1, res = 0;
        for (int j = 0; j < nums.length; j++) {

            if (nums[j] == 0)
                k--;

            while (k < 0) {
                if (nums[i] == 0)
                    k++;
                i++;
            }
            res = Math.max(res, j - i);
        }
        return res;
    }
}