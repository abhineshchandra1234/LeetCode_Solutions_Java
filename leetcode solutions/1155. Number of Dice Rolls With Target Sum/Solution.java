/**
 * 1155. Number of Dice Rolls With Target Sum
 * 
 * Intuition
 * 
 * credits cjporteo
 * we will solve this problem as it is given in the question using top-down
 * approach
 * for each dice we will reduce all the face value from the target and move to
 * next dice recursively
 * the terminating condition will be if the dice and target left are 0 then it
 * is a valid way and return 1 else return 0 for invalid way
 * Suppose we have 5 dice then we can roll 5th dice in 6 ways and pass it to the
 * 4th dice
 * eg - dp(5, 6, 18) = dp(4, 6, 17) + dp(4, 6, 16) + dp(4, 6, 15) + dp(4, 6, 14)
 * + dp(4, 6, 13) + dp(4, 6, 12)
 * Notice for 4th dice we have different versions depending on the target and it
 * can repeat so we will memoize it which will take O(n*target) combinations or
 * space.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity:
 * 
 * O(n∗k∗target)
 * 
 * Space complexity:
 * 
 * O(n∗target)
 * 
 */
class Solution {

    int mod = (int) 1e9 + 7;
    Map<String, Integer> memo = new HashMap();

    public int numRollsToTarget(int n, int k, int target) {

        if (n == 0)
            return target > 0 ? 0 : 1;

        String str = n + "+" + target;

        if (memo.containsKey(str))
            return memo.get(str);

        int res = 0;
        for (int i = 1; i <= k; i++) {
            if (target >= i)
                res = (res + numRollsToTarget(n - 1, k, target - i)) % mod;
            else
                break;
        }
        memo.put(str, res);
        return res;
    }
}