/**
 * 1802. Maximum Value at a Given Index in a Bounded Array
 * 
 * Intuition
 * credits Aryan, Armorix
 * We will put maximum no at the given index. Inorder for it to be maximum. Its
 * either sides must strictly decreasing by 1 till 1 and continue as 1.
 * we can put max maxSum at the index. we will apply binary search on it and
 * valid case will be leftSum + mid + rightSum<=maxSum
 * 1 <= mid <= maxSum
 * like - 4,5,4,3 , index = 1
 * like - 2,3,2,1,1,1 , index = 1
 * 
 * Complexity
 * Time complexity: O(logn)
 * Space complexity: O(1)
 */
class Solution {
    public int maxValue(int n, int index, int maxSum) {

        int emptyR = n - index - 1;
        int emptyL = index;

        int h = maxSum, l = 1;
        int res = 0;

        while (l <= h) {
            int mid = l + (h - l) / 2;

            long leftSum = 0, rightSum = 0, el = mid - 1;

            if (emptyR <= el)
                rightSum = (el * (el + 1)) / 2 - ((el - emptyR) * (el - emptyR + 1)) / 2;
            else
                rightSum = (el * (el + 1)) / 2 + (emptyR - el);

            if (emptyL <= el)
                leftSum = (el * (el + 1)) / 2 - ((el - emptyL) * (el - emptyL + 1)) / 2;
            else
                leftSum = (el * (el + 1)) / 2 + (emptyL - el);

            long sum = leftSum + mid + rightSum;

            if (sum <= maxSum) {
                l = mid + 1;
                res = mid;
            } else
                h = mid - 1;
        }
        return res;
    }
}