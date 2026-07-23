// 3513. Number of Unique XOR Triplets I

/**
 * Intuition
 * for no equal to 1 or 2, their unique xor values will be equal to n
 * for no greater than 3, we will find power to 2 greater than n
 * that value will be our ans
 * like for 4,5,6,7 -> 2^3 -> 8
 * so 8 is our answer
 * Approach
 * 
 * Complexity
 * Time complexity: O(logn)
 * Space complexity: O(1)
 */

class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        if (n == 1 || n == 2)
            return n;

        int ans = 1;
        while (ans <= n) {
            ans = ans << 1;
        }
        return ans;
    }
}