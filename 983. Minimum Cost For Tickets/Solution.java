/**
 * 983. Minimum Cost For Tickets
 * 
 * Intuition
 * we will solve this problem using dp
 * Any ith day of dp will represent min travel cost till that ith day
 * for non-travel days cost will remain the same
 * for travel days we have to buy a mandatory 1-day ticket or use pass bought 7
 * days ago or use pass bought 30 days ago
 * We will take min of the above three choices as we need to minimize travel
 * cost
 * for other days too.
 * eg - days = [1,2,3,4,5,6,7,8] , costs = [2,7,15]
 * for lastDay 8 if we buy tickets daily total cost will be 16
 * if we buy a ticket on day 1 and pass for 7 days on day 2, the total cost will
 * be
 * 9
 * This 7 days pass will cover day 8 as well as 6 more days 2,3,4,5,6 huge
 * advantage with 16-9 = 7 savings.
 * 
 * Approach
 * we will traverse through each day till the last day
 * if the day is a non-travel day it will carry the value of its predecessor.
 * if the day is travel day we will mandatorily buy a 1-day ticket and add it to
 * total cost.
 * then we will see if the 1-day ticket is cheaper than 7 days pass bought 7
 * days ago
 * or 30-day pass bought 30 days ago and update total cost for ith day
 * accordingly.
 * Finally we will return the lastDay value.
 * We will use the boolean array isTravelDays to keep track of travel days
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

class Solution {
    public int mincostTickets(int[] days, int[] costs) {

        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];
        boolean[] isTravelDays = new boolean[lastDay + 1];

        for (int day : days)
            isTravelDays[day] = true;

        for (int i = 1; i <= lastDay; i++) {
            if (!isTravelDays[i]) {
                dp[i] = dp[i - 1];
                continue;
            }
            // we have to buy tickets to travel
            dp[i] = costs[0] + dp[i - 1];
            // min of pass bought 7 days ago or today's ticket
            dp[i] = Math.min(costs[1] + dp[Math.max(i - 7, 0)], dp[i]);
            // min of pass bought 30 days ago or today's ticket
            dp[i] = Math.min(costs[2] + dp[Math.max(i - 30, 0)], dp[i]);
        }

        return dp[lastDay];
    }
}
