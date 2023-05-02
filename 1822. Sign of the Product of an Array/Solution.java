/**
 * 1822. Sign of the Product of an Array
 * 
 * Intuition
 * At first I thought of a naive approach ie calculating the product and based
 * on it return the res.
 * Then I looked into the problem to optimise it
 * product will be 0 if there is a 0 present in the array.
 * product will be -ve if -ve nos fail to cancel each other out, for this I
 * thought of using boolean var but return type is int so used 1 & -1 instead.
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {
    public int arraySign(int[] nums) {
        int sign = 1;
        for (int n : nums) {
            if (n == 0)
                return 0;
            else if (n < 0)
                sign = -sign;
        }
        return sign;
    }
}