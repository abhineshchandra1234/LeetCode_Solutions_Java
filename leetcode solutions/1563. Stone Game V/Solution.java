// 1563. Stone Game V

/**
 * Intuition
 * we will first find the prefix sum of the whole array, so that we can find sum
 * of left and right half
 * then we will call recursion from 0 to n-1
 * our first base condition if l is greater than or equal to r return zero
 * our second base condition is if curr l and r is already solved return it
 * then we would take mid from l to r
 * we will calculate left sum and right sum for each mid
 * if left sum is less than right sum, we will discard right sum and call
 * recursion from l to mid
 * if left sum is greater than right sum. we will discard left sum and call
 * recursion from mid+1 to r
 * if both left sum and right sum are equal, we will take max of left sum and
 * right sum and call recusrion on it
 * then we will store score in curr [l][r] and return it
 * Approach
 * 
 * Complexity
 * Time complexity: O(n^3)
 * Space complexity: O(n^2)
 */

class Solution {

    int[][] t = new int[501][501];

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] pre = new int[n];
        pre[0] = stoneValue[0];

        for (int i = 1; i < n; i++)
            pre[i] = pre[i - 1] + stoneValue[i];

        for (int[] row : t)
            Arrays.fill(row, -1);

        return solve(0, n - 1, pre);
    }

    private int solve(int l, int r, int[] pre) {
        if (l >= r)
            return 0;

        if (t[l][r] != -1)
            return t[l][r];

        int score = 0;
        for (int mid = l; mid <= r - 1; mid++) {
            int leftSum = pre[mid] - (l - 1 >= 0 ? pre[l - 1] : 0);
            int righSum = pre[r] - pre[mid];

            if (leftSum < righSum)
                score = Math.max(score, leftSum + solve(l, mid, pre));
            else if (leftSum > righSum)
                score = Math.max(score, righSum + solve(mid + 1, r, pre));
            else
                score = Math.max(score, Math.max(leftSum + solve(l, mid, pre),
                        righSum + solve(mid + 1, r, pre)));
        }
        return t[l][r] = score;
    }
}