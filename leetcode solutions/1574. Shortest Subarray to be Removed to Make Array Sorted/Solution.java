/**
 * 1574. Shortest Subarray to be Removed to Make Array Sorted
 * 
 * Intuition
 * we can solve this problem through two-pointers
 * we can remove nos from prefix, postfix or middle
 * best of above 3 will be our ans
 * we have combined postfix or middle removal in our solution
 * 
 * Approach
 * to remove prefix
 * move r to start of incresing order of postfix
 * index of r will be equal to no of elements at the front, which we are
 * removing
 * update res with r
 * to remove postfix/middle
 * we will expand the invalid window by moving r ptr by 1
 * this will remove postfix as well as middle
 * then update res with size of window
 * we also need to move l ptr to end of increasing sequence in prefix
 * for l if element at i+1 is greater than i, break the loop and return the res,
 * as there is no increasing sequence in prefix
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {

        // remove prefix
        int n = arr.length;
        int r = n - 1;
        while (r > 0 && arr[r - 1] <= arr[r]) {
            r -= 1;
        }

        int res = r;

        // remove postfix and middle
        int l = 0;
        while (l < r) {
            while (r < n && arr[l] > arr[r]) {
                r += 1;
            }
            res = Math.min(res, r - l - 1);
            if (arr[l] > arr[l + 1])
                break;
            l += 1;
        }
        return res;
    }
}