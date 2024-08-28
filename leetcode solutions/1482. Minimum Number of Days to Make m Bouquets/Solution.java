/***
 * 1482. Minimum Number of Days to Make m Bouquets
 * 
 * Intuition
 * 
 * we have been given an array of flowers bloom dates
 * we have also been given integer m and k
 * we need to return min days required to make m bouqets using k adjacent
 * bloomed flowers
 * If it is not possible return -1.
 * So how to get min days
 * 
 * Approach
 * 
 * First we will check if we have enough flowers to form bouqets
 * We will apply binary search on max bloom days
 * For each day we will check if we can get suitable bouqets using a helper
 * function
 * If we get a suitable res, we will try to find more optimized one by trying
 * min days
 * since we need to find min days, used binary algo to find min res
 * 
 * Complexity
 * 
 * Time complexity: O(nlogn)
 * 
 * Space complexity: O(1)
 * 
 */

class Solution {
    public int minDays(int[] bloom, int m, int k) {

        if (bloom.length < (long) m * k)
            return -1;

        int l = 1, h = (int) 1e9;

        while (l < h) {
            int mid = l + (h - l) / 2;
            if (helper(bloom, m, k, mid))
                h = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    private boolean helper(int[] bloom, int m, int k, int d) {

        int res = 0;
        for (int i = 0; i < bloom.length; i++) {

            int count = 0;

            while (i < bloom.length && count < k && bloom[i] <= d) {
                count++;
                i++;
            }

            // check curr idx for further computation
            if (count == k) {
                res += 1;
                i--;
            }

            if (res >= m)
                return true;

        }
        return false;
    }
}