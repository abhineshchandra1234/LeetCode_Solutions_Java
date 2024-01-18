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
        if (n == 2)
            return 2;

        int one_step_before = 2;
        int two_steps_before = 1;
        int all_ways = 0;

        for (int i = 3; i <= n; i++) {
            all_ways = one_step_before + two_steps_before;
            two_steps_before = one_step_before;
            one_step_before = all_ways;
        }

        return all_ways;
    }
}