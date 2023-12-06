/**
 * 1716. Calculate Money in Leetcode Bank
 * 
 * Intuition
 * Approach 1 (simulate)
 * 
 * we will try to simulate the question
 * we know monday increase by 1 after every week, so will intialize mon as 1 and
 * increase its value by 1 at the start of every week
 * we will run a loop for 7 days or n days whichever is min till we have some
 * days left
 * we will add mon + day in the ans for each day. Notice each day value depends
 * on mon
 * At the end of the week, we will reduce days by 7 and inc mon value by 1.
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
    public int totalMoney(int n) {

        int ans = 0;
        int mon = 1;

        while (n > 0) {
            for (int day = 0; day < Math.min(n, 7); day++)
                ans += mon + day;
            n -= 7;
            mon++;
        }
        return ans;
    }
}