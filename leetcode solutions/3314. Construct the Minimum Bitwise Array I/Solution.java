// 3314. Construct the Minimum Bitwise Array I
// 3315. Construct the Minimum Bitwise Array II

/**
 * Intuition
 * x = 1010111
 * x+1 = 1011000
 * nums[i] = 1011111
 * if we flip first rightmost 0 of x, we get nums[i]
 * that we have only done in code
 * if we flip first righmost 0 of x, and also flip 1 before them we x+1
 * x = 1010111 or x = 1011101, it will give same result, even after shifting 0
 * to get min ans we need to keep 0 at most significant place
 * Approach
 * 
 * Complexity
 * Time complexity: O(n), traversing through nos and doing bitwise operations on
 * them in O(1) time
 * Space complexity: O(1)
 */

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int num = nums.get(i);

            if (num == 2) {
                res[i] = -1;
                continue;
            }

            boolean found = false;

            for (int j = 1; j < 32; j++) {
                // if jth bit is set skip
                if ((num & (1 << j)) != 0) {
                    continue;
                }

                // found an unset bit at position j
                // flip j-1th bit
                res[i] = num ^ (1 << (j - 1));
                found = true;
                break;
            }

            if (!found)
                res[i] = -1;
        }

        return res;
    }
}