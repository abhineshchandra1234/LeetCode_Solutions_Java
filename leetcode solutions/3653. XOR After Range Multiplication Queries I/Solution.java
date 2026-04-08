// 3653. XOR After Range Multiplication Queries I

/**
 * Intuition
 * we will solve this problem through simulation
 * we will traverse query
 * then we will traverse nums from l to r, multiply each no with value, the gap
 * between each no will be k
 * At last we will take xor of all nums and return the res
 * Approach
 * 
 * Complexity
 * Time complexity: O(n*q)
 * Space complexity: O(1)
 */

class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int M = (int) (1e9 + 7);
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int k = query[2];
            int v = query[3];

            while (l <= r) {
                nums[l] = (int) ((1L * nums[l] * v) % M);
                l += k;
            }
        }

        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}