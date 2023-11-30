/**
 * 1611. Minimum One Bit Operations to Make Integers Zero
 * 
 * Intuition
 * 
 * we are taking index from right-left
 * In order to convert ith bit i+1th bit needs to be converted
 * In this way we need to find effort for most significant bit first.
 * Effort required to convert most significant bit is Math.pow(2, k + 1) - 1
 * we can get the remaining no by xor operation Math.pow(2, k) ^ n
 * the above effort is to convert 100000 to 00000. Suppose we have 100100, here
 * 00100 is already conveted a little bit, so we need to subtract it.
 * more details like- suppose 00000 takes 10 effort and 00000 takes 4 efforts to
 * reach 00100. so total effort 10-4 = 6
 * 
 * Approach
 * Complexity
 * 
 * Time complexity:
 * 
 * O(logn), finding most-significant bit index
 * 
 * Space complexity:
 * 
 * O(logn), recursive call stack
 * 
 */
class Solution {
    public int minimumOneBitOperations(int n) {

        if (n == 0)
            return 0;

        // find most-significant bit index
        int k = 0;
        while (Math.pow(2, k) <= n)
            k += 1;
        k -= 1;

        // subtract already computed values from res
        return (int) Math.pow(2, k + 1) - 1 - minimumOneBitOperations((int) Math.pow(2, k) ^ n);
    }
}