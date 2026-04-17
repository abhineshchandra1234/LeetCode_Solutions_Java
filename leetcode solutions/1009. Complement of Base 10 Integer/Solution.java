// 1009. Complement of Base 10 Integer

/**
 * Intuition
 * In order to convert no to bits
 * we need to take remainder of no with 2, that will return 1st least
 * significant bit
 * Now to convert bit back to no, we need to multiply 2 power with reversed bit
 * and add it to res
 * lastly divide the no by 2
 * Approach
 * 
 * Complexity
 * Time complexity: O(logn)
 * Space complexity: O(1)
 */

class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0)
            return 1;

        int res = 0;
        int cnt = 0;
        while (n != 0) {
            int rem = n % 2;
            res += (int) (Math.pow(2, cnt) * (rem == 0 ? 1 : 0));
            cnt++;
            n = n >> 1;
        }
        return res;
    }
}