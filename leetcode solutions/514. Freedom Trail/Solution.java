/**
 * 514. Freedom Trail
 * 
 * Intuition
 * 
 * This problem is very tricky to understand
 * we will solve this problem through dynamic programming
 * we will have two ptrs one ptr for 12 index and second ptr for key
 * we will traverse ring and if any char matches char at pt2, we will update
 * total steps
 * Total steps will be min of steps and steps for current char and pt2 and rest
 * of the chars and pt2
 * steps for curr char will be min of clockiwise ie pt1-i and anti-clockwise ie
 * n - (pt1-i) + 1 steps, + 1 for click
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(K* R^2), for every char in the ring k
 * recursive call are made, one for each letter in the keyword. So if there are
 * duplicate chars in ring R^2 * k
 * 
 * Space complexity: O(K*R^2), recursive stack
 * 
 */
class Solution {
    public int findRotateSteps(String ring, String key) {

        int n = ring.length();
        int m = key.length();

        Integer[][] dp = new Integer[n][m];

        return rec(ring, key, 0, 0, dp);
    }

    private int rec(String ring, String key, int pt1, int pt2, Integer[][] dp) {

        int n = ring.length();
        int m = key.length();

        if (pt2 >= m)
            return 0;

        if (dp[pt1][pt2] != null)
            return dp[pt1][pt2];

        int steps = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (ring.charAt(i) == key.charAt(pt2)) {
                steps = Math.min(steps, Math.min(Math.abs(pt1 - i), n - (Math.abs(pt1 - i))) + 1 +
                        rec(ring, key, i, pt2 + 1, dp));
            }
        }
        return dp[pt1][pt2] = steps;
    }
}