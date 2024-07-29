/**
 * 1395. Count Number of Teams
 * 
 * Intuition
 * we are given an integer array rating for n soldiers, we need to return the no
 * of teams that can be formed according to the given conditions
 * 
 * Approach
 * we will solve it through dynamic programming
 * we will treat each player as mid and count no of left smaller and right
 * larger
 * Later add their product to res, which represent ascending order
 * we will then calculate no of left larger and right smaller from remaining nos
 * after above operation and
 * add their product to res, which represent descending order
 * later return this result
 * 
 * Complexity
 * Time complexity: O(n^2), running two loops
 * Space complexity: O(1)
 */
class Solution {

    public int numTeams(int[] rating) {

        int n = rating.length;
        int res = 0;

        for (int mid = 0; mid < n; mid++) {

            int leftSmaller = 0;
            int rightLarger = 0;
            for (int left = 0; left < mid; left++) {
                if (rating[left] < rating[mid])
                    leftSmaller++;
            }
            for (int right = mid + 1; right < n; right++) {
                if (rating[right] > rating[mid])
                    rightLarger++;
            }
            res += leftSmaller * rightLarger;

            int leftLarger = mid - leftSmaller;
            int rightSmaller = n - mid - 1 - rightLarger;

            res += leftLarger * rightSmaller;
        }

        return res;
    }
}