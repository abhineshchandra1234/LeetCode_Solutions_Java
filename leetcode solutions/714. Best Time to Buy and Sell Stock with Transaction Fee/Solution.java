/**
 * 714. Best Time to Buy and Sell Stock with Transaction Fee
 * 
 * Intuition
 * 
 * credits Sunchit
 * One transaction consist on buying on one day first and selling on other day
 * with a transaction fee
 * profit = selling - buying
 * so to maximize profit, selling should be maximum and buying should be
 * minimum.
 * On any day buying would min of previous buying co-efficient and curr buying
 * co-efficient ie curr price - profit. As we will not buy if curr buying
 * coeffienct is higher than the prev one.
 * On any day selling would we max of prev profit and curr profit ie curr price
 * - prev buy - fee.
 * We will not sell if curr profit is less than prev profit.
 * And buying and selling will not happen on same day. Prev buy is stored in
 * i-1.
 * we can give the transaction fee either during buying or selling.
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public int maxProfit(int[] prices, int fee) {

        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        buy[0] = prices[0];
        sell[0] = 0;
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.min(buy[i - 1], prices[i] - profit);
            sell[i] = Math.max(profit, prices[i] - buy[i - 1] - fee);
            profit = sell[i];
        }
        return profit;
    }
}