// 1340. Jump Game V

/**
 * Intuition
 * DFS
 * we will solve this problem through dp
 * for each index we need max no of jumps
 * we will traverse each index and for each index we will traverse d indices
 * left and right,
 * update res with max of res and each indices of left till d
 * update res with max of res and each indices of right till d
 * later assign this res to curr index, to maintain memoization
 * boottom-up
 * From above we know we need to traverse left and right till d
 * So if we traverse arr from left, we will not have res for forwad indices
 * if we traverse arr from right, again we will not have res for forwad indices
 * so we will do sorting, and can traverse from left to right
 * Approach
 * 
 * Complexity
 * Time complexity: O(n*d), we are visting each index once, and for each index
 * we are visting d more indices once
 * Space complexity: O(n), we are storing n indices res
 */

// DFS
class Solution {
    int n;
    int[] t;

    public int maxJumps(int[] arr, int d) {
        n = arr.length;
        t = new int[n];
        Arrays.fill(t, -1);

        int maxJ = 1;
        for (int i = 0; i < n; i++)
            maxJ = Math.max(maxJ, solve(arr, d, i));
        return maxJ;
    }

    private int solve(int[] arr, int d, int i) {
        if (t[i] != -1)
            return t[i];
        int res = 1;
        // move left
        for (int j = i - 1; j >= Math.max(0, i - d); j--) {
            if (arr[j] >= arr[i])
                break;
            res = Math.max(res, 1 + solve(arr, d, j));
        }
        // move right
        for (int j = i + 1; j <= Math.min(n - 1, i + d); j++) {
            if (arr[j] >= arr[i])
                break;
            res = Math.max(res, 1 + solve(arr, d, j));
        }

        return t[i] = res;
    }
}

// bottom-up
class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        // t[i] = maximum jumps starting from index i
        int[] t = new int[n];
        Arrays.fill(t, 1);

        /*
         * In recursion + memoization:
         * solve(i) depends on smaller elements only.
         * So in bottom-up, process smaller values first.
         */
        int[][] vec = new int[n][2];
        for (int i = 0; i < n; i++) {
            vec[i][0] = arr[i];
            vec[i][1] = i;
        }
        Arrays.sort(vec, (a, b) -> a[0] - b[0]);

        for (int[] it : vec) {
            int i = it[1];

            // move left
            for (int j = i - 1; j >= Math.max(0, i - d); j--) {
                // same breaking condition
                if (arr[j] >= arr[i])
                    break;
                t[i] = Math.max(t[i], 1 + t[j]);
            }

            // move right
            for (int j = i + 1; j <= Math.min(n - 1, i + d); j++) {
                // same breaking condition
                if (arr[j] >= arr[i])
                    break;
                t[i] = Math.max(t[i], 1 + t[j]);
            }
        }

        return Arrays.stream(t).max().getAsInt();
    }
}