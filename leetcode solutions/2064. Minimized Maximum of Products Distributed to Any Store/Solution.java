/**
 * 2064. Minimized Maximum of Products Distributed to Any Store
 * 
 * Intuition
we can solve this problem through binary search
our answer will lie between 1 and max of quantities
values that satisfies each shop, will be our answers
we will check for each value whether we are able to give all shops some products, with 0 shops remaining
we will take minimum of this value as our ans
Approach


Complexity
Time complexity: O(nlogn)
Space complexity: O(1)
 */

 class Solution {

    public int minimizedMaximum(int n, int[] quantities) {

        int m = quantities.length;

        int l = 1;
        int r = Integer.MIN_VALUE;
        for (int a : quantities)
            r = Math.max(r, a);

        int res = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (helper(mid, quantities, n)) {
                res = mid;
                r = mid - 1;
            } else
                l = mid + 1;
        }

        return res;
    }

    boolean helper(int x, int[] quantities, int n) {

        for (int product : quantities) {

            n -= (int) Math.ceil((double) product / x);

            if (n < 0)
                return false;
        }

        return true;
    }
}