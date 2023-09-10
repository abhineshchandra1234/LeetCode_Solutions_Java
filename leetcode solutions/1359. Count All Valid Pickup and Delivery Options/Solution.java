/**
 * 1359. Count All Valid Pickup and Delivery Options
 * 
 * Intuition
 * Intution 1
 * 
 * For first choice we have n options to pick from
 * For second choice we have 2n - 1 options to pick from.
 * As second can be at any positions whever the first choice is only position it
 * cannot be is just before pickup(i).
 * So we added - 1 to remove that position
 * 
 * Input: n = 2
 * CxAxaxBxbx
 * you can see we have two existing pairs A,B and one new pair C
 * we can place c at every 2n position but not before C
 * 2n as we have Aa, Bb ..etc
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
    public int countOrders(int n) {

        long res = 1, mod = (long) 1e9 + 7;
        for (int i = 1; i <= n; i++)
            res = res * (i * 2 - 1) * i % mod;
        return (int) res;
    }
}