/**
 * 2483. Minimum Penalty for a Shop
 * 
 * Intuition
 * 
 * penalty at every hr will be the sum of prefix_n and postfix_y
 * For every hour when the shop is open and no customers come, the penalty
 * increases by 1.
 * like for jth hr as 2, and N in 0,1 & 2 indices. we will get penalty as 2 for
 * 0,1. we will not get any penaly for 2 as shop was close at that time
 * For every hour when the shop is closed and customers come, the penalty
 * increases by 1.
 * like for the jth hr as 2, and Y in 2,3 & 4 indices. We will get 3 penalty for
 * 2, 3 & 4. We get penalty for 2 as shop was closed at that time still customer
 * arrived.
 * First calculate prefix_n and postfix_y
 * then calculate penalty from it.
 * Update min_penalty with penalty and update idx.
 * Finally return idx.
 * 
 * Approach
 * 
 * Input: customers = "YYNY"
 * Output: 2
 * prefix_n = [0, 0, 0, 1, 1]
 * postfix_y = [3,2,1,1,0]
 * penalty = [3,2,1,2,1]
 * idx = 2
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public int bestClosingTime(String customers) {

        int n = customers.length();
        int[] prefix_n = new int[n + 1];
        int[] postfix_y = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            prefix_n[i] = prefix_n[i - 1];
            if (customers.charAt(i - 1) == 'N')
                prefix_n[i] += 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            postfix_y[i] = postfix_y[i + 1];
            if (customers.charAt(i) == 'Y')
                postfix_y[i] += 1;
        }

        int min_penalty = Integer.MAX_VALUE, idx = -1, penalty = 0;

        for (int i = 0; i < n + 1; i++) {
            penalty = prefix_n[i] + postfix_y[i];
            if (penalty < min_penalty) {
                min_penalty = penalty;
                idx = i;
            }
        }

        return idx;
    }
}