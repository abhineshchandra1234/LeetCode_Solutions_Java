/**
 * 2285. Maximum Total Importance of Roads
 * 
 * Intuition
 * 
 * we are given n cities numbered from 0 to n-1
 * we are also given a roads array where ri = [ai, bi], means it connects two
 * cities bi-directionally
 * we need to assign nos from 1 to n to each city
 * importance of a road is sum of two cities its connect
 * we need to return max total importance of all roads by assigning them value
 * optimally
 * cities with the highest degrees or connections will be assigned most value as
 * it will contribute more to the total sum
 * 
 * Approach
 * 
 * Calculate connections - First calculate connections or indegree of each city
 * Sort connections - Sort the connections or indegree
 * Calculate total - Assign importance to cities based on connections and
 * calculate res
 * 
 * Complexity
 * 
 * Time complexity: O(nlogn), sorting connections
 * 
 * Space complexity: O(n), storing connections
 * 
 */
class Solution {

    public long maximumImportance(int n, int[][] roads) {

        long res = 0;
        int cost = 1;
        long[] conn = new long[n];

        for (int i = 0; i < roads.length; i++) {
            conn[roads[i][0]]++;
            conn[roads[i][1]]++;
        }

        Arrays.sort(conn);

        for (int i = 0; i < n; i++)
            res += conn[i] * cost++;
        return res;
    }
}