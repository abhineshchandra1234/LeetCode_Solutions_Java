/*
1518. Water Bottles

Intuition

    It is given numBottles bottles full of water
    given numExchange bottles can be replaced with 1 full bottle from the market
    to empty the bottle it need to be dranked
    return the maximum no of bottle that can be dranked, including exchanges
    we need to simulate the process until there are not enough empty bottles for even 1 full bottle exchange
    we can have some remaining bottles that cannot be exchanged less than min count required
    so we will simulate each step
    we will add consumed bottle to res
    we will remove consumed bottle from total
    we will add exchanged bottle to total
    At last we will return consumed bottle plus remaining of total
    we need to do this till total is greater or equal to exchange which is a mandatory condition for exchange

Approach
Complexity

    Time complexity: O(logn base m), we are diving n full bottles with exchange m each time

    Space complexity: O(1)

*/
class Solution {

    fun numWaterBottles(numBottles: Int, numExchange: Int): Int {
        var res = 0
        var n = numBottles
        while (n >= numExchange) {
            var exchange = n / numExchange
            var consumed = exchange * numExchange
            res += consumed
            n -= consumed
            n += exchange
        }
        return res + n
    }
}
