// 122. Best Time to Buy and Sell Stock II

/*
Intuition
since we can buy and sell multiple times, we will just compare curr no with prev no and store all profits in a var
Approach

Complexity
Time complexity: O(n)
Space complexity: O(1)
*/

// kotlin
class Solution {
    fun maxProfit(prices: IntArray): Int {
        
        var profit = 0

        for(i in 1 until prices.size) {
            if(prices[i]>prices[i-1]) {
                profit += prices[i] - prices[i-1]
            }
        }

        return profit
    }
}

    // Java
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];
        }

        return profit;
    }
}