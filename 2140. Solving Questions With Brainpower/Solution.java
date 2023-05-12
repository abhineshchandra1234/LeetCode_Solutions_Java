/**
 * 2140. Solving Questions With Brainpower
 * 
 * Intuition
 * We can solve this using dp as there is choice involved either to pick or
 * leave.
 * For each index we have two options
 * we can collect points of curr index and skip next
 * brainpoweribrainpower_ibrainpower
 * i
 * ​
 * indexes
 * we can skip curr index and select next index
 * we will assign max of above two values to each index
 * each dp[i] will represent max points from i to n
 * we will return result at dp[0]
 * 
 * Approach
 * Math.min(i+jump+1,n)
 * used above to avoid out of bounds
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {
    public long mostPoints(int[][] questions) {

        int n = questions.length;
        long dp[] = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int points = questions[i][0], jump = questions[i][1];
            dp[i] = Math.max(points + dp[Math.min(i + jump + 1, n)], dp[i + 1]);
        }
        return dp[0];
    }
}