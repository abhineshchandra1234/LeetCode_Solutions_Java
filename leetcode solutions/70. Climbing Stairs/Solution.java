/**
 * 70. Climbing Stairs
 * 
 * Intuition
 * 
 * credit liaison
 * This problem can be easily solved through dp
 * We can reach ith step from i-1th step and i-2th step
 * i (ways) = i-1 (ways) + i-2 (ways)
 * Note - to better understand it try dry running using dp
 * to save space I am using two ptrs one_step & two_steps
 * when we move to next step
 * two_steps will point to one_step
 * all_ways or curr will point to one_step
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int climbStairs(int n) {

        if (n == 1)
            return 1;
        int one_step = 1;
        int two_step = 1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = one_step + two_step;
            one_step = two_step;
            two_step = res;
        }
        return res;
    }
}