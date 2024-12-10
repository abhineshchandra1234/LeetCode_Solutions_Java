/**
 * 2981. Find Longest Special Substring That Occurs Thrice I
 * 
 * Intuition
 * In brute force we will generate special substring
 * and store substring with its freq in map, which will res in O(n^3) tc
 * In further optimized approach, we will store chars and its freq in map, which
 * will res in O(n^2) tc
 * In most optimized approach, we will store chars, freq of different length in
 * 2d grid
 * Then we will find cumalative sum from back ie highest length
 * if cumalative sum is greater than equal to 3, update res with the index
 * a - 2
 * aa - 2
 * ...
 * we are counting from back
 * when we reach a, cumalative sum is 4 which is greater than 3, return index 1
 * as ans
 * a comes 2 times in a
 * a comes 2 times in aa
 * Approach
 * 
 * Complexity
 * Time complexity: O(n), O(26*n)
 * Space complexity: O(n)
 */
class Solution {

    public int maximumLength(String s) {

        int n = s.length();
        int[][] grid = new int[26][n + 1];

        char prev = s.charAt(0);
        int length = 0;

        // update freq in grid
        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            if (curr == prev) {
                length += 1;
                grid[curr - 'a'][length] += 1;
            } else {
                length = 1;
                grid[curr - 'a'][length] += 1;
                prev = curr;
            }
        }

        // find highest cumulative sum
        int res = 0;
        for (int i = 0; i < 26; i++) {
            int csum = 0;
            for (int j = n; j >= 1; j--) {
                csum += grid[i][j];
                if (csum >= 3) {
                    res = Math.max(res, j);
                    break;
                }
            }
        }

        return res == 0 ? -1 : res;
    }
}