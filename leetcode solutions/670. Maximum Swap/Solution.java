/**
 * 670. Maximum Swap
 * 
 * Intuition
 * In brute force we need to compare each no with other nos to find correct swap
 * It will take O(n^2) time
 * we need nos to be in monotonic decreasing way
 * we will traverse num backwards
 * find max no and store its index
 * if the curr no is less than max, we need to swap it with max no
 * store the index of curr no and max to be swapped
 * At last we will swap the nos and return the res.
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {
    public int maximumSwap(int num) {

        char[] a = Integer.toString(num).toCharArray();
        int n = a.length;
        int maxIdx = -1, sIdx1 = -1, sIdx2 = -1;

        for (int i = n - 1; i >= 0; i--) {
            if (maxIdx == -1 || a[i] > a[maxIdx]) {
                maxIdx = i;
            } else if (a[i] < a[maxIdx]) {
                sIdx1 = i;
                sIdx2 = maxIdx;
            }
        }

        if (sIdx1 != -1 && sIdx2 != -1) {
            char temp = a[sIdx1];
            a[sIdx1] = a[sIdx2];
            a[sIdx2] = temp;
        }

        return Integer.parseInt(new String(a));
    }
}