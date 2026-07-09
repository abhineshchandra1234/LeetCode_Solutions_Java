// 3532. Path Existence Queries in a Graph I

/**
 * Intuition
 * we can easily solve this problem through DSU
 * we will look at another approach
 * we will divide nodes into different components
 * two nodes will belong to same component if their diff is less than maxDiff
 * Later we will traverse queries check nodes component, if same add true to res
 * otherwise false
 * we will check two adajacent nodes, if their diff is less than maxDiff, they
 * belong to same component
 * if they do not, no left nodes and no right nodes of the curr nodes will form
 * a pair whose diff is less than maxDiff as they are max for left nodes and min
 * for right nodes, as they are sorted
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] comp = new int[n];
        comp[0] = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] <= maxDiff)
                comp[i] = comp[i - 1];
            else
                comp[i] = comp[i - 1] + 1;
        }

        boolean[] ans = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++)
            ans[i] = (comp[queries[i][0]] == comp[queries[i][1]]);

        return ans;
    }
}