// 3713. Longest Balanced Substring I

/**
 * Intuition
 * we will have two loops to generate all subarrays
 * we will have freq map, to store freq of all chars in curr subarrays
 * for each subarray or curr, check if it is balanced
 * if it is balanced, update maxL count
 * Approach
 * 
 * Complexity
 * Time complexity: O(n^2), trying all subarrays
 * Space complexity: O(1)
 */

class Solution {
    public int longestBalanced(String s) {

        int n = s.length();
        int maxL = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;

                if (checkBal(freq))
                    maxL = Math.max(maxL, j - i + 1);
            }
        }

        return maxL;
    }

    private boolean checkBal(int[] freq) {
        int common = 0;
        for (int f : freq) {
            if (f == 0)
                continue;

            if (common == 0)
                common = f;
            else if (f != common)
                return false;
        }
        return true;
    }
}