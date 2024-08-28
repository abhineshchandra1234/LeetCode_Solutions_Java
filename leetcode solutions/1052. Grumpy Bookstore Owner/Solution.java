/**
 * 1052. Grumpy Bookstore Owner
 * 
 * Intuition
 * 
 * bookstore owner has store opened for n mins
 * we are given customers array such that, customer[i] is the no of customers
 * that enters at ith min and leave at next min
 * we are given grumpy array, where grumpy[i], represent owner is grumpy in that
 * min, 1 means grumpy 0 means not-grumpy
 * we are also given minutes, through which owner can remain non-grumpy for
 * those consecutive mins once
 * we need to return the maximum no of customers satisfied
 * This is a fixed sliding window problem
 * we will first find max window of size minutes, where total customers is max
 * we can use the max window for the extra customers
 * then we will simply add max window and rest of the customer to res
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
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int n = grumpy.length;
        int curr = 0;
        int max = 0;
        int i = 0;

        for (int j = 0; j < n; j++) {
            curr += customers[j] * grumpy[j];
            max = Math.max(curr, max);
            if (j >= minutes - 1)
                curr -= customers[i] * grumpy[i++];
        }
        // converted max window and added to res
        int res = max;
        for (i = 0; i < n; i++)
            res += customers[i] * (1 - grumpy[i]);

        return res;
    }
}