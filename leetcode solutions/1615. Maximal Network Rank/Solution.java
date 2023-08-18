/**
 * 1615. Maximal Network Rank
 * 
 * Intuition
 * 
 * credits hobiter
 * we will solve this problem using brute force
 * We will have a boolean array of size [n][n], to store value that there is a
 * direct path between two cities
 * we will count the no of roads each city is part of.
 * then using all possible pairs of roads update res, if there is a direct path
 * subtract 1 from total road count.
 * 
 * Approach
 * 
 * Input: n = 4, roads = [[0,1],[0,3],[1,2],[1,3]]
 * Output: 4
 * For pair (0,1)
 * 0 is connected with 2 roads and 1 is connected with 3 roads
 * total roads = 2+3 = 5
 * since they are directly connected total roads = 5-1= 4
 * 
 * Complexity
 * 
 * Time complexity: O(n^2)
 * 
 * Space complexity: O(n^2)
 * 
 */
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {

        boolean[][] connected = new boolean[n][n];
        int[] cnts = new int[n];

        for (int[] r : roads) {
            cnts[r[0]]++;
            cnts[r[1]]++;
            connected[r[0]][r[1]] = true;
            connected[r[1]][r[0]] = true;
        }

        int res = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                res = Math.max(res, cnts[i] + cnts[j] - (connected[i][j] ? 1 : 0));

        return res;
    }
}