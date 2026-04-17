// 868. Binary Gap

/**
 * Intuition
 * we will have two pointers cur and prev
 * if the righmost bit is 1, we will find difference between cur and prev and
 * update res and prev
 * otherwise we would just increase curr and right shift n, till it reaches 0
 * Approach
 * 
 * Complexity
 * Time complexity: O(1)
 * Space complexity: O(1)
 */

class Solution {
    public int binaryGap(int n) {
        int cur = 0;
        int prev = -1;

        int res = 0;

        while (n > 0) {
            if ((n & 1) > 0) {
                res = prev != -1 ? Math.max(res, cur - prev) : res;
                prev = cur;
            }
            cur++;
            n >>= 1;
        }

        return res;
    }
}