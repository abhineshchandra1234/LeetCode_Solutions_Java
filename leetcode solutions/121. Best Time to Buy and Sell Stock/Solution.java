// 121. Best Time to Buy and Sell Stock
/*
Intuition
we will try to reduce buy price
so we will compare buy price with curr no, if buy price is more, we will use curr as buy price
profit we will be calculated for all curr, by taking max of profit and curr - buy price
Approach

Complexity
Time complexity: O(n)
Space complexity: O(1)
*/

//kotlin
class Solution {
    fun maxProfit(prices: IntArray): Int {
        
        var buyPrice = prices[0]
        var profit = 0

        for(i in 1 until prices.size) {
            if(buyPrice>prices[i]) {
                buyPrice = prices[i]
            }
            profit = maxOf(profit, prices[i]-buyPrice)
        }

        return profit
    }
}

    // java
class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int res = 0;

        for (int i = 1; i < prices.length; i++) {
            if (buy > prices[i])
                buy = prices[i];
            res = Math.max(res, prices[i] - buy);
        }

        return res;
    }
}