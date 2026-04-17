// 696. Count Binary Substrings

/**
 * Intuition
 * we will solve it using 2 pointers
 * prev will store count of prev consecutive 0s or 1s, curr will store count of
 * curr consecutive 0s or 1s
 * If there is mismatch between two consecutive chars, we will update res with
 * min count of curr and prev
 * Then update prev with curr and update curr with 1 for new streak
 * Finally return res
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public int countBinarySubstrings(String s) {
        int res = 0;
        int prev = 0;
        int curr = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1))
                curr++;
            else {
                res += Math.min(curr, prev);
                prev = curr;
                curr = 1;
            }
        }

        return res + Math.min(curr, prev);
    }
}