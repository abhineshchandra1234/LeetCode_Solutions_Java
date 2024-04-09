/**
 * 2073. Time Needed to Buy Tickets
 * 
 * Intuition
 * Approach 1 (simulation)
 * 
 * we can do simulation using queue, here we are doing it in-place using the
 * tickets array
 * we are using a universal true loop to continue the compuatation till the res
 * is found
 * we will traverse ticket, and instead of checking its value greater than 0, we
 * will continue or skip it, if its value is 0
 * we will decrease ticket value and increase step count by 1 after every
 * traversal
 * if the index is k and its value is 0, return the step count.
 * 
 * Approach 2 (one pass)
 * 
 * we will traverse tickets and each ticket will contribute following steps
 * if i<=k -> Math.min(tickets[k], tickets[i])
 * if i>k -> Math.min(tickets[k] - 1, tickets[i])
 * we have taken min of steps as greater ticket is still left while k index
 * tickets are finished
 * 
 * Input: tickets = [2,3,2], k = 2
 * Output: 6
 * here every people will contribute Math.min(tickets[k], tickets[i]) steps as
 * thier index<=k
 * Input: tickets = [5,1,1,1], k = 0
 * Output: 8
 * After 1 ticket array becomes
 * [1, 1, 1, 4] and we can apply Math.min(tickets[k], tickets[i]) formula as all
 * index are <=k but here tickets[k] has changed to tickets[k] - 1
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */

// Code 1
class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {

        int step = 0;

        while (true) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] == 0)
                    continue;
                tickets[i]--;
                step++;
                if (i == k && tickets[i] == 0)
                    return step;
            }
        }
    }
}

// Code 2
class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {

        int res = 0;
        for (int i = 0; i < tickets.length; i++)
            res += i <= k ? Math.min(tickets[k], tickets[i]) : Math.min(tickets[k] - 1, tickets[i]);
        return res;
    }
}